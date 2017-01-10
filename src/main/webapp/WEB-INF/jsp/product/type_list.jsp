<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>商品类别列表</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
</head>
<style type="text/css"></style>
<body>
<div id="Container">
    <jsp:include page="header.jsp"></jsp:include>
    <div id="Content">
        <jsp:include page="left.jsp"></jsp:include>
        <div id="Content-Main">
            <form action="<%=basePath%>product/type/add" method="post">
                编码：<input name="code" type="text"/>名称：<input name="name" type="text"/>
                <input type="submit" value="添加"/>
            </form>
            <table style="width: 100%;" border="1px">
                <tr>
                    <th>编码</th>
                    <th>名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${categorylist}" var="category">
                    <tr>
                        <td style="text-align: center;">${category.code}</td>
                        <td style="text-align: center;">${category.name}</td>
                        <td style="text-align: center;">
                            <a>【编辑】</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <%--<div id="Footer">Footer</div>--%>
</div>
</body>
</html>
