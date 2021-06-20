package com.demo.oauthserver.authorization.filter;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OauthServerFilter extends OncePerRequestFilter {


    /**
     * 校验oauth client对接方
     *
     * @param request
     * @param response
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String requestUrl = request.getRequestURL().toString();
        logger.info("过滤器OAuthServerFilter，当前请求" + requestUrl + ",请求方式:" + request.getMethod());
        if ("".equals(requestUrl)) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            logger.info("当前用户：" + authentication);
        }
        filterChain.doFilter(request, response);
    }
}
