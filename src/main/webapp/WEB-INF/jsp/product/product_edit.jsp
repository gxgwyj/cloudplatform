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
        <form action="<%=basePath%>product/add" method="post">
            <div id="Content-Main">
                <table style="width: 100%;" border="1px">
                    <tr>
                        <td>商品名称：</td>
                        <td colspan="3"><input type="text" name="pName" style="width: 100%;"/></td>
                    </tr>
                    <tr>
                        <td>商品编码：</td>
                        <td><input type="text" name="pCode"/></td>
                        <td>价格：</td>
                        <td><input type="text" name="pPrice"/></td>
                    </tr>
                    <tr>
                        <td>类别：</td>
                        <td>
                            <select style="width: 80%;" name="pCategory">
                                <option value="0">请选择</option>
                                <c:forEach items="${categories}" var="c">
                                    <option value="${c.code}">${c.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>品牌</td>
                        <td>
                            <select style="width: 80%;" name="pBrand">
                                <option value="0">请选择</option>
                                <c:forEach items="${brands}" var="b">
                                    <option value="${b.bCode}">${b.bName}</option>
                                </c:forEach>
                            </select>
                        </td>
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
