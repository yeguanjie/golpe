package com.golpesoft.erp.common.exceptions;

import com.golpesoft.erp.facade.enums.BizCode;
import com.golpesoft.erp.facade.models.BaseResDTO;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author yeguanjie
 * @date 2017/6/28
 */
@Getter
public class BizException extends RuntimeException implements Serializable {

    private final String code;

    public BizException(String code, Throwable throwable){
        super(throwable);
        this.code = code;
    }

    public BizException(BizCode bizCode){
        super(bizCode.getDesc());
        this.code = bizCode.getCode();
    }

    public BizException(BizCode bizCode, String message){
        super(message);
        this.code = bizCode.getCode();
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(BaseResDTO resDTO){
        super(resDTO.getRespMsg());
        this.code = resDTO.getRespCode();
    }
}
