package com.golpesoft.erp.facade.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseResDTO implements Serializable {

    private static final long serialVersionUID = 8967564912933717795L;
    /**状态码(见交易状态枚举)*/
    private String respStatus;
    /**响应码*/
    private String respCode;
    /**响应描述*/
    private String respMsg;

    public BaseResDTO(){

    }

    public BaseResDTO(String respStatus, String respCode, String respMsg){
        this.respStatus = respStatus;
        this.respCode = respCode;
        this.respMsg = respMsg;
    }
}
