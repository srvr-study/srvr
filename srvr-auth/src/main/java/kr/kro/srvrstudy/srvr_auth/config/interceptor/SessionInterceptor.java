package kr.kro.srvrstudy.srvr_auth.config.interceptor;

import kr.kro.srvrstudy.srvr_auth.common.SessionCookieUtil;
import kr.kro.srvrstudy.srvr_auth.domain.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Slf4j
@Component
@RequiredArgsConstructor
public class SessionInterceptor implements HandlerInterceptor {

    private final SessionCookieUtil sessionCookieUtil;
    private final SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionKey = sessionCookieUtil.getSessionKey(request);

        if (Objects.isNull(sessionKey)) {
            return false;
        }

        sessionService.extendSession(sessionKey);
        return true;
    }

}

// TODO User 파라미터로 넣어주는 argumentResolver
