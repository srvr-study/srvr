package kr.kro.srvrstudy.srvr_auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisRepositories
@EnableRedisHttpSession
public class RedisConfig {
}
