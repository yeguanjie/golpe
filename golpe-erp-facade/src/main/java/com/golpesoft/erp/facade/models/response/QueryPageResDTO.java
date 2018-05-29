package com.golpesoft.erp.facade.models.response;

import com.golpesoft.erp.facade.models.BaseResDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
public class QueryPageResDTO<T extends BaseResDTO> implements Serializable {

    private static final long serialVersionUID = -1243226664927837218L;

    private List<T> resultList;

    private int totalCounts;

}
