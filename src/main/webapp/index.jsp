<%--
  Created by IntelliJ IDEA.
  User: zhaomengyi
  Date: 2019/8/26
  Time: 10:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
<%--    <script type="text/javascript" src="WEB-INF/statics/js/jquery.js"></script>--%>
    <script src="https://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $("#testJson").click(function() {
               //通过ajax请求Springmvc
               $.post(
                   "SpringMVCHandler/testJson",//服务器地址，请求SpringMVCHandler的服务
                   // {"name":"zs","age":23}//请求并带参数
                   function(result){//服务端处理完的回调函数,接收返回handler中的Students
                         for(i=0;i<result.length;i++){
                           alert(result[i].id + "-"+ result[i].age+"-"+result[i].name)
                         }
                   }
               )
            });
        });

    </script>
</head>
<body>
<a href="SpringMVCHandler/welcome">first springmvc -welcome</a>
<a href="user/welcome">first springmvc -welcome user</a>

<form action="SpringMVCHandler/welcome" method="post">
    name:<input name="name">
    age:<input name="age">
    <input type="submit" value="post">
</form>
<a href="SpringMVCHandler/welcome2/abac/test">first springmvc -welcome2</a>
<a href="SpringMVCHandler/welcome5/zhangsan">first springmvc -welcome5</a>

<form action="SpringMVCHandler/testPost/1234" method="post">
    <input type="submit" value="增">
</form>

<form action="SpringMVCHandler/testDelete/1233" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="删">
</form>
<form action="SpringMVCHandler/testPut/1234" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit"  value="改">
</form>
<form action="SpringMVCHandler/testGet/234" method="get">
    <input type="submit" value="查">
</form>

<form action="SpringMVCHandler/testParam" method="get">
    <input name="uname" type="text">
<%--    <input name="uage" type="text">--%>
    <input type="submit" value="查">
</form>


<a href="SpringMVCHandler/testRequestHeader">testRequestheader</a>
<a href="SpringMVCHandler/testCookieValue">testCookieValue</a>

<form action="SpringMVCHandler/testObjectProperties" method="get">
    id:<input name="id" type="text">
    name:<input name="name" type="text">
    home:<input name="address.homeAddress" type="text">
    school:<input name="address.schoolAddress" type="text">
    <input type="submit" value="查">
</form>


<form action="SpringMVCHandler/testServletAPI" method="get">
    id:<input name="id" type="text">
    name:<input name="name" type="text">
    home:<input name="address.homeAddress" type="text">
    school:<input name="address.schoolAddress" type="text">
    <input type="submit" value="查">
</form>

<a href="SpringMVCHandler/testModelAndView">testModelAndView</a>
<a href="SpringMVCHandler/testModelMap">testModelMap</a>
<a href="SpringMVCHandler/testMap">testMap</a>
<a href="SpringMVCHandler/testModel">testModel</a>

<br/>

<form action="SpringMVCHandler/testModelAttribute" method="get">
    id:<input name="id" type="hiden" value="31">
    name:<input name="name" type="text">
    <input type="submit" value="修改">
</form>

<a href="SpringMVCHandler/testI18n">国际化</a>

<br/>
<a href="SpringMVCHandler/testMvcViewController">直接跳转</a>


<form action="SpringMVCHandler/testConverter" method="post">
    学生信息：<input name="studentInfo" type="text" >
    <input type="submit" value="转换">
</form>

<form action="SpringMVCHandler/testDateFormat" method="post">
    id:<input name="id" type="text">
    name:<input name="name" type="text">
    age:<input name="age" type="text">
    birth:<input name="birthday" type="text">
    email:<input name="email" type="text">
    <input type="submit" value="查">
</form>

<input type="button" value="testJson" id="testJson">

<br/>
<br/>

<form action="SpringMVCHandler/testUpload" method="post" enctype="multipart/form-data">
    <input name="file" type="file"/>
    描述：<input name="desc" type="text"/>
    <input type="submit" value="上传"/>
</form>

<br/>
<a href="SpringMVCHandler/testInterceptor">testInterceptor</a>

<a href="second/testException">testException</a>

</body>
</html>
