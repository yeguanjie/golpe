package com.golpesoft.erp.facade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yeguanjie
 *
 *
 */
@Getter
@AllArgsConstructor
public enum BizCode {

    SUCCESS("00000", "成功"),
    SYSTEM_EXCEPTION("00001", "系统异常"),
    SYSTEM_ERROR("00002", "系统内部错误"),
    PARAMETER_VALID_NOT_PASS("00003", "参数校验不通过"),
    PLATFORM_NOT_EXIST("00012", "平台不存在"),
    /**=======================相关响应码10001开始===========================*/




    NOT_EXIST_DATA("11090", "亲，查无记录"),
    NOT_EXIST_COUNT_DATA("11091", "记录数不存在"),
    ;

    private final String code;
    private final String desc;
}
