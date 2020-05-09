package monkey.security;

import monkey.common.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@WebFilter(filterName = "SessionAccountAppender", urlPatterns = "/*")
public class SessionAccountAppender implements Filter {

    @Autowired
    private RedisClient redisClient;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        WebRequest request = new WebRequest((HttpServletRequest) servletRequest);
        Session.addAccountParameter(redisClient, request);
        servletRequest = request;
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
