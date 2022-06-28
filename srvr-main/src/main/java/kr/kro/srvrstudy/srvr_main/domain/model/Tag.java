package kr.kro.srvrstudy.srvr_main.domain.model;

import kr.kro.srvrstudy.srvr_main.persist.entity.TagEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Tag {

    private final String name;

    public static Tag of(TagEntity tagEntity) {
        return Tag.builder()
                  .name(tagEntity.getName())
                  .build();
    }

}
