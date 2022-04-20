package kr.kro.srvrstudy.srvr_common.api.response;

import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;

import java.util.Collection;

public class FailureResponse<T> extends ApiResponse<T> {

    public FailureResponse(ErrorCode errorCode) {
        super(new BodyHeader(false, errorCode.getMessage(), errorCode.getCode()), null);
    }

    public FailureResponse(ErrorCode errorCode, T body) {
        super(new BodyHeader(false, errorCode.getMessage(), errorCode.getCode()), new BodyContent<>(body));
    }

    public FailureResponse(ErrorCode errorCode, Collection<T> body) {
        super(new BodyHeader(false, errorCode.getMessage(), errorCode.getCode()), new BodyContent<>(body));
    }
}
