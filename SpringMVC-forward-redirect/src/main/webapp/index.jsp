<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>请求转发</p>
    <a href="doForward.do">发起doForward.do的get请求</a>
    <br/>
    <p>重定向redirect</p>
    <form action="doRedirect.do" method="post">
        姓名<input type="text" name="name"><br/>
        年龄<input type="text" name="age"><br/>
        操作<input type="submit" value="提交"><br/>
    </form>
</body>
</html>
