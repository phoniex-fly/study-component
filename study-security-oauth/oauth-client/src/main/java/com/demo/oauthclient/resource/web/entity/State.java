package com.demo.oauthclient.resource.web.entity;

import com.demo.common.exception.BusinessException;
import com.demo.common.exception.ExceptionMessageDef;
import com.demo.common.util.Constant;
import com.demo.common.util.GcUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class State {

    private String client;

    private String mark;

    private String target;

    private String uuid;


    /**
     * 创建state,uuid放入session
     *
     * @param client
     * @param target
     * @return
     */
    public State(String client, String target, String mark, HttpServletRequest request) {
        String state_uuid = UUID.randomUUID().toString();
        GcUtil.addSessionAttr(request, Constant.STATE_UUID, state_uuid);
        this.client = client;
        this.target = target;
        this.uuid = state_uuid;
        this.mark = mark;
    }

    /**
     * 验证回调请求有效性
     *
     * @param
     * @return
     */
    public void stateCheck(HttpServletRequest request) {
        String state_uuid = GcUtil.getSessionAttr(request, Constant.STATE_UUID);
        if ((!StringUtils.isEmpty(state_uuid) || StringUtils.isEmpty(this.uuid)) && !state_uuid.equals(this.uuid)) {
            throw new BusinessException(ExceptionMessageDef.OAUTH_STATE_ERROR, ExceptionMessageDef.OAUTH_STATE_ERROR_MSG);
        }
    }

}
