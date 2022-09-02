package kr.kro.srvrstudy.srvr_main.presentation.controller.advisor;

import feign.FeignException;
import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.FailureResponse;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRestControllerAdvisor {

    @ExceptionHandler(value = ApiFailureException.class)
    public ApiResponse<Void> handleApiFailureException(ApiFailureException e) {
        log.error("[ERROR][SRVR-MAIN] code: {}, message: {}", e.getErrorCode().getCode(), e.getErrorCode().getMessage(), e);
        return new FailureResponse<>(e.getErrorCode());
    }

    @ExceptionHandler(value = FeignException.BadRequest.class)
    public ApiResponse<Void> handleFeignException(FeignException.BadRequest e) {
        log.error("[FEIGN_ERROR][SRVR-MAIN] url: {}, message: {}", e.request().url(), e.getMessage(), e);
        return new FailureResponse<>(ErrorCode.DUPLICATE_TARGET);
    }
}
