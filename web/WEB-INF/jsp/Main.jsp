<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Staem管家 - 主页</title>
    <style>
        body {
            font-family: "微软雅黑", sans-serif;
            background-color: #f5f5f5;
            padding: 40px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        .welcome {
            margin-top: 20px;
            font-size: 20px;
            color: #555;
        }
    </style>
</head>
<body>
<h1>欢迎来到 Staem管家主页！</h1>

<div class="welcome">
    <c:if test="${not empty sessionScope.user}">
        欢迎您，<b>${sessionScope.user.username}</b>！
    </c:if>
</div>
</body>
</html>
