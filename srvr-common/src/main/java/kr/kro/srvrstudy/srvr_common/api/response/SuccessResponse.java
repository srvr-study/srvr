package kr.kro.srvrstudy.srvr_common.api.response;

import java.util.Collection;

public class SuccessResponse<T> extends ApiResponse<T> {

    public SuccessResponse() {
        super(new BodyHeader(true, "", 0), null);
    }

    public SuccessResponse(T body) {
        super(new BodyHeader(true, "", 0), new BodyContent<>(body));
    }

    public SuccessResponse(Collection<T> body) {
        super(new BodyHeader(true, "", 0), new BodyContent<>(body));
    }
}
