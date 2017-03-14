<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>商品列表</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/main.css"/>
</head>
<style type="text/css"></style>
<body>
<div id="Container">
    <jsp:include page="header.jsp"></jsp:include>
    <div id="Content">
        <jsp:include page="left.jsp"></jsp:include>
        <form action="<%=basePath%>product/tx/add" method="post">
            <div id="Content-Main">
                <table style="width: 100%;" border="1px">
                    <tr>
                        <th colspan="4">类别</th>
                    </tr>
                    <tr>
                        <td>编码：</td>
                        <td><input type="text" name="t_code" style="width: 100%;"/></td>
                    </tr>
                    <tr>
                        <td>名称：</td>
                        <td><input type="text" name="t_name" style="width: 100%;"/></td>
                    </tr>
                </table>
                <table style="width: 100%;" border="1px">
                    <tr>
                        <th colspan="4">品牌</th>
                    </tr>
                    <tr>
                        <td>编码：</td>
                        <td><input type="text" name="p_code" style="width: 100%;"/></td>
                    </tr>
                    <tr>
                        <td>名称：</td>
                        <td><input type="text" name="p_name" style="width: 100%;"/></td>
                    </tr>
                    <tr>
                        <td>产地：</td>
                        <td><input type="text" name="place" style="width: 100%;"/></td>
                    </tr>
                </table>
                <input type="submit" value="保存">
            </div>
        </form>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <%--<div id="Footer">Footer</div>--%>
</div>
</body>
</html>
