package com.demo.oauthclient.resource.web.service.impl;


import com.demo.common.util.Constant;
import com.demo.oauthclient.resource.web.entity.ProspectusAgentInfoDto;
import com.demo.oauthclient.resource.web.service.ProspectusService;
import com.demo.oauthclient.resource.web.service.TargetService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Service("prospectus")
public class ProspectusServiceImpl implements ProspectusService, TargetService<ProspectusAgentInfoDto> {

    /**
     * 请求转发至计划书
     *
     * @param principal
     * @return
     */
    @Override
    public String toProspectus(Principal principal) {
        return null;
    }

    @Override
    public ProspectusAgentInfoDto findUserByName(String agentCode) {
        return null;
    }

    @Override
    public List<String> findAuths() {
        return Collections.emptyList();
    }

    @Override
    public String findPassword() {
        return Constant.PWD_PROSPECTUS;
    }
}
