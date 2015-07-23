<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-7-22
  Time: 上午10:38
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
    <title>UConn</title>
    <link href="/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<form class="form" action="<%=basePath%>/servlet/UConnServlet" method="get">
<div class="form-group">
    <label class="label form-control">素数</label>
    <input type="text" class="form-control" name="prime">
</div>
<div class="form-group">
    <label class="form-control">
        <input class="btn btn-default" type="submit" value="确认">
    </label>
</div>

</form>
</body>
</html>
