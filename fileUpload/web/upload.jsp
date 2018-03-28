<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/28
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload组件上传</title>
    <!-- 1.准备好webuploader的资源 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/webuploader.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/webuploader.js"></script>
</head>
<body>
    <!--设计页面元素-->
    <div id="uploader">
        <!--拖拽文件-->
        <div id="filePicker">点击选择文件</div>
    </div>


    <!--使用webuploader进行渲染-->
    <script type="text/javascript">
        var uploader = WebUploader.create(
            {
                //flash地址
                swf:"${pageContext.request.contextPath}/js/Uploader.swf",
                //设置提交的服务地址
                server:"${pageContext.request.contextPath}/UploadServlet",
                //渲染文件上传元素
                pick:"#filePicker",
                //自动上传
                auto:true
            }
        );
    </script>

</body>
</html>
