package com.golpesoft.erp.facade.models.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.NotNull;

import java.io.Serializable;

/**
 * @author yeguanjie
 *
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class QueryPageReqDTO<T>  implements Serializable {

    private static final long serialVersionUID = 3615619607672443606L;

    private T reqDTO;

    /**
     * 当前页数
     */
    @NotNull(message = "查询页数不能为空")
    @Min(value = 1,message = "查询页数不能小于1")
    private int pageIndex;

    /**
     * 每页记录数
     */
    @NotNull(message = "每页记录数不能为空")
    @Min(value = 1,message = "每页记录数不能小于1")
    private int pageCount;
}
