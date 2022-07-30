package kr.kro.srvrstudy.srvr_main.config;


import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

public class FeignClientConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new Decoder();
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
