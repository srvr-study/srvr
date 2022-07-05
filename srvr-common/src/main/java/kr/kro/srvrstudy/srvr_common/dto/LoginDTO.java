package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Value;

public class LoginDTO {

    @Value
    public static class Req {
        String username;
        String password;
    }
}
