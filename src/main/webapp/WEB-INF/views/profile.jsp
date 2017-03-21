<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2016/11/29
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
<h1>Your Profile</h1>
<c:out value="${spitter.username}" /><br/>
<c:out value="${spitter.firstName}" /> <c:out value="${spitter.lastName}" /><br/>
<c:out value="${spitter.email}" />
</body>
</html>
