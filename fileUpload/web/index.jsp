<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/27
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>基本文件上传过程</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/UploadServlet" method="post" enctype="multipart/form-data">
      选择文件：<input type="file" name="name"/><br/>
      文件描述信息：<<input type="text" name="info"/><br/>
      <input type="submit" value="提交"/>
    </form>
  </body>
</html>
