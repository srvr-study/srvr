package kr.kro.srvrstudy.srvr_auth.persist.repository.redis;


import kr.kro.srvrstudy.srvr_auth.persist.cache.RedisSession;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RedisSessionRepository extends CrudRepository<RedisSession, String> {

    Optional<RedisSession> findByUsername(String username);

}
