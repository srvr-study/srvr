package kr.kro.srvrstudy.srvr_main.domain.service.auth;

import feign.Headers;
import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.dto.Login;
import kr.kro.srvrstudy.srvr_common.dto.User;
import kr.kro.srvrstudy.srvr_main.config.FeignClientConfig;
import kr.kro.srvrstudy.srvr_main.domain.model.auth.FindPassword;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-client", url = "${auth-api.url}/api/v1/auth", configuration = FeignClientConfig.class)
@Headers("cookie: {value}")
public interface UserService {

    @GetMapping("/me")
    ApiResponse<User> me();

    @PostMapping("/join")
    ApiResponse<Void> join(@RequestBody Join.Req req);

    @PostMapping("/{username}/check")
    ApiResponse<Void> checkUsernameDuplicate(@PathVariable String username);

    @PostMapping("/login")
    ApiResponse<String> login(@RequestBody Login.Req req);

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestParam String sessionKey);

    @PostMapping("/{email}/password-code")
    ApiResponse<String> requestSendCodeMail(@PathVariable String email);

    @PostMapping("/password-code-check")
    ApiResponse<String> checkFindPasswordCode(@RequestBody FindPassword.Req req);

}

