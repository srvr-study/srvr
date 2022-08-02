package kr.kro.srvrstudy.srvr_auth.config;

import kr.kro.srvrstudy.srvr_auth.config.interceptor.SessionInterceptor;
import kr.kro.srvrstudy.srvr_auth.config.resolver.UserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final UserArgumentResolver userArgumentResolver;
    private final SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/*")
                .excludePathPatterns("/api/v1/auth/login", "/api/v1/auth/join", "/api/v1/auth/*/duplicate");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
    }

}
