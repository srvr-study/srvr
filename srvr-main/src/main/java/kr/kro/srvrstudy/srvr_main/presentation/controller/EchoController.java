package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/echo")
public class EchoController {

    @PostMapping("/")
    public ApiResponse<String> post(@RequestBody String body) {
        return new SuccessResponse<>(body);
    }

    @GetMapping("/{path}")
    public ApiResponse<String> getPath(@PathVariable String path) {
        return new SuccessResponse<>(path);
    }

}
