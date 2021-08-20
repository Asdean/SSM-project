在页面中，有路径的问题， 访问路径有 "/"开头的， 还有没有 “/”。

```xml
<a href="test/some.do">没有斜杠开头</a>
<a href="/test/some.do">有斜杠开头</a>
<a href="http://www.baidu.com">有协议开头的地址</a>
```

地址的区别，现在看的都是在页面中的地址。

1）有协议开头的例如http://www.baidu.com ,  称为绝对地址。 地址是唯一的，你能够直接访问

2）没有协议开头的，例如 test/some.do   , /test/some.do 称为相对地址。 相对地址单独使用不能表示某个资源，不能访问。 相对地址必须有参考地址在一起，才能表示一个资源的完整地址，才能访问。



参考地址：  有“ /" 和没有”/“ 参考地址不同的。

1）没有斜杠开头的地址， 参考地址：当前资源的访问路径

​     当前访问的地址： http://localhost:8080/SpringMVC_path/index.jsp

​    资源名称： index.jsp

​    资源路径：  http://localhost:8080/SpringMVC_path

​    在index.jsp 有 访问地址 a href="test/some.do"

​    点击some.do后， 地址变成 http://localhost:8080/SpringMVC_path/test/some.do

```xml
此时：http://localhost:8080/SpringMVC_path/test/some.do
资源名称：some.do
资源路径：http://localhost:8080/SpringMVC_path/test/

在去点击 test/some.do 地址：http://localhost:8080/SpringMVC_path/test/test/some.do

```

没有斜杠开头的地址：  参考地址 + 当前的相对地址 组合在一起是最后的访问地址



解决方式：

  ```xml
1)使用${pageContext.request.contextPath}。 表示访问项目的路径（上下文件 context path）
<a href="${pageContext.request.contextPath}/test/some.do">发起请求test/some.do</a>

优点：好理解
缺点：每个链接地址，都需要加el表达式

2)固定当前页面中的 没有“/”开头地址的 参考地址
使用html中base标签
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            +":"+request.getServerPort()+request.getContextPath()+"/";
%>
<head>
    <title>浏览学生</title>
    <base href="<%=basePath%>">
 </head>
  ```





2) 有斜杠开头的地址

a href="/test/some.do"

```xml
现在访问的的 http://localhost:8080/SpringMVC_path/index.jsp
在index.jsp中有  /test/some.do.
点击/test/some.do,地址变成 http://localhost:8080/test/some.do

有斜杠开头的地址，参考地址是 服务器地址， 也就是从协议开始到端口号的位置 http://localhost:8080

地址组成：http://localhost:8080/test/some.do

地址缺少项目访问路径， SpringMVC_path. 

```

解决问题的方式：在你的路径前面加入 el表达式 ${pageContext.request.contextPath}

```xml
<p>有/开头的地址</p>
<a href="${pageContext.request.contextPath}/test/some.do">/test/some.do</a>
```

