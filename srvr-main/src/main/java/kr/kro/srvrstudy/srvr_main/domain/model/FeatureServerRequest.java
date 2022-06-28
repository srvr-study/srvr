package kr.kro.srvrstudy.srvr_main.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeatureServerRequest {

    private final String host;
    private final String name;
    private final String description;

    @JsonSerialize(using= ToStringSerializer.class)
    private final Long updatorMemberId;

}
