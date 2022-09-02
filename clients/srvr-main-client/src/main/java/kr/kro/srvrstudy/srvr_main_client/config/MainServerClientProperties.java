package kr.kro.srvrstudy.srvr_main_client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "srvr.server.main")
@Getter
@Setter
public class MainServerClientProperties {

    @NotNull
    private String url;
    @NotNull
    private String echo = "/api/v1/echo";
    @NotNull
    private String echoPath = "/api/v1/echo/{path}";
    @NotNull
    private String getFeatureServers = "/api/v1/feature-servers";
}
