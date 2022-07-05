package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Value;

public class JoinDTO {

    @Value
    public static class Req {
        String username;
        String email;
        String password;

        public Req encryptPassword(String encryptedPassword) {
            return new Req(this.username, this.email, encryptedPassword);
        }
    }
}
