package com.lanqiao.handler;

import com.lanqiao.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/26 18:31
 * @Description:
 */

@Controller
@RequestMapping("SpringMVCHandler")
public class SpringMVCHandler {

    @RequestMapping(value = "welcome",method = RequestMethod.POST,params = {"name=zs","age=23"})
    //拦截对应index.jsp下面的welcome
    public String welcome(){
        return "success";//view/success.jsp
    }

    @RequestMapping(value = "welcome2/*/test")
    //拦截对应index.jsp下面的welcome
    public String welcome2(){
        return "success";//view/success.jsp
    }

    @RequestMapping(value = "welcome5/{name}")
    //拦截对应index.jsp下面的welcome
    public String welcome5(@PathVariable("name") String name ){
        System.out.println(name);
        return "success";//view/success.jsp
    }

    @RequestMapping(value = "testPost/{id}",method = RequestMethod.POST)
    public String testPost(@PathVariable("id") Integer id){
        System.out.println("post:增加"+id);
        //Service实现真正的增加
        return "success";
    }

//    @ResponseBody
    @RequestMapping(value = "testDelete/{id}", method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Integer id){
        System.out.println("delete:删除"+id);
        //Service实现真正的增加
        return "success";
    }

//    @ResponseBody
    @RequestMapping(value = "testPut/{id}",method = {RequestMethod.PUT})
    public String testPut(@PathVariable("id") Integer id){
        System.out.println("put:改"+id);
        //Service实现真正的增加
        return "success";
    }

    @RequestMapping(value = "testGet/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id){
        System.out.println("GET:查"+id);
        //Service实现真正的增加
        return "success";
    }

    @RequestMapping(value = "testParam")
    public String testParam(@RequestParam("uname") String name,@RequestParam(value = "uage",required = false,defaultValue = "23") Integer age){
        //request.getParameter("uname") 等价
        System.out.println("传递参数值:"+ name + ","+ age );
        //Service实现真正的增加
        return "success";
    }

    @RequestMapping(value = "testRequestHeader")
    public String testReqeustHeader(@RequestHeader("Accept-Language") String language){
        System.out.println("语言参数：" + language);
        return "success";
    }

    @RequestMapping(value = "testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String jsessionid){
        System.out.println("JSession：" + jsessionid);
        return "success";
    }

    @RequestMapping(value = "testObjectProperties")
    public String testObjectProperties(Student student){
        //Student属性必须和form表单中的name属性一直
        System.out.println(student);
        return "success";
    }

    @RequestMapping("testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        System.out.println(name);
        return "success";
    }




}

