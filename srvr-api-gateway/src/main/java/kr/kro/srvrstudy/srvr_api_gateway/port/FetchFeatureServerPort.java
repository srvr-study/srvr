package kr.kro.srvrstudy.srvr_api_gateway.port;

import reactor.core.publisher.Flux;

public interface FetchFeatureServerPort {
    Flux<Object> findFeatureServer();
}
