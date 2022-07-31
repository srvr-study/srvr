package kr.kro.srvrstudy.srvr_auth.domain.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.kro.srvrstudy.srvr_auth.domain.model.auth.FindPasswordDTO;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private final ValueOperations<String, Object> valueOperations;

    private static final String REDIS_KEY = "auth:password-code:";

    public boolean sendCodeMail(String email, long ttl) {

        final String code = UUID.randomUUID().toString().substring(0, 8);

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("인증메일입니다.");
        message.setText("<p>" + "인증 코드 " + code + "</p>");

        try {
            javaMailSender.send(message);
            valueOperations.set(REDIS_KEY + email, code, ttl, TimeUnit.SECONDS);

            return true;
        } catch (Exception e) {
            log.warn("[auth] sendCodeMail : 메일 전송 실패 {}", email);
            return false;
        }
    }

    public boolean checkCode(FindPasswordDTO.Req req) {

        final String key = REDIS_KEY + req.getEmail();
        final String code = (String) valueOperations.get(key);

        if (!req.getCode().equals(code)) {
            return false;
        }

        valueOperations.set(key, code, 0L, TimeUnit.SECONDS);
        return true;
    }
}
