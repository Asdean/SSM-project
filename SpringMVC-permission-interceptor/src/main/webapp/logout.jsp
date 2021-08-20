<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>
  模拟登出
  <%
      session.removeAttribute("username");
  %>

</body>
</html>
