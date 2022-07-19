package kr.kro.srvrstudy.srvr_auth.domain.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;

    private static final String REDIS_KEY = "auth:password-code:";

    public boolean sendCodeMail(String email, long ttl) {

        // todo uuid 자르기
        final UUID uuid = UUID.randomUUID();

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("인증메일입니다.");
        message.setText("<p>" + "인증 코드 " + uuid + "</p>");

        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            log.warn("[auth] sendCodeMail : 메일 전송 실패 {}", email);
            return false;
        }

        redisTemplate.opsForValue().set(REDIS_KEY + email, uuid.toString(), ttl, TimeUnit.SECONDS);
        return true;
    }

}
