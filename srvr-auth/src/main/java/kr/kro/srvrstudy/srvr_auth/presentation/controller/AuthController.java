package kr.kro.srvrstudy.srvr_auth.presentation.controller;

import kr.kro.srvrstudy.srvr_auth.domain.service.UserService;
import kr.kro.srvrstudy.srvr_auth.domain.model.auth.FindPasswordDTO;
import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.FailureResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.dto.LoginDTO;
import kr.kro.srvrstudy.srvr_common.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ApiResponse<Void> login(HttpServletResponse httpServletResponse, @RequestBody LoginDTO.Req req) {
        /*
        todo 1. 클라는 메인을 호출, 로그인, 로그아웃, 회원가입 등 메인이 요청을 받으면 인증에 전달하는 방식
        todo 2. 클라는 메인서버와 웹소켓으로 연결되있다. 로그인 여부를 어떻게 구현해야 할까.. 오래되서 기억이 안난다.. 클라가 웹페이지에 접속하면 세션을 날렷던가? 날리면 그냥 그거 캡쳐해서 그걸로 확인하면 될듯
        todo 3. 세션은 인메모리보다는 레디스를 활용하면 좋을 듯
        todo 4. 세션 저장 후 key 값 cookie에 저장.
         */

        String sessionKey = userService.login(req.getUsername(), req.getPassword());

        Cookie sessionCookie = new Cookie("SRVR_SESSION", sessionKey);
        sessionCookie.setHttpOnly(true);
        sessionCookie.setMaxAge(3600);
        httpServletResponse.addCookie(sessionCookie);

        return new SuccessResponse<>();
    }

    @PostMapping("/join")
    public ApiResponse<Void> join(@RequestBody JoinDTO.Req req) {
        log.info("[auth] join {}", req);
        userService.join(req);
        return new SuccessResponse<>();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout() {
        return null;
    }

    @PostMapping("/{username}/duplicate")
    public ApiResponse<Boolean> checkUsernameDuplicate(@PathVariable String username) {
        log.info("[auth] checkUsernameDuplicate {}", username);
        userService.checkUsernameDuplicate(username);
        return new SuccessResponse<>();
    }

    @PostMapping("/{email}/password-code")
    public ApiResponse<String> requestSendCodeMail(@PathVariable String email) {
        log.info("[auth] requestSendCodeMail {}", email);

        final long ttl = 90;
        final boolean isSuccess = userService.sendCodeMail(email, ttl);

        if (isSuccess) {
            return new SuccessResponse<>("인증 코드가 전송되었습니다. " + ttl + "초 이내에 입력해주세요");
        } else {
            return new FailureResponse<>(ErrorCode.INVALID_REQUEST, "메일 전송에 실패했습니다. 잠시 후 다시 시도해 주세요.");
        }
    }

    @PostMapping("/password-code-check")
    public ApiResponse<String> checkFindPasswordCode(@RequestBody FindPasswordDTO.Req req) {
        log.info("[auth] checkFindPasswordCode {}", req);

        final boolean isMatch = userService.checkFindPasswordCode(req);

        if (isMatch) {
            return new SuccessResponse<>();
        } else {
            return new FailureResponse<>(ErrorCode.INVALID_REQUEST, "인증번호가 일치하지 않습니다.");
        }
    }
}

