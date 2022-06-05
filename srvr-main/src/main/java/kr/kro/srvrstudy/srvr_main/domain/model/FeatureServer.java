package kr.kro.srvrstudy.srvr_main.domain.model;

import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerEntity;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerStatus.DISABLED;

@Builder
@Getter
public class FeatureServer {

    private final String host;
    private final String name;
    private final String description;
    private final List<Tag> tags;
    private FeatureServerStatus status;

    public static FeatureServer of(FeatureServerEntity entity) {
        return FeatureServer.builder()
                            .host(entity.getHost())
                            .name(entity.getName())
                            .description(entity.getDescription())
                            .tags(Optional.ofNullable(entity.getFeatureServerTags())
                                          .orElse(Collections.emptyList())
                                          .stream()
                                          .map(FeatureServerTagEntity::getTag)
                                          .map(Tag::of)
                                          .collect(Collectors.toList()))
                            .status(DISABLED)
                            .build();
    }

    public void setStatus(FeatureServerStatus status) {
        this.status = status;
    }

}
