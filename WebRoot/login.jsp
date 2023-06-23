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
	<style>
		html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img {
		margin: 0;
		padding: 0;
		}
		body {
			text-align:center;
			margin-top:100px;
			
		}
		#box {
			width: 288px;
			height: 470px;
			margin: 0 auto;
			text-align: center;
			background: white;
			border:  solid 5px;
			border-radius: 15px;
		}
		
		#box .header h3 {
			font-size: 24px;
			line-height: 42px;
		}
		
		#box .header .detail {
			font-size: 13px;
			line-height: 20px;
		}
		
		
		#box .content  ul{
			margin-left: 10px;
			margin-bottom: 8px;
			font-weight: 50;
			color:  black;
			float: left;
			list-style-type: none;
			text-align: left;
			
		}
		#box .content  ul li{
			height: 30px;
			width: 345px;
			margin-bottom: 30px;
			
		}
		
		#box .content  ul li input{
			height: 25px;
			width: 260px;
			margin-bottom: 20px;
			
		}
		
		#box .content  ul li select{
			height: 25px;
			width: 260px;
			margin-bottom: 20px;
			
		}
		
		#box .content  ul .sub{
			border: none;
			height: 30px;
			width: 270px;
			margin-bottom: 10px;
			background: lightseagreen;
			color: white;
			margin-top: 10px;
		}
		#box .content ul .sub:hover {
			background: cadetblue;
		}
		#box p{
			font-size: 15px;
		}
		
		#box  .footer a {
			text-decoration: none;
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
  
  <div id="box">
  			<form action = "/Homework_062/servlet/LoginController" method = "POST">
			<div class="header">
			<h3 class="title">课程管理系统</h3>
		    <p class="detail">Welcome!</p>	
			</div>
			
			<div class="content">
				<ul>
					<li><label>学 号</label><br />
						<input type = "text" name = "username"/>
					</li>
					<li><label>密 码</label><br />
						<input type = "password" name = "password"/>
					</li>
					<li><label>验 证 码</label><br />
						<input type = "text" name = "yanzhengma" style="width: 190px; "/><img src = "yzm.png" style="height: 19px; width: 82px"/>
					</li>
					<li><label>所在学院</label><br />
						<select id = "xueyuanId" name = "xueyuan" onchange = "myFunction1()" > 
						    <option value = "计算机学院"> 计算机学院</option>
						    <option value = "人工智能学院"> 人工智能学院</option> 
						    <option value = "自动化学院"> 自动化学院</option> 
						</select>
					</li>
					<li><label>所在系</label><br />
						<select id = "xiId" name = "xi" onchange = "myFunction2()" > 
						    <option value = "计算机科学与技术"> 计算机科学与技术</option>
						    <option value = "软件工程"> 软件工程</option> 
						    <option value = "智能科学与技术"> 智能科学与技术</option> 
						    <option value = "机械自动化"> 机械自动化</option> 
						    <option value = "电气自动化"> 电气自动化</option> 
					    </select>
					</li>
					
					<li>
						<input type = "submit" value = "登录" class="sub"/>
					</li>
				</ul>
			</div>
			
			
			
			<div class="footer">
			<p>
				<a href="#">帮助</a>  <a href="#">忘记密码</a>
			</p>	
			</div>
		</div>
  </body>
</html>



