package kr.kro.srvrstudy.srvr_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SrvrAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrvrAuthApplication.class, args);
    }
}

