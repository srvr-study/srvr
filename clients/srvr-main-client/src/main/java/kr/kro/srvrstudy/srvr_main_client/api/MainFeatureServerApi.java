package kr.kro.srvrstudy.srvr_main_client.api;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.helper.UriHelper;
import kr.kro.srvrstudy.srvr_main_client.config.MainServerClientProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class MainFeatureServerApi {
    private final WebClient webClient;
    private final MainServerClientProperties properties;

    public ApiResponse<Object> getFeatureServers() {
        return this.webClient.method(HttpMethod.GET)
                             .uri(UriHelper.makeUri(properties.getUrl(), properties.getGetFeatureServers()))
                             .retrieve()
                             .bodyToMono(new ParameterizedTypeReference<ApiResponse<Object>>() {})
                             .block();
    }
}
