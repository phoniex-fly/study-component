package com.demo.common.util;


/**
 * @Description: 描述
 * @Author: Liu Changyue
 * @CreateDate: 2019/5/21$ 9:43$
 * @UpdateUser:
 * @UpdateDate: 2019/5/21$ 9:43$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ResResult<T> {
    /**
     * 结果代码：0-成功，其他失败
     */
    private int resCode;
    /**
     * 描述  结果描述，成功或失败原因
     */
    private String resMsg;
    /**
     * 数据条数  查询接口响应数据条数，其它接口0
     */
    private long total;
    /**
     * 返回的数据  查询接口响应的数据，其它接口为空，
     */
    private T data;

    public ResResult() {
    }

    public ResResult(int resCode, String resMsg) {
        this.resMsg = resMsg;
        this.resCode = resCode;
    }

    public ResResult(int resCode, String resMsg, long total, T data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.total = total;
        this.data = data;
    }

    public ResResult(int resCode, String resMsg, T data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.data = data;
    }

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
