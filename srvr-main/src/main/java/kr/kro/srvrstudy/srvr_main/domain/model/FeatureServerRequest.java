package kr.kro.srvrstudy.srvr_main.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeatureServerRequest {

    private final String host;
    private final String name;
    private final String description;
    private final Long updatorMemberId;

}
