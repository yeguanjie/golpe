package com.golpesoft.erp.process.admin;

import com.golpesoft.erp.dal.mapper.AdminRoleMapper;
import com.golpesoft.erp.dal.model.admin.AdminRole;
import com.golpesoft.erp.facade.models.request.QueryPageReqDTO;
import com.golpesoft.erp.facade.models.response.AdminRoleResDTO;
import com.golpesoft.erp.facade.models.response.QueryPageResDTO;
import com.golpesoft.erp.process.component.PageUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminRoleProcessImpl {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Autowired
    private PageUtils pageUtils;

    public QueryPageResDTO<AdminRoleResDTO> queryAdminRole(QueryPageReqDTO<String> queryPageReqDTO){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", queryPageReqDTO.getReqDTO());
        Example example = buildExample(queryPageReqDTO.getReqDTO(), null);
        int counts = adminRoleMapper.selectCountByExample(example);
        PageUtils.Page page = pageUtils.getCount(queryPageReqDTO.getPageIndex(), queryPageReqDTO.getPageCount(), counts);
        List<AdminRole> list = adminRoleMapper.selectByExampleAndRowBounds(example, new RowBounds(page.getStartCount(), queryPageReqDTO.getPageCount()));
        QueryPageResDTO<AdminRoleResDTO> resDTO = new QueryPageResDTO<AdminRoleResDTO>();
        List<AdminRoleResDTO> list1 = (List<AdminRoleResDTO>) CollectionUtils.collect(list, object -> {
            AdminRole adminRole = (AdminRole) object;
            AdminRoleResDTO adminRoleResDTO = new AdminRoleResDTO();
            BeanUtils.copyProperties(adminRole, adminRoleResDTO);
            return adminRoleResDTO;
        });
        resDTO.setResultList(list1);
        return resDTO;
    }

    private Example buildExample(String name, Boolean status){
        Example example = new Example(AdminRole.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (null != status){
            criteria.andEqualTo("status", status ? 1 : 0);
        }
        return example;
    }



}
