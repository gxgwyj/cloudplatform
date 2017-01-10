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
        <div id="Content-Main">
            <input type="button" value="添加" onclick="addPanel();"/>
            <table style="width: 100%;" border="1px">
                <tr>
                    <th>编码</th>
                    <th>类别</th>
                    <th>名称</th>
                    <th>品牌</th>
                    <th>价格</th>
                </tr>
                <c:forEach items="${productlist}" var="product">
                    <tr>
                        <td style="text-align: center;">${product.pCode}</td>
                        <td style="text-align: center;">${product.pCategory}</td>
                        <td style="text-align: center;">${product.pName}</td>
                        <td style="text-align: center;">${product.pBrand}</td>
                        <td style="text-align: center;">${product.pPrice}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <%--<div id="Footer">Footer</div>--%>
</div>
</body>
<script>
    function addPanel() {
        window.location.href = "/product/edit";
    }
</script>
</html>
