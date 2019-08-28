package com.lanqiao.handler;

import com.lanqiao.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: zhaomengyi
 * @Date: 2019/8/26 18:31
 * @Description:
 */

@Controller
@RequestMapping("SpringMVCHandler")
//@SessionAttributes("student4")//student4既放在了request作用域中，又放到了session作用域汇总
//@SessionAttributes(types = Student.class)
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

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        //返回的既有数据又有视图
        ModelAndView mv = new ModelAndView("success");//View:success,会自动加前缀后缀
        Student student = new Student();
        student.setId(1);
        student.setName("zs");
        mv.addObject("student",student);//这句话相当于request.setAttribute
        return mv;
    }

    //这里把请求转发方式改成重定向方式
    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap mm){
        //返回的既有数据又有视图
        Student student = new Student();
        student.setId(2);
        student.setName("ls");
        mm.put("student2",student);
//        return "success";
        return "forward:/WEB-INF/view/success.jsp";
    }

    @RequestMapping("testMap")
    public String testMap(Map<String,Object> m){
        //返回的既有数据又有视图
        Student student = new Student();
        student.setId(3);
        student.setName("ww");
        m.put("student3",student);
        return "success";
    }

    @RequestMapping("testModel")
    public String testModel(Model model){
        //返回的既有数据又有视图
        Student student = new Student();
        student.setId(4);
        student.setName("zl");
        model.addAttribute("student4",student);
        return "success";
    }

    //查询,该方法打开会在该Controller的每个请求方法前执行
    /***
    @ModelAttribute
    public void queryStudentById(Map<String,Object> map){
        //StudentService stuService = new StudentServiceImpl();
        //Student student = stuService.queryStudentById(31);
        //模拟调用工作层查询数据库的操作
        Student student = new Student();
        student.setId(31);
        student.setName("zs");
        student.setAge(23);
        map.put("student",student);//约定map的key就是方法参数类型的首字母小写
    }
    **/

    //修改
    @RequestMapping("testModelAttribute")
    public String testModelAttribute(Student student){
        //前端传来ls，把上面查询的结果改成ls
        student.setName("ls");
        System.out.print(student.toString());
        return "success";
    }


    //国际化
    @RequestMapping("testI18n")
    public String testI18n(){
        return "success";
    }

    //类型转换
    @RequestMapping("testConverter")
    public String testConverter(@RequestParam("studentInfo") Student student){
        System.out.println(student.toString());
        return "success";
    }


    //日期格式转换
    //类型转换
    @RequestMapping("testDateFormat")
    public String testDateFormat(Student student, BindingResult result,Map<String,Object> map){
        System.out.println(student.getBirthday());
        if(result.getErrorCount() > 0 ){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getDefaultMessage());

                map.put("errors",result.getFieldErrors());//将错误信息放入request域中
            }
        }
        return "success";
    }
}

