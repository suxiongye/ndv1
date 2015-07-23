<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-7-22
  Time: 上午11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>SearchLightR</title>
    <link href="/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<form class="form" action="<%=basePath%>servlet/SearchLightRServlet" method="get">
    <div class="form-group">
        <label class="label form-control">时间间隔</label>
        <input type="text" class="form-control" name="time">
    </div>
    <div class="form-group">
        <label class="form-control">
            <input class="btn btn-default" type="submit" value="确认">
        </label>
    </div>

</form>
</body>
</html>
