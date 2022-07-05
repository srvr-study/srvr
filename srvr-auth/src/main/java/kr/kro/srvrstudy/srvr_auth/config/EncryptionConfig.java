package kr.kro.srvrstudy.srvr_auth.config;

import kr.kro.srvrstudy.srvr_auth.common.encryption.AES256;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Bean
    public AES256 aes256(@Value("${srvr.auth.encryption.master-key}") String masterKey) {
        return new AES256(masterKey);
    }
}
