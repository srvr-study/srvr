package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class JoinDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Req {

        private String username;
        private String email;
        private String password;

        public Req(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public Req encryptPassword(String encryptedPassword) {
            return new Req(this.username, this.email, encryptedPassword);
        }
    }
}
