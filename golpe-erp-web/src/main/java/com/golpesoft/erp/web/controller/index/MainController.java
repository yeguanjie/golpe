package com.golpesoft.erp.web.controller.index;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = "index")
    public String index(HttpServletRequest request){
        System.out.println(request.getContextPath());

        return "index";
    }
}
