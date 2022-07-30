package kr.kro.srvrstudy.srvr_auth.domain.service.model.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class FindPasswordDTO {

    private FindPasswordDTO() {
        throw new AssertionError("FindPasswordDTO objects cannot be initiate");
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Req {

        private String email;
        private String code;
    }
}