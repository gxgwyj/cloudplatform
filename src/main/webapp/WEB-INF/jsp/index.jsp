<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<title>优品乐购(YP.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/index.css"/>
</head>
<body>
<div class="search_panel">
    <input type="text"/>
    <input type="button" value="搜索"/>
</div>
</body>
</html>
