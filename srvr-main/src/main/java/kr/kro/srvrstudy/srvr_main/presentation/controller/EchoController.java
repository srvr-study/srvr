package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/echo")
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