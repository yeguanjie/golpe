package com.golpesoft.erp.dal.model.admin;

import com.golpesoft.erp.dal.model.TBaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;


/**
 * Created by guanjieye on 2018/5/19.
 */
@Getter
@Setter
@Table(name = "admin_role")
public class AdminRole extends TBaseModel {

    private static final long serialVersionUID = 5001966718676044921L;

    /*角色名称*/
    private String name;

    private String code;

    private Integer status;

}
