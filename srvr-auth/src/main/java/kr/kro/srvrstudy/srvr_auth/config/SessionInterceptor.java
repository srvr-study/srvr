package kr.kro.srvrstudy.srvr_auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;


@Slf4j
@Component
public class SessionInterceptor implements HandlerInterceptor {

    private static final String SESSION_KEY = "SESSION";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        Cookie sessionCookies = getSessionCookies(cookies);

        if (Objects.isNull(sessionCookies)) {
            return false;
        }

        // 세션 연장

        return true;
    }

    private Cookie getSessionCookies(Cookie[] cookies) {
        return Arrays.stream(cookies)
                     .filter(cookie -> SESSION_KEY.equals(cookie.getName()))
                     .findFirst().orElse(null);
    }
}
