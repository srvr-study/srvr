package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_auth.common.encryption.SHA256;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(JoinDTO.Req req) {
        Validator.validateEmpty(req.getUsername(), userRepository::findById);
        Validator.validateEmpty(req.getEmail(), userRepository::findUserEntityByEmail);

        JoinDTO.Req encryptReq = req.encryptPassword(SHA256.encrypt(req.getPassword(), req.getUsername()));
        UserEntity user = new UserEntity(encryptReq);

        userRepository.save(user);
    }

    public void login() {

    }

    public void logout() {

    }

}
