package kr.kro.srvrstudy.srvr_main_client.api;

import kr.kro.srvrstudy.srvr_main_client.config.MainServerClientProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class MainEchoApi {

    private final WebClient webClient;
    private final MainServerClientProperties properties;

    public Map<String, Object> postEcho(String body) {
        return this.webClient.method(HttpMethod.POST)
                             .uri(properties.getEcho())
                             .bodyValue(body)
                             .retrieve()
                             .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                             .block();
    }

    public Map<String, Object> getEchoPath(String path) {
        return this.webClient.method(HttpMethod.GET)
                             .uri(String.format(properties.getEchoPath(), path))
                             .retrieve()
                             .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                             .block();
    }
}
