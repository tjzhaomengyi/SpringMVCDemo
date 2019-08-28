<%--
  Created by IntelliJ IDEA.
  User: zhaomengyi
  Date: 2019/8/26
  Time: 下午6:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<br>
first springmvc -welcome success</br>
${requestScope.student.id} -${requestScope.student.name} </br>
${requestScope.student2.id} -${requestScope.student2.name} </br>
${requestScope.student3.id} -${requestScope.student3.name} </br>
${requestScope.student4.id} -${requestScope.student4.name} </br>
=====</br>
${sessionScope.student1.id} -${sessionScope.student1.name} </br>
${sessionScope.student2.id} -${sessionScope.student2.name} </br>
${sessionScope.student3.id} -${sessionScope.student3.name} </br>
${sessionScope.student4.id} -${sessionScope.student4.name} </br>

<fmt:message key="resource.exist"></fmt:message>
<fmt:message key="resource.welcome"></fmt:message>

</body>
</html>
