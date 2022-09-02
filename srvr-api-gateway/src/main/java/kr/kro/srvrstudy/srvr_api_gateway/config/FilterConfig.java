package kr.kro.srvrstudy.srvr_api_gateway.config;

import kr.kro.srvrstudy.srvr_api_gateway.filter.LoggingFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class FilterConfig {

    @Bean
    @Order(0)
    public GlobalFilter loggingFilter() {
        return new LoggingFilter();
    }
}
