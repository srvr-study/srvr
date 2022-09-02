package kr.kro.srvrstudy.srvr_api_gateway.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.srvrstudy.srvr_api_gateway.domain.FeatureServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GatewayConfig {

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean
    public FeatureServer mainServer(@Value("${srvr.server.main.url}") String url,
                                    @Value("${srvr.server.main.name}") String name) {
        return new FeatureServer(name, url);
    }

}
