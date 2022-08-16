package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.common.encryption.AsymmetricKey;
import kr.kro.srvrstudy.srvr_auth.common.encryption.PasswordValidator;
import kr.kro.srvrstudy.srvr_auth.domain.model.User;
import kr.kro.srvrstudy.srvr_auth.persist.cache.RedisSession;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.passay.PasswordData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final SessionService sessionService;

    public User getUserBy(String sessionKey) {
        RedisSession redisSession = sessionService.getRedisSession(sessionKey);

        UserEntity userEntity = userRepository.getById(redisSession.getUsername());
        return User.from(userEntity);
    }

    public void join(Join.Req req) {
        if (!PasswordValidator.validPassword(new PasswordData(req.getPassword()))) {
            throw new ApiFailureException(ErrorCode.INVALID_PASSWORD);
        }

        Validator.validateEmpty(req.getUsername(), userRepository::findById);
        Validator.validateEmpty(req.getEmail(), userRepository::findByEmail);

        Join.Req encryptReq = req.encryptPassword(AsymmetricKey.encrypt(req.getPassword(), req.getUsername()));
        log.debug("request model: {}, password length: {}", encryptReq, encryptReq.getPassword().length());
        UserEntity user = new UserEntity(encryptReq);

        userRepository.save(user);
    }

    public String login(String username, String password) {
        if (!PasswordValidator.validPassword(new PasswordData(password))) {
            throw new ApiFailureException(ErrorCode.INVALID_PASSWORD);
        }

        String encryptedPassword = AsymmetricKey.encrypt(password, username);

        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(username, encryptedPassword);
        if (user.isEmpty()) {
            throw new ApiFailureException(ErrorCode.FAILED_TO_MATCH_PASSWORD);
        }

        RedisSession session = sessionService.createSession(username);
        return session.getSessionKey();
    }

    public void logout(String sessionKey) {
        sessionService.deleteSession(sessionKey);
    }

    public void checkUsernameDuplicate(String username) {
        Validator.validateEmpty(username, userRepository::findById);
    }

}
