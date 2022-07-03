package kr.kro.srvrstudy.srvr_auth.domain.service;

import kr.kro.srvrstudy.srvr_common.dto.auth.UserDTO;
import kr.kro.srvrstudy.srvr_auth.persist.entity.UserEntity;
import kr.kro.srvrstudy.srvr_auth.persist.repository.UserRepository;
import kr.kro.srvrstudy.srvr_common.helper.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(UserDTO.JoinReq req) {
        Validator.validateEmpty(req.getUsername(), userRepository::findById);

        UserEntity user = new UserEntity(req);
        userRepository.save(user);
    }

    public void login() {

    }

    public void logout() {

    }

}
