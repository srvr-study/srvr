package kr.kro.srvrstudy.srvr_auth.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.srvrstudy.srvr_auth.persist.cache.RedisSession;
import kr.kro.srvrstudy.srvr_auth.persist.repository.SessionRepository;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import kr.kro.srvrstudy.srvr_common.helper.IdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SessionService {

    private static final String REDIS_SESSION_KEY = "auth:session:";
    private static final Duration TTL = Duration.of(30, ChronoUnit.MINUTES);
    private final ValueOperations<String, String> valueOperations;
    private final SessionRepository sessionRepository;
    private final ObjectMapper objectMapper;


    public RedisSession createSession(String username) {
        RedisSession redisSession = new RedisSession(IdGenerator.generateUUID().toString(), username, LocalDateTime.now());

        try {
            valueOperations.set(REDIS_SESSION_KEY + redisSession.getSessionKey(), objectMapper.writeValueAsString(redisSession), TTL);
        } catch (JsonProcessingException e) {
            log.error("failed to write to redis string");
            throw new RuntimeException(e);
        }
        sessionRepository.save(redisSession.toSession());
        return redisSession;
    }

    public RedisSession getRedisSession(String sessionKey) {
        return Optional.ofNullable(valueOperations.get(REDIS_SESSION_KEY + sessionKey))
                       .map(sessionValue -> objectMapper.convertValue(sessionValue, RedisSession.class))
                       .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_SESSION));
    }

    public void deleteSession(String sessionKey) {
        valueOperations.getAndDelete(REDIS_SESSION_KEY + sessionKey);
    }

    public RedisSession extendSession(String sessionKey) {
        return Optional.ofNullable(valueOperations.getAndExpire(REDIS_SESSION_KEY + sessionKey, TTL))
                       .map(sessionValue -> objectMapper.convertValue(sessionValue, RedisSession.class))
                       .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_SESSION));
    }

}
