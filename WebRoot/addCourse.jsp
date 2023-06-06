<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addCourse.jsp' starting page</title>
    
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
  <center>
  <form action = "/Homework_062/servlet/CourseController" method = "post">
  <label>
   课程名称：<input type = "text" name = "coursename">
   </label>
    <br>
    <br>
     <label>
   选课人数：<input type = "text" name = "coursenum">
   </label>
    <br>
    <br>
   <label>
  课程性质：<select name = "coursetype">
  <option value = "必修"> 必修</option>
  <option value = "选修"> 选修</option>   
  </select>
   </label>
    <br>
   <br>
   <input type = "submit" name = "sub" value = "确认"> 
  
  </form>
  </center>
   
  
    
  </body>
</html>
