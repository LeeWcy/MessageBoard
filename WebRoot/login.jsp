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
function reloadImage(t){
	t.src="./ImageServlet?flag="+Math.random();
	}
</script>
</head>
<body>
      <!--header start-->
    <div id="header">
      <h1>登录界面</h1>
      <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>    
    </div>
     <!--header end-->
    <!--nav-->
    <div id="nav">
        <ul>
         <li><a  href="index.jsp">首页</a></li>
		 <li><a href="MessageView">留言列表</a></li>
         <li><a href="guestbook.jsp">发表留言</a></li>
         <li><a href="lianjie.jsp">友情链接</a></li>
          <li><a href="login.jsp">管理员登录</a></li>
         <div class="clear"></div>
        </ul>
     </div>
       <!--nav end-->
    <!--content start-->
    <div id="content">
       <!--left-->
         <div class="left">
           <div class="weizi" ">
           <div class="wz_text">当前位置：<a href="index.jsp">首页</a>><h1>管理员登录</h1></div>
           </div>
           <div class="wz1">
            <center>
          <table style="margin-top: 30px font-size:20px">
          <form action="LoginServlet1" method="post">
           		<tr>
           			<th>用户名</th>
           			<td> <input type="text" name="name"required placeholder="默认为admin"></td>
           		</tr>
              <tr>
              	<th>密码：</th>
              	<td><input type="text" name="password"></td>
            	</tr>
            	<tr>
           		<td> <img src="./ImageServlet" align="middle" alt="看不清 ，点击这里" onclick="reloadImage(this)"></td>
              	<td><input type="text" name="authcode"required placeholder="验证码"/></td>
            	</tr>
               <div class="clear"></div>
               <th colspan="2"align="center"><input type="submit" value="登录" onclick="text()" /></th>
          </form>
          </table></center>
          </div>
</div>
</body>
</html>
