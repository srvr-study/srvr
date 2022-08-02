package kr.kro.srvrstudy.srvr_main.presentation.controller.auth;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.dto.Login;
import kr.kro.srvrstudy.srvr_main.domain.model.auth.FindPassword;
import kr.kro.srvrstudy.srvr_main.domain.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

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
    public ApiResponse<Void> login(@RequestBody Login.Req req) {
        log.info("main: login {}", req);
        return userService.login(req);
    }

    @GetMapping("/{email}/password-code")
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
