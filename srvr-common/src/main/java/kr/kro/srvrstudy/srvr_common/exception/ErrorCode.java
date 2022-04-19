package kr.kro.srvrstudy.srvr_common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    INVALID_REQUEST(-100000, "Invalid request.");

    private final long code;
    private final String message;

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
