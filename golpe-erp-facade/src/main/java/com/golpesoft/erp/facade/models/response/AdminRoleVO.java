package com.golpesoft.erp.facade.models.response;

import com.golpesoft.erp.facade.models.BaseResDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AdminRoleVO implements Serializable {

    private static final long serialVersionUID = -8627777666859234991L;

    private Long id;

    /*角色名称*/
    private String name;

    private String code;

    private Integer status;

    /**
     * 创建时间
     */
    protected Date createdAt;

    /**
     * 创建人
     */
    protected String createdBy;

    /**
     * 更新时间
     */
    protected Date updatedAt;

    /**
     * 最后更新人
     */
    protected String updatedBy;


}
