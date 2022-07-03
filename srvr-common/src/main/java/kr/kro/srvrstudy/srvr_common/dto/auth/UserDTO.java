package kr.kro.srvrstudy.srvr_common.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserDTO {

    @Data
    public static class LoginReq {
        String username;
        String password;
    }

    @Data
    public static class JoinReq {
        String username;
        String email;
        String password;
        String repassword;
    }
}
