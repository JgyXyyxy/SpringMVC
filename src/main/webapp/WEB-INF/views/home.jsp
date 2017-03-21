<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page session="false" %>
<html>
<head>
    <title>Spittr</title>
</head>
<body>
    <h1>Welcome</h1>
    <a href="<c:url value="/spittles" />">Spittles</a> |
    <a href="<c:url value="/spitter/register" />">Rigister</a>
</body>
</html>
