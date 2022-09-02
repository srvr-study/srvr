package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Join {
    private Join() {
        throw new AssertionError("Join objects cannot be initiate");
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Req {

        private String username;
        private String email;
        private String password;
        private String role;

        public Req(String username, String email, String password, String role) {
            this.username = username;
            this.email = email;
            this.password = password;
            this.role = role;
        }

        public Req encryptPassword(String encryptedPassword) {
            return new Req(this.username, this.email, encryptedPassword, this.role);
        }
    }
}
