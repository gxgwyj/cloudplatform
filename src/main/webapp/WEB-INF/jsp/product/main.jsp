<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>商品维护管理</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
</head>
<style type="text/css"></style>
<body>
<div id="Container">
    <jsp:include page="header.jsp"></jsp:include>
    <div id="Content">
        <jsp:include page="left.jsp"></jsp:include>
        <div id="Content-Main"></div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <%--<div id="Footer">Footer</div>--%>
</div>
</body>
</html>
