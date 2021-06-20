package com.demo.oauthclient.authorization.handler;


import com.demo.oauthclient.resource.web.entity.ClientUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TargetResourceDispatchHandler implements AuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger("oauthClientLogger");

    /**
     * 目标资源重定向
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //登录成功后是看session中是否有target,如果有，重定向
        ClientUser client = (ClientUser) authentication.getPrincipal();
        if (!StringUtils.hasText(client.getTarget())) {
            logger.info("目标资源空：{}", authentication);
            return;
        }
        request.getRequestDispatcher(client.getTarget()).forward(request, response);
    }
}
