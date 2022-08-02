package kr.kro.srvrstudy.srvr_common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class Logout {
    private Logout() {
        throw new AssertionError("Join objects cannot be initiate");
    }

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Req {
        String username;
    }
}
