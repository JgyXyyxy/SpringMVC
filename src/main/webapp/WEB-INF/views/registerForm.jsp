<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2016/11/28
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@page session="false" %>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
    <h1>Register</h1>

    <sf:form method="POST" commandName="spitter">
        <sf:errors path="*" element="div" cssClass="errors" />
        <sf:label path="firstName"
                  cssErrorClass="error"> First Name</sf:label>:
            <sf:input path="firstName" cssErrorClass="error"/><br/>
        <sf:label path="lastName"  cssErrorClass="error">Last Name</sf:label>:
            <sf:input path="lastName"  cssErrorClass="error"/><br/>
        <sf:label path="email" cssErrorClass="error">Email</sf:label>:
            <sf:input path="email" cssErrorClass="error" /><br/>
        <sf:label path="username"
                  cssErrorClass="error">Username</sf:label>:
            <sf:input path="username" cssErrorClass="error" /><br/>
        <sf:label path="password"
                  cssErrorClass="error">Password</sf:label>:
            <sf:password path="password" cssErrorClass="error" /><br/>
        <input type="submit" value="Register" />
    </sf:form>

</body>
</html>
