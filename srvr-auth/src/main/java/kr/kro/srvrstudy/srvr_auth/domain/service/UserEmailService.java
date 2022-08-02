package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.domain.model.VerificationCode;
import kr.kro.srvrstudy.srvr_auth.domain.model.auth.FindPassword;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserEmailService {

    private final UserRepository userRepository;
    private final MailService mailService;
    private final ValueOperations<String, String> valueOperations;

    private static final String REDIS_KEY = "auth:password-code:";

    public void sendFindPasswordEmail(String email, Duration ttl) {
        Validator.validateNotEmpty(email, userRepository::findByEmail);

        final String key = REDIS_KEY + email;
        final String verificationCode = VerificationCode.generate();

        mailService.sendCodeMail(email, verificationCode);
        valueOperations.set(key, verificationCode, ttl);
    }

    public void checkFindPasswordCode(FindPassword.Req req) {
        Validator.validateNotEmpty(req.getEmail(), userRepository::findByEmail);

        final String key = REDIS_KEY + req.getEmail();
        final String verificationCode =
                Optional.ofNullable(valueOperations.get(key))
                        .filter(code -> req.getCode().equals(code))
                        .orElseThrow(() -> new ApiFailureException(ErrorCode.INVALID_VERIFICATION_CODE));

        valueOperations.set(key, verificationCode, 0L, TimeUnit.SECONDS);
    }

}
