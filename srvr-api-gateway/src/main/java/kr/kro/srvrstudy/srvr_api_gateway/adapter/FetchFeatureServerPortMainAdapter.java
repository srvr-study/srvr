package kr.kro.srvrstudy.srvr_api_gateway.adapter;

import kr.kro.srvrstudy.srvr_api_gateway.port.FetchFeatureServerPort;
import kr.kro.srvrstudy.srvr_main_client.api.MainFeatureServerApi;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class FetchFeatureServerPortMainAdapter implements FetchFeatureServerPort {

    private final MainFeatureServerApi mainFeatureServerApi;

    public FetchFeatureServerPortMainAdapter(MainFeatureServerApi mainFeatureServerApi) {
        this.mainFeatureServerApi = mainFeatureServerApi;
    }

    @Override
    public Flux<Object> findFeatureServer() {
        return Flux.fromIterable(mainFeatureServerApi.getFeatureServers().getResult().getContents());
    }
}
