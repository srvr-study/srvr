package kr.kro.srvrstudy.srvr_main_client.config;

import kr.kro.srvrstudy.srvr_main_client.api.MainEchoApi;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(MainServerClientProperties.class)
@RequiredArgsConstructor
public class MainServerClientConfig {

    private final MainServerClientProperties properties;

    @Bean
    public MainEchoApi echoControllerApi(WebClient webClient) {
        return new MainEchoApi(webClient, properties);
    }
}
