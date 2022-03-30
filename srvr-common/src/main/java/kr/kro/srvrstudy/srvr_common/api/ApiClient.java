package kr.kro.srvrstudy.srvr_common.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ApiClient {

    private final WebClient webClient;

    public <R> Mono<R> requestMono(Api api, Class<R> rClass) {
        return sendRequest(api).bodyToMono(rClass);
    }

    public <R> Flux<R> requestFlux(Api api, Class<R> rClass) {
        return sendRequest(api).bodyToFlux(rClass);
    }

    private WebClient.ResponseSpec sendRequest(Api api) {
        return webClient.method(api.getMethod()).uri(api.getUrI())
                .headers(api.getHeaders())
                .body(api.getBody(), api.getBody().getClass())
                .retrieve();
    }
}
