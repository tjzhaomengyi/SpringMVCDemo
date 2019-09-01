package com.lanqiao.handler;

import com.lanqiao.entity.Person;
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

}
