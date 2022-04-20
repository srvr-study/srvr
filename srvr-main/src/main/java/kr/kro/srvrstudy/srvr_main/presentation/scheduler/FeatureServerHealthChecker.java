package kr.kro.srvrstudy.srvr_main.presentation.scheduler;

<<<<<<< HEAD
import kr.kro.srvrstudy.srvr_main.domain.model.FeatureServer;
=======
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)
import kr.kro.srvrstudy.srvr_main.domain.service.FeatureServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)
@Component
@RequiredArgsConstructor
@Slf4j
public class FeatureServerHealthChecker {

    private final SimpMessagingTemplate template;
    private final FeatureServerService featureServerService;

    @Scheduled(fixedDelay = 10000)
    public void healthCheck(){
<<<<<<< HEAD
        List<FeatureServer> realTimeFeatureServers = featureServerService.getRealTimeFeatureServers();
        log.debug("[HealthChecker] Feature servers: {}", realTimeFeatureServers);
        template.convertAndSend("/subscribe/feature-servers", realTimeFeatureServers);
    }

=======
        template.convertAndSend("/sub/feature-servers", featureServerService.getFeatureServers());
    }
>>>>>>> 759882c (feat: STOMP 설정 및 간단 스케쥴러 추가 및 패키지 구조 정립)
}
