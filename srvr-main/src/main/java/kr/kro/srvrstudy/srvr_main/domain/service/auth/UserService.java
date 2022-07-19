package kr.kro.srvrstudy.srvr_main.domain.service.auth;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.JoinDTO;
import kr.kro.srvrstudy.srvr_common.dto.LoginDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-client", url = "${auth-api.url}")
public interface UserService {

    @PostMapping("/api/v1/auth/join")
    ApiResponse<Void> join(@RequestBody JoinDTO.Req req);

    @PostMapping("/api/v1/auth/{username}/check")
    ApiResponse<Void> checkUsernameDuplicate(@PathVariable String username);

    @PostMapping("/api/v1/auth/login")
    ApiResponse<Void> login(@RequestBody LoginDTO.Req req);

    @GetMapping("/api/v1/auth/{email}/password-code")
    ApiResponse<String> requestSendCodeMail(@PathVariable String email);
}

