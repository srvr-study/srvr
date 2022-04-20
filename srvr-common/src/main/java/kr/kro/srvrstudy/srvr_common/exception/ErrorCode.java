package kr.kro.srvrstudy.srvr_common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_REQUEST(-100000, "Invalid request exception"),
    ALREADY_EXISTS(-110000, "Already exists"),
    DUPLICATE_TARGET(-120000, "Duplicate target exception"),
    NOT_FOUND_ENTITY(-200000, "Not found entity");

    private final long code;
    private final String message;

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

}
