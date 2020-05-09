package monkey.security;

import monkey.common.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class WebAuthenticator implements HandlerInterceptor {

    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();
        final Class<?> clazz = method.getDeclaringClass();

        if (method.isAnnotationPresent(Auth.class) || clazz.isAnnotationPresent(Auth.class)) {
            return Session.validate(redisClient, request);
        }

        return true;
    }

}

