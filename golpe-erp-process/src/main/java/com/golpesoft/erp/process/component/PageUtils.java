package com.golpesoft.erp.process.component;

import com.golpesoft.erp.common.exceptions.BizException;
import com.golpesoft.erp.facade.enums.BizCode;
import com.golpesoft.erp.facade.enums.TradeStateEnum;
import com.golpesoft.erp.facade.models.response.QueryPageResDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 分页
 */
@Slf4j
@Component
public class PageUtils {
    //记录数
    public static final String COUNT = "COUNT";
    //list
    public static final String LIST = "LIST";

    /**
     * @param currentPage 分页数
     * @param pageCount   每页记录数
     * @param totalCount  总记录数
     * @return 返回开始记录数和结束记录数
     */
    public Page getCount(int currentPage, int pageCount, int totalCount) {
        Page page = new Page();
        if (totalCount == 0)
            throw new BizException(BizCode.NOT_EXIST_COUNT_DATA.getCode(), BizCode.NOT_EXIST_COUNT_DATA.getDesc());

        if(currentPage == 0 || currentPage < 0)
            throw new BizException(BizCode.NOT_EXIST_COUNT_DATA.getCode(), BizCode.NOT_EXIST_COUNT_DATA.getDesc());

        int totalPages = totalCount % pageCount == 0 ? totalCount / pageCount : totalCount / pageCount + 1;
        if (currentPage < totalPages) {
            page.setStartCount((currentPage - 1) * pageCount);
            page.setEndCount(pageCount);
        } else {
            if (totalCount % pageCount == 0) {
                page.setStartCount((currentPage-1) * pageCount);
                page.setEndCount(pageCount);
            } else {
                page.setStartCount((currentPage - 1) * pageCount);
                page.setEndCount(totalCount % pageCount);
            }
        }
        return page;
    }

    @Getter
    @Setter
    public static class Page {
        int startCount;
        int endCount;
    }

}
