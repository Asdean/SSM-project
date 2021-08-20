拦截器的执行顺序，以及方法控制请求的执行顺序
```xml
<!--声明顺序-->
<!--声明拦截器对象-->
    <mvc:interceptors>
        <!--声明第一个拦截器-->
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.example.handler.MyInterceptor" />
        </mvc:interceptor>
        
        <!--声明第二个拦截器-->
        <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <bean class="com.example.handler.MyInterceptor2" />
        </mvc:interceptor>
    </mvc:interceptors>
```


1）两个拦截器，第一个preHandle=true, 第二个拦截器preHandle=true

```xml
----MyInterceptor1拦截器的preHandle----
----MyInterceptor2拦截器的preHandle----
执行了MyController的doSome方法
----MyInterceptor2拦截器的postHandle----
----MyInterceptor1拦截器的postHandle----
----MyInterceptor2拦截器的afterCompletion----
----MyInterceptor1拦截器的afterCompletion----
```

请求的执行顺序：

用户some.do---拦截器1的preHandle----拦截器2preHandle---控制器doSome---拦截器2postHandle---拦截器1的postHandle---拦截器2的afterCompletion---拦截器1的afterCompletion。



2）两个拦截器，第一个preHandle=true, 第二个拦截器preHandle=false

```xml
----MyInterceptor1拦截器的preHandle----
----MyInterceptor2拦截器的preHandle----
----MyInterceptor1拦截器的afterCompletion----
```





3）两个拦截器，第一个preHandle=false, 第二个拦截器preHandle=true|false

```xml
----MyInterceptor1拦截器的preHandle----
```



使用多个拦截器作用

1. 把验证功能分散到独立的拦截器。 每个拦截器做单一的验证处理。
2. 组合多个拦截器。 