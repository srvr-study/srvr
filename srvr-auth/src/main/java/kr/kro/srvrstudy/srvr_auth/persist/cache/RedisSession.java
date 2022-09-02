package kr.kro.srvrstudy.srvr_auth.persist.cache;

import kr.kro.srvrstudy.srvr_auth.persist.entity.Session;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

/*
todo 레디스에 저장되는 세션용 객체, 스프링 시큐리티의 authentication 객체? 이것도 알아볼 것
 */
@RedisHash("RedisSession")
@Getter
public class RedisSession {

    @Id
    private String sessionKey;
    private final String username;
    private final LocalDateTime lastLoggedInAt;

    public RedisSession(String sessionKey, String username, LocalDateTime lastLoggedInAt) {
        this.sessionKey = sessionKey;
        this.username = username;
        this.lastLoggedInAt = lastLoggedInAt;
    }

    public Session toSession() {
        return new Session(sessionKey, username, lastLoggedInAt);
    }
}
