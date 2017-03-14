<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<title>平台测试界面</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/index.css"/>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script ></script>
</head>
<body>
<div class="search_panel">
    <input type="button" value="获取锁" onclick="getLock()"/>
    <input type="button" value="规定时间内的访问限制" onclick="getIncr()"/>
</div>
</body>
<script>
    function getLock(){
        $.ajax({
            type: 'POST',
            url: "/test/redis/lock",
            datatype:"json",
            success: function(msg){
                alert(msg);
            },
        });
    }
    function getIncr(){
        $.ajax({
            type: 'POST',
            url: "/test/redis/incr",
            datatype:"json",
            success: function(msg){
                alert(msg);
            },
        });
    }
</script>
</html>
