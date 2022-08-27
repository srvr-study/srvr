package kr.kro.srvrstudy.srvr_api_gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class LoggingFilter implements GlobalFilter {

    private static final String SRVR_SERVER = "SRVR-SERVER";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        log.info("[REQUEST] TARGET: {}, Request-Id: {}, Path: {}", request.getHeaders().get(SRVR_SERVER), request.getId(), request.getPath());

        //Custom Post Filter
        return chain.filter(exchange).then(Mono.fromRunnable(() -> log.info("[RESPONSE] SRC: {}, Request-Id: {}, Path: {}, Status: {}",
                                                                            request.getHeaders().get(SRVR_SERVER),
                                                                            request.getId(),request.getPath(),
                                                                            response.getRawStatusCode())));
    }
}
