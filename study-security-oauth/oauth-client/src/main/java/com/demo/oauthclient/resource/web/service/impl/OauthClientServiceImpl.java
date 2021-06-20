package com.demo.oauthclient.resource.web.service.impl;


import cn.hutool.json.JSONUtil;
import com.demo.common.util.Constant;
import com.demo.common.util.SymmetricEncoder;
import com.demo.oauthclient.resource.web.entity.AccessTokenDto;
import com.demo.oauthclient.resource.web.entity.AuthorizeDto;
import com.demo.oauthclient.resource.web.entity.State;
import com.demo.oauthclient.resource.web.entity.TokenDto;
import com.demo.oauthclient.resource.web.service.OauthClientService;
import com.demo.oauthclient.resource.web.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class OauthClientServiceImpl implements OauthClientService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private RestTemplateService restTemplateService;


    @Value("${oauth.client.redirect_uri}")
    private String redirect_uri;

    @Value("${oauth.token_uri}")
    private String token_uri;

    @Override
    public String comeToOauth(String client, String target, String mark) {
        //1、根据client查询授权信息

        //2、若是,封装client_id、client_secret、response_type、scope、redirect_uri,state向对接方请求授权
        State state = new State(client, target, mark, request);
        AuthorizeDto authorize = AuthorizeDto.builder().client_id("client")
                .client_secret("123456").redirect_uri("http://localhost:8888/oauthClient/callBack")
                .response_type("code").scope("all")
                .state(SymmetricEncoder.AESEncode(JSONUtil.toJsonStr(state))).build();
        return restTemplateService.authorize("http://localhost:9999/oauth/authorize?" +
                "client_id={client_id}&" +
                "client_secret={client_secret}&" +
                "response_type={response_type}&" +
                "scope={scope}&" +
                "redirect_uri={redirect_uri}", authorize.getClient_id(), authorize.getClient_secret(), authorize.getResponse_type(), authorize.getScope(), authorize.getRedirect_uri());
    }

    @Override
    public void callBack(String code, String state) throws IOException, ServletException {
        //1、从state中解析出对接方唯一标识，根据对接方唯一标识查询出对接方获取token需要的相关信息(code、grant_type、authorization_code、redirect_uri)
        State back_state = JSONUtil.toBean(SymmetricEncoder.AESDncode(state), State.class);
        back_state.stateCheck(request);
        //2、将查询的获取token相关的信息连同code一起封装，向对接方发起获取access_token的请求。
        String accessToken = getAccessToken(code);
        //3、根据获取的access_token向对接方请求用户唯一标识资源
        String agentCode = getUserInfo(accessToken);
        //4、根据获取的用户唯一标识进行用户名密码模式登录
        getInternalAccessToken(back_state, agentCode);
        //5、登录成功，从state中解析出目标访问资源，向目标访问资源转发请求
    }

    /**
     * 获取内部资源访问token
     *
     * @param back_state
     * @param agentCode
     * @return
     */
    private void getInternalAccessToken(State back_state, String agentCode) throws ServletException, IOException {
        AccessTokenDto internalAccessToken = AccessTokenDto.builder().client_id("client")
                .client_secret("123456").grant_type("password")
                .username(agentCode).password(Constant.PWD_PROSPECTUS).build();
        response.setHeader(Constant.LOGIN_TYPE, Constant.CLIENT_OAUTH);
        response.setHeader(Constant.TARGET, back_state.getTarget());
        request.getRequestDispatcher("").forward(request, response);
    }

    /**
     * 获取对接方资源访问token
     *
     * @param code
     * @return
     */
    private String getAccessToken(String code) {
        AccessTokenDto accessToken = AccessTokenDto.builder().client_id("client")
                .client_secret("123456").grant_type("authorization_code")
                .redirect_uri("http://localhost:9999/oauth/authorize")
                .code(code).scope("all").build();
        TokenDto token = restTemplateService.token("http://localhost:9999/oauth/token", accessToken);
        return token.getAccess_token();
    }


    /**
     * 获取对接方资源
     *
     * @return
     */
    private String getUserInfo(String accessToken) {
        return null;
    }


}
