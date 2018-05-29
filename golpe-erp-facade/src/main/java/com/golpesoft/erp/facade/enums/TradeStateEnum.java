package com.golpesoft.erp.facade.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yeguanjie
 *
 */
@Getter
@AllArgsConstructor
public enum TradeStateEnum {

    SUCCESS("SUCCESS", "成功"),
    FAIL("FAIL", "失败"),

            ;

    private final String code;
    private final String desc;
}
