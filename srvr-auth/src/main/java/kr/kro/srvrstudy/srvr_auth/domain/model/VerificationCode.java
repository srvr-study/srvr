package kr.kro.srvrstudy.srvr_auth.domain.model;

import java.util.UUID;

public class VerificationCode {

    private static String code;

    public static String generate() {
        code = UUID.randomUUID().toString().substring(0, 8);
        return code;
    }
}
