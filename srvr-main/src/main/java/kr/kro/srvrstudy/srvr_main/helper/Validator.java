package kr.kro.srvrstudy.srvr_main.helper;

import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.internal.Function;

import java.util.Optional;

import static kr.kro.srvrstudy.srvr_common.exception.ErrorCode.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Validator  {

    public static <T, E> void validateEmpty(T target, Function<T, Optional<E>> function) {
        validateEmpty(target, function, DUPLICATE_TARGET);
    }

    public static <T, E> void validateEmpty(T target, Function<T, Optional<E>> function, ErrorCode errorCode) {
        boolean present = function.apply(target).isPresent();
        if(present) {
            throw new ApiFailureException(errorCode);
        }
    }

    public static <T, E> void validateNotEmpty(T target, Function<T, Optional<E>> function){
        validateNotEmpty(target, function, NOT_FOUND_ENTITY);
    }

    public static <T, E> void validateNotEmpty(T target, Function<T, Optional<E>> function, ErrorCode errorCode){
        boolean isNull = function.apply(target).isEmpty();
        if (isNull) {
            throw new ApiFailureException(errorCode);
        }
    }

}
