package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.persist.cache.RedisSession;
import kr.kro.srvrstudy.srvr_auth.persist.repository.SessionRepository;
import kr.kro.srvrstudy.srvr_auth.persist.repository.redis.RedisSessionRepository;
import kr.kro.srvrstudy.srvr_common.helper.IdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class SessionService {

    private final RedisSessionRepository redisSessionRepository;
    private final SessionRepository sessionRepository;


    public RedisSession createSession(String username) {
        if (redisSessionRepository.findByUsername(username).isPresent()) {
            redisSessionRepository.delete(redisSessionRepository.findByUsername(username).get());
        }

        RedisSession redisSession = new RedisSession(IdGenerator.generateUUID().toString(), username, LocalDateTime.now());

        sessionRepository.save(redisSessionRepository.save(redisSession).toSession());
        return redisSession;
    }
}
