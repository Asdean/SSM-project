<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>逐个接收请求参数</p>
    <form action="receive-property.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <br/>
    <p>逐个接收请求参数: 请求中参数名和形参名不一样</p>
    <form action="receive-param.do" method="post">
        姓名：<input type="text" name="rname"> <br/>
        年龄：<input type="text" name="rage"> <br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <p>对象接收请求参数， 请求中参数名和对象的属性名一样</p>
    <form action="receive-object.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="对象接收参数">
    </form>
</body>
</html>
