package kr.kro.srvrstudy.srvr_main.domain.service;

import kr.kro.srvrstudy.srvr_common.helper.IdGenerator;
import kr.kro.srvrstudy.srvr_main.domain.model.Tag;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import kr.kro.srvrstudy.srvr_main.persist.entity.TagEntity;
import kr.kro.srvrstudy.srvr_main.persist.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getTags() {
        return tagRepository.findAll().stream()
                            .map(Tag::of)
                            .collect(Collectors.toList());
    }

    @Transactional
    public void createTag(Tag tag) {
        Validator.validateEmpty(tag.getName(), tagRepository::findByName);

        TagEntity newTag = TagEntity.builder()
                                    .tagId(IdGenerator.generate())
                                    .name(tag.getName())
                                    .build();
        tagRepository.saveAndFlush(newTag);
    }

    @Transactional
    public void updateTag(Long tagId, Tag tag) {
        Validator.validateNotEmpty(tagId, tagRepository::findById);
        TagEntity tagEntity = tagRepository.getById(tagId);

        tagEntity.setName(tag.getName());
        tagRepository.saveAndFlush(tagEntity);
    }

    @Transactional
    public void deleteTag(Long tagId) {
        Validator.validateNotEmpty(tagId, tagRepository::findById);
        tagRepository.deleteById(tagId);
    }

}
