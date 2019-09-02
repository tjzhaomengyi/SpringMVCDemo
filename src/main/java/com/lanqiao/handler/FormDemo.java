package com.lanqiao.handler;

import com.lanqiao.entity.Person;
import com.lanqiao.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/FormDemo")
public class FormDemo {

    @RequestMapping(value="testForm")
    public String testForm(@ModelAttribute("per") Person per , Model model){
        per = new Person();
        per.setName("sz");
        per.setAge(23);
        model.addAttribute(per);
        //        map.put("per",per);
        return "error";
    }




    //使用相同的映射路径，使用请求方法来区分SpringMVC标签的请求
    @RequestMapping(value="testMethod",method = RequestMethod.POST)
    public String testPost(){
        System.out.println("Post");
        return "error";
    }

    @RequestMapping(value="testMethod",method = RequestMethod.DELETE)
    public String testDelete(){
        System.out.println("delete");

        return "error";
    }

    @RequestMapping(value="testMethod",method = RequestMethod.PUT)
    public String testPut(){
        System.out.println("PUT");

        return "error";
    }
    @RequestMapping(value="testMethod",method = RequestMethod.GET)
    public String testGet(){
        System.out.println("Get");

        return "error";
    }

}
