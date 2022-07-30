package kr.kro.srvrstudy.srvr_main.domain.model.auth;

import lombok.Getter;
import lombok.ToString;

public class FindPasswordDTO {

    private FindPasswordDTO() {
        throw new AssertionError("FindPasswordDTO objects cannot be initiate");
    }

    @Getter
    @ToString
    public static class Req {
        private String email;
        private String code;
    }
}