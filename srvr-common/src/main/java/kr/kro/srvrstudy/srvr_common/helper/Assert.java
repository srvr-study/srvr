package kr.kro.srvrstudy.srvr_common.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Objects;

@Slf4j
public class Assert {

    private Assert() {
        throw new AssertionError("Assert can't be initiate");
    }


    public static void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            log.error(message);
            throw new IllegalArgumentException();
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            log.error(message);
            throw new IllegalArgumentException();
        }
    }

    public static void notEmpty(String string, String message) {
        if (Objects.isNull(string) || !StringUtils.hasLength(string)) {
            log.error(message);
            throw new IllegalArgumentException();
        }
    }
}
