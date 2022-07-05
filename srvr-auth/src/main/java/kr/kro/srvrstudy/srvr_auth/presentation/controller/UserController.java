package kr.kro.srvrstudy.srvr_auth.presentation.controller;

import kr.kro.srvrstudy.srvr_auth.domain.service.UserService;
import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.dto.LoginDTO;
import kr.kro.srvrstudy.srvr_common.spec.AuthSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController implements AuthSpec {

    private final UserService userService;

    @Override
    @PostMapping("/join")
    public ApiResponse<Void> join(@RequestBody JoinDTO.Req req) {
        log.info("[auth] join {}", req);
        userService.join(req);
        return new SuccessResponse<>();
    }

    @PostMapping("/login")
    public ApiResponse<Void> login(@RequestBody LoginDTO.Req req) {
        /*
        todo 1. 클라는 메인을 호출, 로그인, 로그아웃, 회원가입 등 메인이 요청을 받으면 인증에 전달하는 방식
        todo 2. 클라는 메인서버와 웹소켓으로 연결되있다. 로그인 여부를 어떻게 구현해야 할까.. 오래되서 기억이 안난다.. 클라가 웹페이지에 접속하면 세션을 날렷던가? 날리면 그냥 그거 캡쳐해서 그걸로 확인하면 될듯
        todo 3. 세션은 인메모리보다는 레디스를 활용하면 좋을 듯
         */
        return null;
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout() {
        return null;
    }
}
