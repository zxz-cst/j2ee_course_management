<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>  <%-- 两个JSP界面如果存在include关系则两者的局部变量不能重名 --%>
<%!
String show = "全局变量的表达式显示";
int qj; 
 %> <%-- <%! %>中申请的变量是全局变量，全部变量可以不赋初值，缺省为0（该注释是JSP的注释，客户端看不到） --%>
<%!
public void method()
{
   System.out.println("该方法任何JSP脚本元素都可以访问");
}
 %>
 <%!
public class User{
   String name;
   int age;
   User()
   {
   ;
   }
   User(String name,int age)
   {
   this.name = name;
   this.age = age;
   }
   public void setName(String name)
   {
     this.name = name;
   }
   public void setAge(int age)
   {
     this.age = age;
   }
     public String getName()
   {
     return name;
   }
   public int getAge()
   {
     return age;
   }
}
 %><%-- <%! %>中的类任何JSP脚本元素都可以访问（该注释是JSP的注释，客户端看不到） --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>My JSP 'transformation.jsp' starting page</title>
    
    <meta charset="UTF-8"> <!-- 以utf-8读入文本（该注释是HTML的注释，客户端能看到） -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    这是JSP页面的HTML静态文本元素 <br>
    <br>
   这是include指令：<br>
   <%@ include file = "index.jsp" %><br>
   <%= show %><br>
   <br>
  在脚本段内部用out.println显示 ：
  <br>
   <%
   int a = 30;
    %>
   <%
   int b = 10;
   int c = 20;
   qj += a + b + c; 
   out.println(qj);
    %><br>
    <br>
     在脚本段外部用表达式形式显示：
     <br>
    <%= qj %>
    <br>
    <%
    this.method();
     %> <!-- 声明中方法的调用,在服务端打印字符 -->
       <br>
     使用声明中的类实例对象并使用方法修改值：  <br>
       
     <%
     User myUser = new User("张三",34);
     out.println("姓名：" + myUser.getName() + "  年龄：" + myUser.getAge() + "   修改后的值为：");
     myUser.setName("李四");
     myUser.setAge(40);
     out.println("姓名：" + myUser.getName() + "  年龄：" + myUser.getAge());
      %>
      <br>
      <jsp:useBean id="stringbean" class = "j2ee.zxz.bean.StringBean"/>
      <jsp:getProperty property="message" name="stringbean"/>
      <br>
      <jsp:setProperty property="message" name = "stringbean" value="Best string bean:Fortex"/>
      <jsp:getProperty property="message" name="stringbean"/>
      <br>
      <jsp:include page="index.jsp" flush="true"/>
      <jsp:forward page="index.jsp"></jsp:forward>
  </body>
</html>
