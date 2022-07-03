package kr.kro.srvrstudy.srvr_main.domain.service;

import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerTagRequest;
import kr.kro.srvrstudy.srvr_main.domain.model.Tag;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagEntity;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagPk;
import kr.kro.srvrstudy.srvr_main.persist.repository.FeatureServerRepository;
import kr.kro.srvrstudy.srvr_main.persist.repository.FeatureServerTagRepository;
import kr.kro.srvrstudy.srvr_main.persist.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServerTagService {

    private final FeatureServerRepository featureServerRepository;
    private final FeatureServerTagRepository featureServerTagRepository;
    private final TagRepository tagRepository;

    public List<Tag> getTags(Long featureServerId) {
        return featureServerTagRepository.findAllByPk_FeatureServerId(featureServerId).stream()
                                         .map(FeatureServerTagEntity::getTag)
                                         .map(Tag::of)
                                         .collect(Collectors.toList());
    }

    @Transactional
    public void createFeatureServerTag(FeatureServerTagRequest featureServerTagRequest) {
        Validator.validateNotEmpty(featureServerTagRequest.getFeatureServerId(), featureServerRepository::findById);
        Validator.validateNotEmpty(featureServerTagRequest.getTagId(), tagRepository::findById);

        FeatureServerTagPk pk = new FeatureServerTagPk(featureServerTagRequest.getFeatureServerId(), featureServerTagRequest.getTagId());

        Validator.validateEmpty(pk, featureServerTagRepository::findById);

        FeatureServerTagEntity featureServerTagEntity = FeatureServerTagEntity.builder()
                                                             .pk(pk)
                                                             .creatorMemberId(null)
                                                             .build();

        featureServerTagRepository.saveAndFlush(featureServerTagEntity);
    }

    @Transactional
    public void updateFeatureServerTag(FeatureServerTagRequest featureServerTagRequest) {
        FeatureServerTagPk pk = new FeatureServerTagPk(featureServerTagRequest.getFeatureServerId(), featureServerTagRequest.getTagId());
        Validator.validateNotEmpty(pk, featureServerTagRepository::findById);

        FeatureServerTagEntity oldFeatureServerTag = featureServerTagRepository.getById(pk);
        oldFeatureServerTag.setPrimary(featureServerTagRequest.isPrimary());

    }

    public void deleteFeatureServerTag(Long featureServerId, Long tagId) {
        FeatureServerTagPk pk = new FeatureServerTagPk(featureServerId, tagId);
        Validator.validateNotEmpty(pk, featureServerTagRepository::findById);

        featureServerTagRepository.delete(featureServerTagRepository.getById(pk));
    }

}
