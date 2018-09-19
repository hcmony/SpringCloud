
package com.hcmony.utils;

import java.io.Serializable;

/**
 * @author: hcmony  Date: 2015/7/21 Time: 12:27
 */
public class ResponseData implements Serializable {
    /**
     * 返回码 not http响应码
     */
    private int codeId;
    /**
     * 返回码描述
     */
    private String codeDes;
    private Object resData;

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getCodeDes() {
        return codeDes;
    }

    public void setCodeDes(String codeDes) {
        this.codeDes = codeDes;
    }

    public Object getResData() {
        return resData;
    }

    public void setResData(Object resData) {
        this.resData = resData;
    }

    public ResponseData(CodeIdEnum codeIdEnum) {
        this.codeId = codeIdEnum.getValue();
        this.codeDes = codeIdEnum.getName();
    }

    /***
     * 大部份错误都返回-1，加描述
     * @param codeId
     * @param codeDes
     */
    public ResponseData(int codeId, String codeDes) {
        this.codeId = codeId;
        this.codeDes = codeDes;
    }

    public ResponseData(CodeIdEnum codeIdEnum, Object resData) {
        this.codeId = codeIdEnum.getValue();
        this.codeDes = codeIdEnum.getName();
        this.resData = resData;
    }

    public ResponseData() {
    }
}
