package com.golpesoft.erp.web.controller.test;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guanjieye on 2018/5/19.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        System.out.println(request.getContextPath());
        mav.setViewName("test");
        return mav;
    }
}
