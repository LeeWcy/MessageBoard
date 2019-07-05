<%@ page language="java" import="java.util.*,bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>留言板</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/><link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript">
	function text(){
		var a=document.getElementsByTagName("textarea").value;
		if(a.length<10){
			alert("留言内容字数不能小于10"+"   "+a.length)
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<%
	String name="";
	String account="";
	LoginBean l = (LoginBean) session.getAttribute("login");
 		if (l == null){
 			response.sendRedirect("UserLogin.jsp");
 		}else{
 			name = l.getAdminName();
 			account = l.getAccount();
 		}
 	
 %>
<body>
	<div id="header">
      <h1>留言界面</h1>   
    </div>
    
    <div id="nav">
        <%
    		int tag=-1;
    		if (l == null){
    		}else{
    			tag = l.getAuth();
    		}
      	%>
         <ul>
	         <li><a href="index.jsp">首页</a></li>
			 <li><a href="<%-- <%=flag %> --%>MessageView">留言列表</a></li>
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
    <div id="content" >
       <!--left-->
         <div class="left">
           <div class="weizi">
           <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>发表留言</h1></div>
           </div>
          <div class="wz1" align="center">
           	<form action="DoAddMessage" method="post">
           		<table>
           		<tr>
           			<th>账号</th>
           			<td> <input type="text" disabled="disabled" name="account"required value=<%=account%>></td>
           		</tr>
           		<tr>
           			<th>留言人</th>
           			<td> <input type="text" disabled="disabled" name="name"required value=<%=name%>></td>
           		</tr>
              <tr>
              	<th>留言主题：</th>
              	<td><input type="text" name="them"></td>
            	</tr>
            	<tr>
              	<th>留言题目：</th>
              	<td><input type="text" name="title"required/></td>
            	</tr>
            	<tr>
              	<th>留言内容：</th>
              	<td><textarea name="content"></textarea></td>
              </table>
               <div class="clear"></div>
               <th colspan="2"align="center"><input type="submit" value="添加留言" onclick="text()" /></th>
  			</form>
         	</div>
        </div>
         <!--end left -->
         <div class="clear"></div>
    </div>
    <!--content end-->
    <!--footer-->
    <div id="footer">
    </div>
    <!--footer end-->
</body>
</html>
