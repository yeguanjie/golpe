package com.golpesoft.erp.facade.models.response;

import com.golpesoft.erp.facade.enums.TradeStateEnum;
import com.golpesoft.erp.facade.models.BaseResDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class QueryPageResDTO<T> extends BaseResDTO {

    private static final long serialVersionUID = -3243853888642482591L;

    private List<T> resultList;

    private int totalCounts;

    {
        this.setRespStatus(TradeStateEnum.SUCCESS.getCode());
    }
}
