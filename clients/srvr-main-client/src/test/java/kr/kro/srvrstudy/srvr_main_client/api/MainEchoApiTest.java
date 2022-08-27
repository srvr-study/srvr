package kr.kro.srvrstudy.srvr_main_client.api;

import kr.kro.srvrstudy.srvr_common.api.response.ApiResponse;
import kr.kro.srvrstudy.srvr_common.config.WebClientConfig;
import kr.kro.srvrstudy.srvr_main_client.config.MainServerClientProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebClientConfig.class})
@Disabled
class MainEchoApiTest {

    @SpyBean
    private WebClient webClient;

    @Mock
    private MainServerClientProperties properties;

    private MainEchoApi mainEchoApi = new MainEchoApi(webClient, properties);

    @BeforeEach
    void setup() {
        when(properties.getEcho()).thenReturn("http://localhost:8080/api/v1/echo");
        when(properties.getEchoPath()).thenReturn("http://localhost:8080/api/v1/echo/{path}");

        this.mainEchoApi = new MainEchoApi(webClient, properties);
    }

    @Test
    void requestExampleGetApiTest() {
        // given
        int end = 100;
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // when
        IntStream.range(0, end).parallel().forEach(index -> {
            ApiResponse<Object> response = mainEchoApi.getEchoPath(String.valueOf(index));
            map.put(index, (String) response.getResult().getContent());
        });

        // then
        verify(webClient, times(100)).method(HttpMethod.GET);
        assertEquals(end, map.size());
    }

    @Test
    void requestExamplePostApiTest() {
        // given
        int end = 100;
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        // when
        IntStream.range(0, end).parallel().forEach(index -> {
            ApiResponse<Object> response = this.mainEchoApi.postEcho(String.valueOf(index));
            map.put(index, (String) response.getResult().getContent());

        });

        // then
        verify(webClient, times(100)).method(HttpMethod.POST);
        assertEquals(end, map.size());
    }
}
