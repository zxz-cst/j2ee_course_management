<%@ page language="java" import="java.util.*,j2ee.zxz.classes.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession Session = request.getSession(true);
%>

<!DOCTYPE html>
<html>
  <head>
    <title>table.html</title>
	<meta charset="UTF-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  <body >
  <form action = "/Homework_062/servlet/CourseController" method = "POST">
   <table width="300" border="1" cellspacing="0" id="tab1" align="center" style="width: 647px; ">
            <caption>学号：<u><%= Session.getAttribute("result1") %></u>  姓名：<u><%= Session.getAttribute("result2") %></u>  
            <tr>
                <td style="width: 30px; "> </td>
                <td align = 'center'><strong>序号</strong></td>
                <td align = 'center' style="width: 248px; "><strong>课程名称</strong></td>
                <td align = 'center'><strong>分数</strong></td>
            </tr>
<%
/* CourseDAO DAO = new CourseDAO();
Course[] cs = new Course[10000];
cs = DAO.findcourse();
  if(cs[i] == null)
	    break; */
	    List<HitCourse> htc = (List<HitCourse>)Session.getAttribute("result3");
	    for(int i = 0;i<htc.size();i++){
	  
	
	     %>
	     <tr>
	         <td><input type = "checkbox" name = "checkbox" value = <%=htc.get(i).getCourseId() %> ></td>
	     	 <td><%=htc.get(i).getCourseId() %></td>
		     <td><%=htc.get(i).getCourseName() %></td>
		     <td><%=htc.get(i).getScore() %></td>
		     
		  

	     </tr>
  <%
  }
   %>

        </table>
        <center>
       <br>

<input type = "submit" name = "sub" value = "退选">    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type = "submit" name = "sub" value = "课程管理">

</center>
</form>
</body>
</html>
