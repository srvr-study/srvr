package kr.kro.srvrstudy.srvr_auth.domain.model.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// TODO DTO 이름은 쓰지 않는다.
public class FindPassword {

    private FindPassword() {
        throw new AssertionError("FindPasswordDTO objects cannot be initiate");
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Req {

        @NotEmpty
        private String email;
        @NotEmpty
        private String code;
    }
}