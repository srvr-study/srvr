package kr.kro.srvrstudy.srvr_auth.presentation.controller;

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

    @GetMapping("/me")
    public ApiResponse<User> me(@SessionUser User user) {
        return new SuccessResponse<>(user);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody Login.Req req) {
        String sessionKey = userService.login(req.getUsername(), req.getPassword());

        return new SuccessResponse<>(sessionKey);
    }

    @PostMapping("/join")
    public ApiResponse<Void> join(@RequestBody Join.Req req) {
        log.info("[auth] join {}", req);
        userService.join(req);
        return new SuccessResponse<>();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestParam String sessionKey) {
        log.info("[auth] logout sessionKey {}", sessionKey);
        userService.logout(sessionKey);
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

