package com.lanqiao.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/29 16:58
 * @Description:该类专门处理各个类中的异常
 */

//@Controller
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({Exception.class})//该方法可以捕获本类中抛出的ArithmeticException异常,自动放入方法的参数中
    public String handlerArithmeticException(Exception e, Model model){//我这里使用model，map的方法不能在页面回显
        System.out.println(e);
//        map.put("e",e);
        model.addAttribute("e",e);//把异常放到request作用域中，给前端
        System.out.println(e+"该类可以处理任何类的异常");
        return "error";
    }
}
