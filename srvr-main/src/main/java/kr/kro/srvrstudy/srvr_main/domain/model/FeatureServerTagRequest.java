package kr.kro.srvrstudy.srvr_main.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FeatureServerTagRequest {

    private Long featureServerId;
    private Long tagId;
    private final boolean isPrimary;

}
