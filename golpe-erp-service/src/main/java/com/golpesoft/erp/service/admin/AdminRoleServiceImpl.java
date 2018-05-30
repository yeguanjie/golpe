package com.golpesoft.erp.service.admin;

import com.golpesoft.erp.common.exceptions.BizException;
import com.golpesoft.erp.facade.enums.TradeStateEnum;
import com.golpesoft.erp.facade.models.request.QueryPageReqDTO;
import com.golpesoft.erp.facade.models.response.AdminRoleVO;
import com.golpesoft.erp.facade.models.response.QueryPageResDTO;
import com.golpesoft.erp.process.admin.AdminRoleProcessImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminRoleServiceImpl {

    @Autowired
    private AdminRoleProcessImpl adminRoleProcess;

    public QueryPageResDTO<AdminRoleVO> queryAdminRole(QueryPageReqDTO<String> queryPageReqDTO){
        log.info("123");
        QueryPageResDTO<AdminRoleVO> resDTO;
        try {
            resDTO = adminRoleProcess.queryAdminRole(queryPageReqDTO);
        } catch (BizException e) {
            log.info("分页查询错误：{}", e);
            resDTO = new QueryPageResDTO<>();
            resDTO.setRespStatus(TradeStateEnum.FAIL.getCode());
            resDTO.setRespCode(e.getCode());
            resDTO.setRespMsg(e.getMessage());
        }
        return resDTO;
    }
}
