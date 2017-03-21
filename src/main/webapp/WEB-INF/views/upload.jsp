<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2017/2/20
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<div class="upload">
    <form action="upload" enctype="multipart/form-data" method="post">
        <input type="file" name="file"/><br/>
        <input type="submit" value="upload">
    </form>
</div>

</body>
</html>
