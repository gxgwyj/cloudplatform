<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<title>优品乐购(YP.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/index.css"/>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script ></script>
</head>
<body>
<div class="search_panel">
    <input type="text"/>
    <input type="button" value="搜索"/>
    <input type="button" value="获取锁" onclick="getLock()"/>
</div>
</body>
<script>
    function getLock(){
        $.ajax({
            type: 'POST',
            url: "/lock",
            datatype:"json",
            success: function(msg){
                alert(msg);
            },
        });
    }
</script>
</html>
