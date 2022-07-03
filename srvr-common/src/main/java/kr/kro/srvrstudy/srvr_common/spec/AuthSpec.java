package kr.kro.srvrstudy.srvr_common.spec;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.dto.auth.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthSpec {

    @PostMapping("/user/join")
    ApiResponse<Void> join(@RequestBody UserDTO.JoinReq req);
}
