package kr.kro.srvrstudy.srvr_main.domain.service.auth;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.Join;
import kr.kro.srvrstudy.srvr_common.dto.Login;
import kr.kro.srvrstudy.srvr_main.config.FeignClientConfig;
import kr.kro.srvrstudy.srvr_main.domain.model.auth.FindPassword;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-client", url = "${auth-api.url}/api/v1/auth", configuration = FeignClientConfig.class)
public interface UserService {

    @PostMapping("/join")
    ApiResponse<Void> join(@RequestBody Join.Req req);

    @PostMapping("/{username}/check")
    ApiResponse<Void> checkUsernameDuplicate(@PathVariable String username);

    @PostMapping("/login")
    ApiResponse<Void> login(@RequestBody Login.Req req);

    @GetMapping("/{email}/password-code")
    ApiResponse<String> requestSendCodeMail(@PathVariable String email);

    @PostMapping("/password-code-check")
    ApiResponse<String> checkFindPasswordCode(@RequestBody FindPassword.Req req);

}

