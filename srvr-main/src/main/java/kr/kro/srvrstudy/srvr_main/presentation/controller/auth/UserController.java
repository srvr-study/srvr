package kr.kro.srvrstudy.srvr_main.presentation.controller.auth;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.dto.Login;
import kr.kro.srvrstudy.srvr_common.dto.User;
import kr.kro.srvrstudy.srvr_main.domain.model.auth.FindPassword;
import kr.kro.srvrstudy.srvr_main.domain.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @GetMapping("/me")
    public ApiResponse<User> me() {
        return userService.me();
    }

    @PostMapping("/join")
    public ApiResponse<Void> join(@RequestBody Join.Req req) {
        log.info("main: join {}", req);
        return userService.join(req);
    }

    @PostMapping("/{username}/check")
    public ApiResponse<Void> checkUsernameDuplicate(@PathVariable String username) {
        log.info("main: checkUsernameDuplicate {}", username);
        return userService.checkUsernameDuplicate(username);
    }

    @PostMapping("/login")
    public ApiResponse<String> login(HttpServletResponse httpServletResponse, @RequestBody Login.Req req) {
        log.info("main: login {}", req);

        ApiResponse<String> response = userService.login(req);

        return response;
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("main: logout");

//        String sessionKey = sessionCookieUtil.getSessionKey(httpServletRequest);

//        userService.logout(sessionKey);

//        Cookie cookie = sessionCookieUtil.delete(sessionKey);
//        httpServletResponse.addCookie(cookie);

        return null;
    }

    @PostMapping("/{email}/password-code")
    public ApiResponse<String> requestSendCodeMail(@PathVariable String email) {
        log.info("main: requestSendCodeMail {}", email);
        return userService.requestSendCodeMail(email);
    }

    @PostMapping("/password-code-check")
    public ApiResponse<String> checkFindPasswordCode(@RequestBody FindPassword.Req req) {
        log.info("main: checkFindPasswordCode {}", req);
        return userService.checkFindPasswordCode(req);
    }

}
