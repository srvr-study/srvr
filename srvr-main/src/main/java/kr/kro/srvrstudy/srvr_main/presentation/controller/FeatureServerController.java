package kr.kro.srvrstudy.srvr_main.presentation.controller;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.api.response.SuccessResponse;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServerRequest;
import kr.kro.srvrstudy.srvr_main.domain.service.FeatureServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FeatureServerController {

    private final SimpMessagingTemplate template;
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
    public ApiResponse<Void> updateFeatureServer(@PathVariable("name") String featureServerName,
                                                 @RequestBody FeatureServerRequest featureServerRequest) {
        featureServerService.updateFeatureServer(featureServerName, featureServerRequest);
        template.convertAndSend("/sub/feature-servers", featureServerService.getRealTimeFeatureServers());
        return new SuccessResponse<>();
    }

    @DeleteMapping("/feature-servers/{name}")
    public ApiResponse<Void> deleteFeatureServer(@ModelAttribute("feature-server") FeatureServer featureServer) {
        featureServerService.deleteFeatureServer(featureServer);
        template.convertAndSend("/sub/feature-servers", featureServerService.getRealTimeFeatureServers());
        return new SuccessResponse<>();
    }

    @ModelAttribute(value = "feature-server")
    public FeatureServer getFeatureServer(@PathVariable("name") String name) {
        return featureServerService.getByFeatureServerName(name);
    }
}
