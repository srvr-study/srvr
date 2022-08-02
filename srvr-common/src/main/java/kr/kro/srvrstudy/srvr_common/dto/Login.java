package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Value;

public class Login {

    @Value
    public static class Req {
        String username;
        String password;
    }
}
