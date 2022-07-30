package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.common.encryption.SHA256;
import kr.kro.srvrstudy.srvr_auth.domain.service.model.auth.FindPasswordDTO;
import kr.kro.srvrstudy.srvr_auth.persist.cache.RedisSession;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.exception.ApiFailureException;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final MailService mailService;
    private final UserRepository userRepository;
    private final SessionService sessionService;

    public void join(JoinDTO.Req req) {
        Validator.validateEmpty(req.getUsername(), userRepository::findById);
        Validator.validateEmpty(req.getEmail(), userRepository::findByEmail);

        JoinDTO.Req encryptReq = req.encryptPassword(SHA256.encrypt(req.getPassword(), req.getUsername()));
        log.debug("request model: {}, password length: {}", encryptReq, encryptReq.getPassword().length());
        UserEntity user = new UserEntity(encryptReq);

        userRepository.save(user);
    }

    public String login(String username, String password) {
        String encryptedPassword = SHA256.encrypt(password, username);

        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(username, encryptedPassword);
        if (user.isEmpty()) {
            throw new ApiFailureException(ErrorCode.FAILED_TO_MATCH_PASSWORD);
        }
        RedisSession session = sessionService.createSession(username);
        return session.getSessionKey();
    }

    public void logout() {
        // todo logout 기능 구현
    }

    public void checkUsernameDuplicate(String username) {
        Validator.validateEmpty(username, userRepository::findById);
    }

    public boolean sendCodeMail(String email, long ttl) {
        Validator.validateNotEmpty(email, userRepository::findByEmail);

        return mailService.sendCodeMail(email, ttl);
    }

    public boolean checkFindPasswordCode(FindPasswordDTO.Req req) {
        Validator.validateNotEmpty(req.getEmail(), userRepository::findByEmail);

        return mailService.checkCode(req);
    }
}
