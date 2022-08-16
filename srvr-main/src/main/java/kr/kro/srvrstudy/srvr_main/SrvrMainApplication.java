package kr.kro.srvrstudy.srvr_main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SrvrMainApplication {

    // TODO 0823 메인에서 auth 분리
    public static void main(String[] args) {
        SpringApplication.run(SrvrMainApplication.class, args);
    }

}
