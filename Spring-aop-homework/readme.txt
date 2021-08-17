ch13-aop-homework: 使用aop做方法的参数检查


要求：
1.当addNumber方法的参数，是不为null的时候，
2.当addNumber方法的参数是大于0时。 才能执行addNumber()计算，三个数的和
3.如果任意一个参数 是null ，或者 小于0 。 则调用addNumber方法返回结果是 -1.
4.使用aop做addNumber()方法的参数检查。


思路：
1.使用环绕通知，在目标方法之前先执行，可以修改目标方法的执行结果
2.切面功能：做参数检查
