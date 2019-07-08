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
	LoginBean l = (LoginBean) session.getAttribute("login");
	 %>
<body>
<div id="header">
      <h1>个人中心</h1>
      </div>
    <!--nav-->
    <div id="nav">
        <ul>
        
         <li><a  href="index.jsp">首页</a></li>
		 <li><a href="MessageView">留言列表</a></li>
         <li><a href="guestbook.jsp">发表留言</a></li>
         <li><a href="LogoutServlet">退出登录</a></li>
        </ul>
    </div>
    <!--nav end-->
       
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2><%=l.getAdminName()%><span>页面</span></h2>
           </div>
           <div class="person-content">
           <p><strong>我的回复</strong></p>           
           <% 
           List<ReplyBean> beanr=(List<ReplyBean>)request.getAttribute("reply");
			for(ReplyBean beanr2 : beanr)
			{ 
 			%>
            <p class="my_reply">
 			  <br>回复编号：<%=beanr2.getID() %>
 			  <br>回复内容：<%=beanr2.getReplyContent() %>
 			  <br>原贴编号：<%=beanr2.getMsgId()%><a href="OperationServlet?id=<%=beanr2.getMsgId() %>&&flag=<%="XQ" %>">查看原帖</a>
 			  <br>回复时间: <%=beanr2.getReplyDate1() %>
 			</p>
            <%
            }    
            %>
            <br>
            <br>
           <p><strong>我的留言</strong></p>
           <br>
           <% 
           List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="my_reply">
           <!--wz-->
           <div class="wz">
            <h3><a href="OperationServlet?id=<%=bean2.getID() %>&&flag=<%="XQ" %>" >标题：<%=bean2.getMessgaeTitle() %></a></h3>
             <dl>  
               <dd>
               <p class="myreply">
               <span class="left author">&nbsp;&nbsp;&nbsp;&nbsp;用户：<%=bean2.getName() %></span>
               <span class="left sj">&nbsp;&nbsp;&nbsp;&nbsp;日期：<%=bean2.getDate1() %></span>
               <span class="left yd"><a href="OperationServlet?flag=<%="XG"%>&&id=<%= bean2.getID()%>">&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;&nbsp;</a></span>
               <span class="left yd"><a href="OperationServlet?flag=<%="HF"%>&&id=<%= bean2.getID()%>">回复</a></span>
               	<%if(l != null)
               		if(l.getAuth() != 1){%>
               	<span class="left yd"><a href="OperationServlet?flag=<%="Delete"%>&&id=<%= bean2.getID()%>">删除</a>
               	<%} %>
               	</span>
                <div class="clear"></div>
               </dd>
             </dl>
            </div>
           <!--wz end-->
           </div> 
            <%
            }    
            %>
         <!--left end-->
         </div>
      </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>