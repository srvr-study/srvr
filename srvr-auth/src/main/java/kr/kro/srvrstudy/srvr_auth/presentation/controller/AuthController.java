package kr.kro.srvrstudy.srvr_auth.presentation.controller;

import kr.kro.srvrstudy.srvr_auth.common.SessionCookieUtil;
import kr.kro.srvrstudy.srvr_auth.domain.model.SessionUser;
import kr.kro.srvrstudy.srvr_auth.domain.model.User;
import kr.kro.srvrstudy.srvr_auth.domain.model.auth.FindPassword;
import kr.kro.srvrstudy.srvr_auth.domain.service.UserEmailService;
import kr.kro.srvrstudy.srvr_auth.domain.service.UserService;
import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.dto.Login;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserService userService;
    private final UserEmailService userEmailService;
    private final SessionCookieUtil sessionCookieUtil;

    @GetMapping("/me")
    public ApiResponse<User> me(@SessionUser User user) {
        return new SuccessResponse<>(user);
    }

    @PostMapping("/login")
    public ApiResponse<Void> login(HttpServletResponse httpServletResponse, @RequestBody Login.Req req) {
        /*
        todo 1. 클라는 메인을 호출, 로그인, 로그아웃, 회원가입 등 메인이 요청을 받으면 인증에 전달하는 방식
        todo 2. 클라는 메인서버와 웹소켓으로 연결되있다. 로그인 여부를 어떻게 구현해야 할까.. 오래되서 기억이 안난다.. 클라가 웹페이지에 접속하면 세션을 날렷던가? 날리면 그냥 그거 캡쳐해서 그걸로 확인하면 될듯
        todo 3. 세션은 인메모리보다는 레디스를 활용하면 좋을 듯
        todo 4. 세션 저장 후 key 값 cookie에 저장.
         */

        String sessionKey = userService.login(req.getUsername(), req.getPassword());

        Cookie cookie = sessionCookieUtil.generate(sessionKey);
        httpServletResponse.addCookie(cookie);

        return new SuccessResponse<>();
    }

    @PostMapping("/join")
    public ApiResponse<Void> join(@RequestBody Join.Req req) {
        log.info("[auth] join {}", req);
        userService.join(req);
        return new SuccessResponse<>();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("[auth] logout");
        String sessionKey = sessionCookieUtil.getSessionKey(request);
        userService.logout(sessionKey);

        Cookie cookie = sessionCookieUtil.delete(sessionKey);
        response.addCookie(cookie);

        return new SuccessResponse<>();
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

        final Duration ttl = Duration.of(90, ChronoUnit.SECONDS);
        userEmailService.sendFindPasswordEmail(email, ttl);

        return new SuccessResponse<>("인증 코드가 전송되었습니다. " + ttl + "초 이내에 입력해주세요.");
    }

    @PostMapping("/password-code-check")
    public ApiResponse<String> checkFindPasswordCode(@RequestBody @Valid FindPassword.Req req) {
        log.info("[auth] checkFindPasswordCode {}", req);

        userEmailService.checkFindPasswordCode(req);
        return new SuccessResponse<>();
    }
}

