package kr.kro.srvrstudy.srvr_auth.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Component
public class SessionCookieUtil {

    private final String sessionCookieName;

    public SessionCookieUtil(@Value("srvr.auth.session.cookie.name") String sessionCookieName) {
        this.sessionCookieName = sessionCookieName;
    }

    public Cookie generate(String sessionKey) {
        Cookie sessionCookie = new Cookie(sessionCookieName, sessionKey);

        sessionCookie.setHttpOnly(true);
        sessionCookie.setMaxAge(-1);
        return sessionCookie;
    }

    public Cookie delete(String sessionKey) {
        Cookie sessionCookie = new Cookie(sessionCookieName, sessionKey);

        sessionCookie.setHttpOnly(true);
        sessionCookie.setMaxAge(0);
        return sessionCookie;
    }

    public String getSessionKey(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, sessionCookieName);

        return Optional.ofNullable(cookie)
                       .map(Cookie::getValue)
                       .orElse(null);
    }
}
