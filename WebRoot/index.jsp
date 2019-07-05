<%@ page language="java" import="java.util.*,bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/><link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript"></script>
</head>
<% String flag; 
	LoginBean login=(LoginBean)session.getAttribute("login");
	  
	 %>
<body>
      <!--header start-->
    <div id="header">
      <h1>首页</h1>   
    </div>
     <!--header end-->
    <!--nav-->
    <div id="nav">
    <%
    		int tag=-1;
    		LoginBean l = (LoginBean) session.getAttribute("login");
    		if (l == null){
    		}else{
    			tag = l.getAuth();
    		}
      %>
        <ul>
         <li><a  href="index.jsp">首页</a></li>
		 <li><a href="MessageView">留言列表</a></li>
         <li><a href="guestbook.jsp">发表留言</a></li>
         <% if(tag == -1){ %>
         <li><a href="UserLogin.jsp">用户登录</a></li>
         <%} %>
         <% if(tag == 1){%>
         <li><a href="LogoutServlet">退出登录</a></li>
         <%} %>
         <% if(tag == 0){%>
         <li><a href="LogoutServlet">退出登录</a></li>
         <%} %>
         <%if(tag == -1){ %>
         <li><a href="login.jsp">管理员登录</a></li>
         <%} %>
         <div class="clear"></div>
        </ul>
     </div>
       <!--nav end-->
    <!--content start-->
    <div id="content">
       <!--left-->
         <div class="left">
           <div class="weizi">
           <div class="wz_text">当前位置：<a href="index.jsp">首页</a></div>
           </div>
		</div>
	</div>
</body>
</html>
