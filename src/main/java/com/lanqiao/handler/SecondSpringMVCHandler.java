package com.lanqiao.handler;

import com.lanqiao.exception.MyArrayIndexOutofBounds;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/29 16:07
 * @Description:
 */

@Controller
@RequestMapping("second")
//@ControllerAdvice
public class SecondSpringMVCHandler {

//    @ExceptionHandler({ArithmeticException.class})//该方法可以捕获本类中抛出的ArithmeticException异常,自动放入方法的参数中
//    public String handlerArithmeticException(Exception e,Model model){//我这里使用model，map的方法不能在页面回显
//        System.out.println(e);
////        map.put("e",e);
//        model.addAttribute("e",e);//把异常放到request作用域中，给前端
//        return "error";
//    }

    @RequestMapping("testException")
    public String testException(){
        System.out.println(1/0);
        return "success";
    }

    @RequestMapping("testMyException")
    public String testMyException(@RequestParam("i") Integer i) throws MyArrayIndexOutofBounds {
//        int[] nums = new int[2];
//        System.out.println(nums[2]);
        if(i == 3){
            throw new MyArrayIndexOutofBounds();
        }
        return "success";
    }

    @RequestMapping("testMyException2")
    public String testMyException2(@RequestParam("i") Integer i)  {
//        int[] nums = new int[2];
//        System.out.println(nums[2]);
        if(i == 3){
            return "redirect:testResponseStatus"; //跳转到某个异常方法中,加上重定向到一个方法中
        }
        return "success";
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "数组越界")
    @RequestMapping("testResponseStatus")
    public String testResponseStatus()  {

        return "error";
    }

}
