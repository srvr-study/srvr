package kr.kro.srvrstudy.srvr_api_gateway;

import kr.kro.srvrstudy.srvr_api_gateway.component.LoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SrvrApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SrvrApiGatewayApplication.class, args);
    }

    @Value("${srvr.main.host}")
    private String mainHost;

    @Value("${srvr.auth.host}")
    private String authHost;

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        // TODO : 0823 application 동작시 main 서버에서 feature-server 조회하여 동적 route 생성.
        // TODO : logging 추가

        return builder.routes()
                      .route("main",
                             predicateSpec -> predicateSpec.header("SRVR-SERVER", "MAIN")
                                                           .uri(mainHost))

                      .route("auth",
                             predicateSpec -> predicateSpec.header("SRVR-SERVER", "AUTH")
                                                           .uri(authHost))
                      .build();
    }
}
