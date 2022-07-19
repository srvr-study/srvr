package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.common.encryption.SHA256;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final MailService mailService;
    private final UserRepository userRepository;

    public void join(JoinDTO.Req req) {
        Validator.validateEmpty(req.getUsername(), userRepository::findById);
        Validator.validateEmpty(req.getEmail(), userRepository::findUserEntityByEmail);

        JoinDTO.Req encryptReq = req.encryptPassword(SHA256.encrypt(req.getPassword(), req.getUsername()));
        log.debug("request model: {}, password length: {}", encryptReq, encryptReq.getPassword().length());
        UserEntity user = new UserEntity(encryptReq);

        userRepository.save(user);
    }

    public void login(String username, String password) {
        // todo 1. 세션 존재 여부 확인
        // todo 2. 세션 존재시 세션 삭제
        // todo 3. 세션 생성
        // todo 4. 세션 엔티티 저장 및 redis에 session 저장
    }

    public void logout() {

    }

    public void checkUsernameDuplicate(String username) {
        Validator.validateEmpty(username, userRepository::findById);
    }

    public boolean sendCodeMail(String email, long ttl) {
        Validator.validateNotEmpty(email, userRepository::findUserEntityByEmail);

        return mailService.sendCodeMail(email, ttl);
    }

}
