<%@ page language="java" import="java.util.*,j2ee.zxz.classes.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession Session = request.getSession(true);
int currentPage = 1;
int totalPage = 3;
int pageSize = 10;
String currentPages  = request.getParameter("currentPage");
CoursePage coursepage = new CoursePage();
int all = coursepage.getCountofCourses();
if(all % pageSize == 0)
totalPage = all/pageSize;
else
totalPage = all/pageSize+1;
if(currentPages!=null&&!"".equals(currentPages.trim())) {
  currentPage = Integer.parseInt(currentPages);
}
if(currentPage < 1) {
 currentPage = 1;
}
else if(currentPage > totalPage) {
  currentPage = totalPage;
}
else {
Session.setAttribute("courses", coursepage.getAllCourses(currentPage, pageSize));
}

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
	<style>
		table tr {
		border-top-width: 1px;
		border-top-style: solid;
		border-top-color: rgb(92, 125, 166);
		}
		table {
		border-bottom-width: 1px;
		border-bottom-style: solid;
		border-bottom-color: rgb(92, 125, 166);
		font-size:20px
		}
		caption {
		margin-bottom:10px
		}
		table td {
		padding: 5px 10px;
		font-size: 12px;
		font-family: Verdana;
		color: rgb(92, 125, 166);
		font-size:15px
		}
		 
		table tr:nth-child(even) {
		background: rgb(211, 223, 237)
		}
		table tr:nth-child(odd) {
		background: #FFF
		}
		.but{
			border: none;
			height: 30px;
			width: 190px;
			margin-bottom: 10px;
			background: lightseagreen;
			color: white;
			margin-top: 10px;
		}
		.but:hover {
			background: cadetblue;
		}
		.footer {
			margin-top:20px;
		 	font-size:16px;
    
		}
		a {
			margin-right:20px;
	        text-decoration: none;
	        border:solid 1px;
	        padding: 0.4em 0.8em;
	        color: #444; 
	        border-color: #fff#aaa#aaa#fff; 
	    };   
	</style>
  </head>
  <body >
  <form action = "/Homework_062/servlet/CourseController" method = "POST">
   		<table width="300" border="1" cellspacing="0" id="tab1" align="center" style="width: 647px; ">
           <caption>用户名：<u><%= Session.getAttribute("result2") %></u>  
           <tr>
               <td style="width: 30px; "> </td>
               <td align = 'center'><strong>序号</strong></td>
               <td align = 'center' style="width: 248px; "><strong>课程名称</strong></td>
               <td align = 'center'><strong>选课人数</strong></td>
               <td align = 'center'><strong>课程性质</strong></td>
           </tr>
		<%
	    List<Course> cs = (List<Course>)Session.getAttribute("courses");
	    for(int i = 0;i<cs.size();i++){
	    %>
	     <tr>
	         <td><input type = "checkbox" name = "checkbox" value = <%=Integer.toString(cs.get(i).getCourseId()) %>></td>
	     	 <td><%=cs.get(i).getCourseId() %></td>
		     <td><%=cs.get(i).getCourseName() %></td>
		     <td><%=cs.get(i).getCourseNum() %></td>
		     <td><%=cs.get(i).getCourseType() %></td>
	     </tr>
	  	 <%
	  	 }
	  	 %>

        </table>
        <center>
        <br>
        <input type = "submit" name = "sub" value = "选课" class="but" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      	<button class="but" onclick="window.location.href='http://localhost:8080/Homework_062/addCourse.jsp'" type="button" id="add">新增</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 		<input class="but" type = "submit" name = "sub" value = "删除"> 
 		<br>
 <div class="footer">
	 <a href="allCourse.jsp?currentPage=1">首页</a> 
	 <a href="allCourse.jsp?currentPage=<%=currentPage-1%>">上一页</a> 
	 <a href="allCourse.jsp?currentPage=<%=currentPage+1%>">下一页</a>  
	 <a href="allCourse.jsp?currentPage=<%=totalPage%>">末页</a>   每页<%=pageSize%>条 总页数：<%=totalPage%>
 </div>
 
</center>
</form>
</body>
</html>
