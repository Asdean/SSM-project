<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + request.getContextPath()+"/";
    // http://localhost:8080/SpringMVC/
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
    <%--

    --%>

    <%--页面访问中，访问路径 以/开头 和 没有以/开头--%>
    <p>测试路径</p>
    <a href="some.do">发起请求some.do，没有以/开头，转发show.jsp</a>
    <br />
    <a href="test/some.do">完整路径，test/some.do</a>
    <br />

    <br />
    <a href="${pageContext.request.contextPath}/test/some.do">解决方式:使用EL表达式<span>$</span><span>{pageContext.request.contextPath}</span></a>

    <br />
    <br />
    <br />
    <br />
    <a href="/test/some.do">以/开头, /test/some.do</a>
    <br />
    <a href="${pageContext.request.contextPath}/test/some.do">解决方式:使用EL表达式<span>$</span><span>{pageContext.request.contextPath}</span></a>
    <br />
    <br />
    <br />
    <br />
    <a href="http://www.baidu.com">以协议地址开头</a>
    <%--<a href="test/some.do">发起请求test/some.do</a>--%>
</body>
</html>
