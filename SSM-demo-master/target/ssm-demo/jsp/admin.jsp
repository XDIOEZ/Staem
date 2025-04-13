<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理后台</title>
    <style>
        table { border-collapse: collapse; width: 80%; }
        th, td { padding: 8px 12px; border: 1px solid #ccc; }
    </style>
</head>


<body>
<h2>用户管理</h2>
<a href="${pageContext.request.contextPath}/jsp/userRig.jsp">添加用户</a>
</body>

<body>
<h2>查找用户</h2>
<form action="${pageContext.request.contextPath}/user/findById.do" method="post">

    <div class="form-group">
        <label for="id">身份码</label>
        <input type="text" id="id" name="id" placeholder="输入您的身份码" autocomplete="username" required>

    <button type="submit">查找</button>
    </div>

</form>
</body>

</html>
