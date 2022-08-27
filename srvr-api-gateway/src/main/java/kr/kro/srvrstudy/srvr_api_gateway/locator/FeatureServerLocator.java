package kr.kro.srvrstudy.srvr_api_gateway.locator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.srvrstudy.srvr_api_gateway.domain.FeatureServer;
import kr.kro.srvrstudy.srvr_api_gateway.port.FetchFeatureServerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Slf4j
@Component
@RequiredArgsConstructor
public class FeatureServerLocator implements RouteLocator {

    private static final String SRVR_SERVER = "SRVR-SERVER";
    private final FetchFeatureServerPort fetchFeatureServerPort;
    private final RouteLocatorBuilder routeLocatorBuilder;
    private final FeatureServer mainServer;
    private final ObjectMapper objectMapper;

    @Override
    public Flux<Route> getRoutes() {
        RouteLocatorBuilder.Builder routesBuilder = routeLocatorBuilder.routes()
                                                                       .route(mainServer.getName(), setPredicateSpec(mainServer));
        return fetchFeatureServerPort.findFeatureServer()
                                     .map(convertFeatureServer())
                                     .map(setRouteByFeatureServer(routesBuilder))
                                     .collectList()
                                     .flatMapMany(builders -> routesBuilder.build().getRoutes());
    }

    private Function<Object, FeatureServer> convertFeatureServer() {
        return rawData -> {
            try {
                String jsonData = objectMapper.writeValueAsString(rawData);
                return objectMapper.readValue(jsonData, FeatureServer.class);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("Failed to convert jsonString from featureServers rawdata", e);
            }
        };
    }

    private Function<FeatureServer, RouteLocatorBuilder.Builder> setRouteByFeatureServer(RouteLocatorBuilder.Builder builder) {
        return featureServer -> {
            log.info("Register Feature Server. Name: {}, url: {}", featureServer.getName(), featureServer.getUrl());
            return builder.route(featureServer.getName(), setPredicateSpec(featureServer));
        };
    }

    private Function<PredicateSpec, Buildable<Route>> setPredicateSpec(FeatureServer featureServer) {
        return predicateSpec -> predicateSpec.header(SRVR_SERVER, featureServer.getName())
                                             .uri(featureServer.getUrl());
    }
}
