<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>
	<meta charset="UTF-8">
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
   <script type="text/javascript">
    function myFunction1()
    {
    var obj1 = document.getElementById("xiId");
    var obj2 = document.getElementById("xueyuanId");
    var nowIndex2 = obj2.selectedIndex;
    if(obj2.options[nowIndex2].value === "计算机学院")
    {
       obj1.value = "计算机科学与技术";
    }
     if(obj2.options[nowIndex2].value === "人工智能学院")
    {
       obj1.value = "智能科学与技术";
    }
     if(obj2.options[nowIndex2].value === "自动化学院")
    {
       obj1.value = "机械自动化";
    }
    
    }
    function myFunction2()
    {
    var obj1 = document.getElementById("xiId");
    var obj2 = document.getElementById("xueyuanId");
    var nowIndex1 = obj1.selectedIndex;
     
    if(obj1.options[nowIndex1].value === "计算机科学与技术"||obj1.options[nowIndex1].value === "软件工程")
    {
       obj2.value = "计算机学院";
    }
    if(obj1.options[nowIndex1].value === "智能科学与技术")
    {
       obj2.value = "人工智能学院";
    }
    if(obj1.options[nowIndex1].value === "机械自动化"||obj1.options[nowIndex1].value === "电气自动化")
    {
       obj2.value = "自动化学院";
    }
    
    }
    </script>
  <center>
  <form action = "/Homework_062/servlet/LoginController" method = "POST">
 
    用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户： <input type = "text" name = "username"/><br>
    <br>
    密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： <input type = "password" name = "password"/><br>
    <br>
    验 证 码 ：<input type = "text" name = "yanzhengma" style="width: 75px; "/><img src = "yzm.png" style="height: 19px; width: 82px"/><br>
    <br>
    所在学院 ：<select id = "xueyuanId" name = "xueyuan" onchange = "myFunction1()" style="width: 173px; "> 
    <option value = "计算机学院"> 计算机学院</option>
    <option value = "人工智能学院"> 人工智能学院</option> 
    <option value = "自动化学院"> 自动化学院</option> 
    </select>
    <br>
     <br>
    所在系 ：<select id = "xiId" name = "xi" onchange = "myFunction2()" style="width: 157px; "> 
    <option value = "计算机科学与技术"> 计算机科学与技术</option>
    <option value = "软件工程"> 软件工程</option> 
    <option value = "智能科学与技术"> 智能科学与技术</option> 
    <option value = "机械自动化"> 机械自动化</option> 
    <option value = "电气自动化"> 电气自动化</option> 
    </select>
    <br>
    
    <br>
     <input type = "submit" value = "登录" >&nbsp;&nbsp;&nbsp;
     <a href = "https://www.baidu.com/">帮助</a>&nbsp;&nbsp;&nbsp;
     <a href = "https://www.baidu.com/">忘密</a>
      </form>
   </center>>
  </body>
</html>



