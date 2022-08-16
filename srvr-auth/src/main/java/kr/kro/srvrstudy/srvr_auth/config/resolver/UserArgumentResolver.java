package kr.kro.srvrstudy.srvr_auth.config.resolver;

import kr.kro.srvrstudy.srvr_auth.domain.model.SessionUser;
import kr.kro.srvrstudy.srvr_auth.domain.model.User;
import kr.kro.srvrstudy.srvr_auth.domain.service.UserService;
import kr.kro.srvrstudy.srvr_auth.common.encryption.SessionCookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    private final UserService userService;
    private final SessionCookieUtil sessionCookieUtil;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Objects.nonNull(parameter.getParameterAnnotation(SessionUser.class)) && User.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String sessionKey = sessionCookieUtil.getSessionKey((HttpServletRequest) webRequest);

        return Optional.ofNullable(sessionKey)
                .map(userService::getUserBy)
                .orElse(null);
    }
}
