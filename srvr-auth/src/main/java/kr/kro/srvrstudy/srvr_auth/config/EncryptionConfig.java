package kr.kro.srvrstudy.srvr_auth.config;

import kr.kro.srvrstudy.srvr_auth.common.encryption.SymmetricKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {

    @Bean
    public SymmetricKey symmetricKey(@Value("${srvr.auth.encryption.master-key}") String masterKey) {
        return new SymmetricKey(masterKey);
    }
//
//    @Bean
//    public Password
}
