package kr.kro.srvrstudy.srvr_main.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeatureServer {

    private final String host;
    private final String name;
    private final boolean status;

}
