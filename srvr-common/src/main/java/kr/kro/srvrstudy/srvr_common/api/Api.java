package kr.kro.srvrstudy.srvr_common.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.function.Consumer;

public interface Api {

    HttpMethod getMethod();
    String getUrI();
    Consumer<HttpHeaders> getHeaders();
    String getBody();

}
