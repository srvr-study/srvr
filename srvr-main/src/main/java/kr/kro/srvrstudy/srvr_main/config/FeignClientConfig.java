package kr.kro.srvrstudy.srvr_main.config;


import feign.Feign;
import feign.Logger;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;

public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new Decoder();
    }
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.HEADERS);
    }

    private static class Decoder implements ErrorDecoder {

        private final ErrorDecoder errorDecoder = new Default();

        @Override
        public Exception decode(String methodKey, Response response) {
            final HttpStatus httpStatus = HttpStatus.resolve(response.status());

            if (httpStatus == HttpStatus.NOT_FOUND) {
                return new Exception(); // todo NOT_FOUND 익셉션 정의
            }

            return errorDecoder.decode(methodKey, response);
        }
    }

}
