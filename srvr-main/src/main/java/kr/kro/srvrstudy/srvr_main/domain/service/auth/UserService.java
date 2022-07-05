package kr.kro.srvrstudy.srvr_main.domain.service.auth;

import kr.kro.srvrstudy.srvr_common.spec.AuthSpec;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth-client", url = "${auth-api.url}")
public interface UserService extends AuthSpec {

}
