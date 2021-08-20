<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    /other.jsp, 显示request作用域中的数据
    <br />
    <h3>myname:${myname}</h3>
    <h3>funmyagec:${myage}</h3>
    <br />
    <br />
    <br />
    <p>使用param获取参数</p>
    <h3>myname:${param.myname}</h3>
    <h3>myage:${param.myage}</h3>
</body>
</html>
