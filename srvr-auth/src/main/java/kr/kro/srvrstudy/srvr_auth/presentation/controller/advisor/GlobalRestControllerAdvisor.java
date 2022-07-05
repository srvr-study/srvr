package kr.kro.srvrstudy.srvr_auth.presentation.controller.advisor;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.FailureResponse;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRestControllerAdvisor {

    @ExceptionHandler(value = ApiFailureException.class)
    public ApiResponse<Void> handleApiFailureException(ApiFailureException e) {
        log.error("[ERROR] Api Failure Exception. code: {}, message: {}", e.getErrorCode().getCode(), e.getErrorCode().getMessage(), e);
        return new FailureResponse<>(e.getErrorCode());
    }

    @ExceptionHandler(value = Exception.class)
    public ApiResponse<Void> handleException(Exception e) {
        log.error("[ERROR] Exception. message: {}", e.getMessage(), e);
        return new FailureResponse<>(ErrorCode.INVALID_REQUEST);
    }

}
