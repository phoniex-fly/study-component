package com.demo.oauthclient.authorization.filter;

import com.demo.common.exception.BusinessException;
import com.demo.common.exception.ExceptionMessageDef;
import com.demo.common.util.Constant;
import com.demo.oauthclient.resource.web.entity.AccessClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OauthClientFilter extends OncePerRequestFilter {

    @Value("${oauth.client.accquire_uri}")
    private String accquire_uri;
    @Value("${oauth.client.oauthClient_uri}")
    private String oauthClient_uri;


    /**
     * 校验oauth client对接方
     *
     * @param request
     * @param response
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        String requestUrl = request.getRequestURL().toString();
        logger.info("第三个过滤器OAuthCLientFilter，当前请求" + requestUrl + ",请求方式:" + request.getMethod());
        //请求uri是否包含accquire
        if (requestUrl.contains(accquire_uri)) {
            String client = request.getParameter(Constant.CLIENT);
            if (StringUtils.isEmpty(client)) {
                throw new BusinessException(ExceptionMessageDef.OAUTH_CLIENT_EMPTY, ExceptionMessageDef.OAUTH_CLIENT_EMPTY_MSG);
            }
            List<String> clients = AccessClient.clients;
            //若包含，根据client参数鉴别是否为受信任的对接方
            if (!clients.contains(client)) {
                throw new BusinessException(ExceptionMessageDef.OAUTH_CLIENT_ERROR, ExceptionMessageDef.OAUTH_CLIENT_ERROR_MSG);
            }
            //若是，将请求重定向至客户端入口
            request.getRequestDispatcher(oauthClient_uri).forward(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
