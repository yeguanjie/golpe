package com.golpesoft.erp.dal.mapper;

import com.golpesoft.erp.dal.BaseMapper;
import com.golpesoft.erp.dal.model.AdminRole;

import java.util.List;
import java.util.Map;

/**
 * Created by guanjieye on 2018/5/19.
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    public Integer update(AdminRole adminRole);

    /**
     * 根据条件查询数量
     *
     * @param paramsMap
     * @return
     */
    public Integer selectAdminRoleCountWithCondition(Map<String, Object> paramsMap);

    /**
     * 根据条件查询列表
     *
     * @param paramsMap
     * @return
     */
    public List<AdminRole> selectAdminRoleWithPage(Map<String, Object> paramsMap);
}
