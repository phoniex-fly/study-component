package com.demo.oauthclient.resource.web.controller;

import com.demo.common.util.ResResult;
import com.demo.oauthclient.resource.web.service.OauthClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oauthClient")
public class OauthClientController {

    private Logger logger = LoggerFactory.getLogger("oauthClientLogger");

    @Autowired
    private OauthClientService oauthClientService;

    /**
     * 发起请求认证
     *
     * @param client 为对接客户方分配的唯一标识
     * @param target 对接方访问的目标资源
     */
    @RequestMapping("/comeToOauth")
//    @ResponseBody
    public String comeToOauth(String client, String target, String mark) throws Exception {
//        return oauthClientService.comeToOauth(client, target, mark);
        throw new Exception();
    }

    /**
     * 对接方颁发授权码回调接口
     *
     * @param code  客户方oauth server返回的授权码
     * @param state 包含客户方唯一标识和客户方目标访问资源
     * @return
     */
    @GetMapping("/callBack")
    public ResResult callBack(String code, String state) {
        ResResult res = null;
        try {
            oauthClientService.callBack(code, state);
            return new ResResult(0, "发生错误，请稍后重试");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResResult(1, "发生错误，请稍后重试");
        }
    }
}
