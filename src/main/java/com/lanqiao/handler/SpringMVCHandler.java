package com.lanqiao.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/26 18:31
 * @Description:
 */
@Controller
@RequestMapping("SpringMVCHandler")
public class SpringMVCHandler {
    @RequestMapping("welcome/abc")
    public String welcome(){
        return "success";
    }
}
