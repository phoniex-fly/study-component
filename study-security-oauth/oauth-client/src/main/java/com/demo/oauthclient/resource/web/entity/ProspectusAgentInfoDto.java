package com.demo.oauthclient.resource.web.entity;

/**
 * @Description: 描述
 * @Author: Liu Changyue
 * @CreateDate: 2019/6/20$ 9:43$
 * @UpdateUser:
 * @UpdateDate: 2019/6/20$ 9:43$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ProspectusAgentInfoDto {

    /**
     * --固定值
     */
    private String roles;
    /**
     * 代理人编码
     */
    private String agentCode;

    /**
     * 代理人姓名
     */
    private String agentName;

    /**
     * 代理人头像 url
     */
    private String agentImageUrl;

    /**
     * 代理人渠道
     */
    private String agentChannel;

    /**
     * 代理人状态
     */
    private String agentStatus;

    /**
     * 电话
     */
    private String agentTel;

    /**
     * 机构
     */
    private String branchCode;

    /**
     * 代理人等级  对应表中agentLevel
     * 如无，则默认C
     */
    private String agentSort;

    /**
     * 代理人邮箱
     */
    private String agentMailBox;

    /**
     * 资格证号
     */
    private String certNo;

    /**
     * 是否有空投权限
     * Y：是；N：否
     */
    private String airBizProfile;

    /**
     * 营业网点
     */
    private String salesUnit;

    /**
     * 出单类型
     */
    private String codeType;

    /**
     * 经代计划书出单代码
     */
    private String saleCode;

    /**
     * KA代理人入职类型
     */
    private String recruitmentType;

    /**
     * 是否显示财险空投的标志
     */
    private String isViewAirBiz;

    /**
     * 代理人职业证号
     */
    private String saleManOccupationNo;

    /**
     * 代理人营管处
     * 目前只有KA渠道的会去取出来
     */
    private String areaCode;

    /**
     * 代理类型
     * 01.代理人  02.内勤   03.渠道管理员04.经代管理员
     */
    private String agentClass;


    public ProspectusAgentInfoDto() {
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentImageUrl() {
        return agentImageUrl;
    }

    public void setAgentImageUrl(String agentImageUrl) {
        this.agentImageUrl = agentImageUrl;
    }

    public String getAgentChannel() {
        return agentChannel;
    }

    public void setAgentChannel(String agentChannel) {
        this.agentChannel = agentChannel;
    }

    public String getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(String agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAgentSort() {
        return agentSort;
    }

    public void setAgentSort(String agentSort) {
        this.agentSort = agentSort;
    }

    public String getAgentMailBox() {
        return agentMailBox;
    }

    public void setAgentMailBox(String agentMailBox) {
        this.agentMailBox = agentMailBox;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getAirBizProfile() {
        return airBizProfile;
    }

    public void setAirBizProfile(String airBizProfile) {
        this.airBizProfile = airBizProfile;
    }

    public String getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getRecruitmentType() {
        return recruitmentType;
    }

    public void setRecruitmentType(String recruitmentType) {
        this.recruitmentType = recruitmentType;
    }

    public String getIsViewAirBiz() {
        return isViewAirBiz;
    }

    public void setIsViewAirBiz(String isViewAirBiz) {
        this.isViewAirBiz = isViewAirBiz;
    }

    public String getSaleManOccupationNo() {
        return saleManOccupationNo;
    }

    public void setSaleManOccupationNo(String saleManOccupationNo) {
        this.saleManOccupationNo = saleManOccupationNo;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAgentClass() {
        return agentClass;
    }

    public void setAgentClass(String agentClass) {
        this.agentClass = agentClass;
    }

    public ProspectusAgentInfoDto(String agentCode, String agentName, String agentImageUrl, String agentChannel, String agentStatus, String agentTel, String branchCode, String agentSort, String agentMailBox, String certNo, String airBizProfile, String salesUnit, String codeType, String saleCode, String recruitmentType, String isViewAirBiz, String saleManOccupationNo, String areaCode, String agentClass) {
        this.agentCode = agentCode;
        this.agentName = agentName;
        this.agentImageUrl = agentImageUrl;
        this.agentChannel = agentChannel;
        this.agentStatus = agentStatus;
        this.agentTel = agentTel;
        this.branchCode = branchCode;
        this.agentSort = agentSort;
        this.agentMailBox = agentMailBox;
        this.certNo = certNo;
        this.airBizProfile = airBizProfile;
        this.salesUnit = salesUnit;
        this.codeType = codeType;
        this.saleCode = saleCode;
        this.recruitmentType = recruitmentType;
        this.isViewAirBiz = isViewAirBiz;
        this.saleManOccupationNo = saleManOccupationNo;
        this.areaCode = areaCode;
        this.agentClass = agentClass;
    }
}
