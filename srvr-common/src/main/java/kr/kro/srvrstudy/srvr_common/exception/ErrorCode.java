package kr.kro.srvrstudy.srvr_common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_REQUEST(-100000, "Invalid request exception"),

    ALREADY_EXISTS(-100100, "Already exists"),
    DUPLICATE_TARGET(-100101, "Duplicate target exception"),
    NOT_FOUND_ENTITY(-100102, "Not found entity"),
    
    FAILED_TO_CONVERT_ENUM(-100200, "Failed to convert enum object"),

    FAILED_TO_MATCH_PASSWORD(-200000, "Failed to match password");

    private final long code;
    private final String message;

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
