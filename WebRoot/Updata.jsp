<%@ page language="java" import="java.util.*,dao.*,servlet.*,bean.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script>
	function text(){
		var a=document.getElementsByTagName("textarea").value;
		if(a.length<10){
			alert("留言内容字数不能小于10"+"   "+a.length);
			return false;
		}else{
			return true;
		}
	}
</script>
</head>

<body>
      <!--header start-->
    <div id="header">
      <h1>修改留言</h1>
    </div>
     <!--header end-->
       
       
    <!--content start-->
    <div id="content">
       <!--left-->
         <div class="left">
           
           <div class="s_tuijian">
           <h2>修改<span>留言</span></h2>
           </div>
           <% String flag="Updata";
           List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="wz1">
           	<form action="OperationServlet?flag=<%=flag%>&&id=<%= bean2.getID()%>" method="post">
           		<table>
   				<tr>
              	<th></th>
              	<td><input type="hidden" name="id" placeholder="<%=bean2.getID()%>"></td>
            	</tr>
           		<tr>
           			<th>留言人</th>
           			<td><%=bean2.getName() %></td>
           		</tr>
              <tr>
              	<th>留言主题：</th>
              	<td><input type="text" name="them" value="<%=bean2.getMessageThem()%>"></td>
            	</tr>
            	<tr>
              	<th>留言题目：</th>
              	<td><input type="text" name="title"required value="<%=bean2.getMessgaeTitle()%>"/></td>
            	</tr>
            	<tr>
              	<th>留言内容：</th>
              	<td><textarea id="summary"name="content" required "><%= bean2.getMessageContent()  %></textarea></td>
              </table>
               <div class="clear"></div>
               <th colspan="2"align="center"><input type="submit" value="修改留言" onclick="text()" /></th>
  					</form>
   
        </div>
        <%} %> <!--end left -->
         <div class="clear"></div>
    </div>
    </div>
    <!--content end-->
    <!--footer-->
    <div id="footer">
    </div>
    <!--footer end-->
</body>
</html>
