package kr.kro.srvrstudy.srvr_main.presentation.scheduler;

import kr.kro.srvrstudy.srvr_main.domain.service.FeatureServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class FeatureServerHealthChecker {

    private final SimpMessagingTemplate template;
    private final FeatureServerService featureServerService;

    @Scheduled(fixedDelay = 10000)
    public void healthCheck(){
        template.convertAndSend("/sub/feature-servers", featureServerService.getRealTimeFeatureServers());
    }

}
