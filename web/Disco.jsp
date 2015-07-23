<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-7-21
  Time: 下午11:16
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
    <title>Disco</title>
    <link href="/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<form class="form" action="<%=basePath%>servlet/DiscoServlet" method="get">
    <div class="form-group">
        <label class="label form-control">素数1</label>
        <input type="text" class="form-control" name="prime1">
    </div>
    <div class="form-group">
        <label class="label form-control">素数2</label>
        <input type="text" class="form-control" name="prime2">
    </div>
    <div class="form-group">
        <label class="form-control">
            <input class="btn btn-default" type="submit" value="确认">
        </label>
    </div>

</form>
</body>
</html>
