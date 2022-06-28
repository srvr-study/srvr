package kr.kro.srvrstudy.srvr_common.exception;

import lombok.Getter;

@Getter
public class ApiFailureException extends RuntimeException {

    private static final long serialVersionUID = 731492746908245878L;

    private final ErrorCode errorCode;

    public ApiFailureException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiFailureException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }
}
