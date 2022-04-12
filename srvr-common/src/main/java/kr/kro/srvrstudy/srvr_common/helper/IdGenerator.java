package kr.kro.srvrstudy.srvr_common.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdGenerator {

    private static final Long LIMITS_DIGITS = 10_000_000_000_000_000L;

    public static long generate() {
        long time = (System.currentTimeMillis() + generateUUID().getMostSignificantBits());
        return time % LIMITS_DIGITS;
    }

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }
}
