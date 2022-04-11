package kr.kro.srvrstudy.srvr_common.config;

import io.netty.channel.ChannelOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                                          .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                                          .responseTimeout(Duration.ofSeconds(2));

        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
                        .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
                        .build();
    }
}
