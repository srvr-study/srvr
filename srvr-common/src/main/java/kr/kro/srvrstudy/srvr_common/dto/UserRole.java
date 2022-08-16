package kr.kro.srvrstudy.srvr_common.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Getter
@Slf4j
public enum UserRole {
    ADMIN, MEMBER;

    @JsonValue
    @Override
    public String toString(){
        return this.name().toUpperCase();
    }

    @JsonCreator
    public static UserRole from(String value) {
        return Arrays.stream(values())
                     .filter(e -> e.toString().equalsIgnoreCase(value))
                     .findFirst()
                     .orElseThrow(() -> {
                         log.warn("failed to convert user role. value: {}", value);
                         throw new ApiFailureException(ErrorCode.FAILED_TO_CONVERT_ENUM);
                     });
    }
}

