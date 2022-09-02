package kr.kro.srvrstudy.srvr_main.domain.model;

import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerEntity;
import kr.kro.srvrstudy.srvr_main.persist.entity.FeatureServerTagEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerStatus.*;

@Builder
@Getter
public class FeatureServer {

    private final String url;
    private final String name;
    private final String description;
    private final List<Tag> tags;
    private FeatureServerStatus status;

    public static FeatureServer of(FeatureServerEntity entity) {
        return FeatureServer.builder()
                .url(entity.getUrl())
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

    public void enable() {
        if (!ENABLED.equals(this.status))
            this.status = ENABLED;
    }

    public void disable() {
        if (!DISABLED.equals(this.status))
            this.status = DISABLED;
    }

    public void develop() {
        if (!DEVELOPING.equals(this.status))
            this.status = DEVELOPING;
    }
}