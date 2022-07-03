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
    private String echo;

    @NotNull
    private String echoPath;
}
