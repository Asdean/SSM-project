<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<%--    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>--%>
    <script type="text/javascript">
        $(function() {
            //绑定事件
            $("#btnAjax").on("click",function() {
                $.ajax({
                    // url:"return-void-ajax.do",
                    // url:"doStudentJson.do",
                    url:"doListJsonArray.do",
                    // url:"doStringData.do",
                    data: {
                        name:"lisi",
                        age:20
                    },
                    dataType:"json",
                    // dataType:"text",
                    success:function(resp) {
                        // resp = XMLHttpRequest.responseText;
                        // alert("resp="+resp.name+"----"+resp.age);
                        $.each(resp,function(i,n) {
                            // n指的是[{"name":"李四同学","age":26}, {"name":"张三同学","age":20}]成员
                            alert("n name="+n.name+"----age="+n.age);
                        })
                        // alert("resp=="+resp);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <p>控制器方法返回String-逻辑视图名称</p>
    <form action="return-String-view.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交参数">
    </form>
    <br/>
    <br/>
    <p>控制器方法返回String-完整视图路径</p>
    <form action="return-String-view2.do" method="post">
        姓名：<input type="text" name="name"> <br/>
        年龄：<input type="text" name="age"> <br/>
        <input type="submit" value="提交参数">
    </form>

    <br/>
    <br/>
    <button id="btnAjax">发起ajax请求</button>
</body>
</html>
