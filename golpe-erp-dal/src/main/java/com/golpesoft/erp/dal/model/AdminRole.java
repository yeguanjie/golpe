package com.golpesoft.erp.dal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by guanjieye on 2018/5/19.
 */
@Table(name = "ADMIN_ROLE")
@Getter
@Setter
public class AdminRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*角色名称*/
    private String name;

    private String code;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}
