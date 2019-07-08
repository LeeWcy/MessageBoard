<%@ page language="java" import="java.util.*,bean.*,dao.*,servlet.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>留言系统</title>
<meta name="keywords" content="留言板" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
</head>
	<%
	int pageNo=Integer.parseInt( request.getAttribute("pageNo").toString());
	int pageLa=Integer.parseInt(request.getAttribute("page").toString()); 
	 %>
<body>
<div id="header">
      <h1>留言列表</h1>
      </div>
    <!--nav-->
    <div id="nav">
    
    <%
    		

    		LoginBean l = (LoginBean) session.getAttribute("login");
    		int tag=-1;
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
         <li><a href="PersonalCenter">个人中心</a></li>
         <li><a href="LogoutServlet">退出登录</a></li>
         <%} %>
         <% if(tag == 0){%>
         <li><a href="PersonalCenter">个人中心</a></li>
         <li><a href="LogoutServlet">退出登录</a></li>
         <%} %>
         <%if(tag == -1){ %>
         <li><a href="login.jsp">管理员登录</a></li>
         <%} %>
         <div class="clear"></div>
        </ul>
      </div>
      
      <div class="order-and-search" align="center">
    	<form action="MessageList" method="post">
	   		<input type="text" name="search" id="search"/>
	   		<input type="submit" value="搜索" />
   		</form> 
   		<form action="OrderByTimeServlet" method="post">
	   		<input type="submit" name="1" value="按时间升序" />
	   		<input type="submit" name="2" value="按时间降序" />
   		</form> 
   		<form action="OrderByReply" method="post">
	   		<input type="submit" name="ByReply" value="按回复数排序" />
   		</form> 
         
    	</div>
      
       <!--nav end-->
       
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2>管理员<span>页面</span></h2>
           </div>
           <% 
          
           List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="content_text">
           <!--wz-->
           <div class="wz">
            <h3><a href="OperationServlet?id=<%=bean2.getID() %>&&flag=<%="XQ" %>" ><%=bean2.getMessgaeTitle() %></a></h3>
             <dl>  
               <dd>
               <p class="dd_text_2">
               <span class="left author"><%=bean2.getName() %></span><span class="left sj"><%=bean2.getDate1() %></span>
               <span class="left yd"><a href="OperationServlet?flag=<%="XG"%>&&id=<%= bean2.getID()%>" >修改</a>
               </span>
               <span class="left yd">
               	<a href="OperationServlet?flag=<%="HF"%>&&id=<%= bean2.getID()%>">回复</a></span>
               	<%if(l != null)
               		if(l.getAuth() != 1){%>
               	<span class="left yd"><a href="OperationServlet?flag=<%="Delete"%>&&id=<%= bean2.getID()%>">删除</a>
               	<%} %>
               	</span>
                <div class="clear"></div>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
            <!--wz-->
            
            <%
            }    
            %>
         <!--left end-->
      <div align="center">
         	<tr>
	       		<td colspan="7" rowspan="2">
		            <a href="MessageView?pageNo=<%=pageNo>1?(pageNo-1):1 %>">首页&nbsp;&nbsp;</a> 
		            <a href="MessageView?pageNo=<%=pageNo-1 %>">上一页&nbsp;&nbsp;</a>
		            <a href="MessageView?pageNo=<%=pageNo<pageLa?(pageNo+1):pageLa %>">下一页&nbsp;&nbsp;</a>      
		            <a href="MessageView?pageNo=<%=pageLa %>">尾页</a>
		        </td>
            </tr>
         </div>
        </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>
