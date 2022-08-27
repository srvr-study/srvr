package kr.kro.srvrstudy.srvr_common.helper;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class UriHelper {

    private UriHelper() {
        throw new AssertionError("Assert can't be initiate");
    }

    public static String makeUri(String url, String path) {
        try {
            URL serverUrl = new URL(url);
            return UriComponentsBuilder.newInstance()
                                       .scheme(serverUrl.getProtocol())
                                       .host(serverUrl.getHost())
                                       .port(serverUrl.getPort())
                                       .path(path)
                                       .toUriString();

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Failed to convert URL object. url: " + url, e);
        }
    }
}
