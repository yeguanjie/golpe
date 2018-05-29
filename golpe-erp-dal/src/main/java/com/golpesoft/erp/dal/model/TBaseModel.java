package com.golpesoft.erp.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yeguanjie
 * @date 2017/6/13
 */
@Getter
@Setter
@ToString
public class TBaseModel implements Serializable {

    private static final long serialVersionUID = -3084112268878595654L;

    /**
     * 数据库主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
