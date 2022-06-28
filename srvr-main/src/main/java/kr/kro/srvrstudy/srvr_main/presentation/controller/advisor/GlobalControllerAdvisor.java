package kr.kro.srvrstudy.srvr_main.presentation.controller.advisor;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.FailureResponse;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvisor {

    @ExceptionHandler(value = ApiFailureException.class)
    public ApiResponse<Void> handleApiFailureException(ApiFailureException e) {
        log.error("[ERROR] code: {}, message: {}", e.getErrorCode().getCode(), e.getErrorCode().getMessage(), e);
        return new FailureResponse<>(e.getErrorCode());
    }
}
