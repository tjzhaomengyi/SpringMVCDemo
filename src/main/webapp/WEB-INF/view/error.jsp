<%--
  Created by IntelliJ IDEA.
  User: zhaomengyi
  Date: 2019/8/29
  Time: 下午4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${requestScope.e}
<br/>
    <form:form modelAttribute="per">
        姓名:<form:input path="name"/><br/>
        年龄:<form:input path="age"/><br/>
        <input type="submit" value="提交"/>
    </form:form>
</body>
</html>
