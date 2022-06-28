package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerRequest;
import kr.kro.srvrstudy.srvr_main.domain.service.FeatureServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FeatureServerController {

    private final FeatureServerService featureServerService;

    @GetMapping("/feature-servers")
    public ApiResponse<FeatureServer> getFeatureServers() {
        return new SuccessResponse<>(featureServerService.getFeatureServers());
    }

    @PostMapping("/feature-servers")
    public ApiResponse<Void> createFeatureServer(@RequestBody FeatureServerRequest featureServerRequest) {
        featureServerService.createFeatureServer(featureServerRequest);
        return new SuccessResponse<>();
    }

    @PutMapping("/feature-servers/{name}")
    public ApiResponse<Void> updateFeatureServer(@PathVariable String name,
                                                 @RequestBody FeatureServerRequest featureServerRequest) {

        featureServerService.updateFeatureServer(name, featureServerRequest);
        return new SuccessResponse<>();
    }

    @DeleteMapping("/feature-servers/{name}")
    public ApiResponse<Void> deleteFeatureServer(@PathVariable String name) {
        FeatureServer featureServer = featureServerService.getByFeatureServerName(name);
        featureServerService.deleteFeatureServer(featureServer);
        return new SuccessResponse<>();
    }
}
