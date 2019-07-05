<%@ page language="java" import="java.util.*,bean.*,dao.*,servlet.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>留言详情</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
</head>

<body>
    <!--header start-->
    <div id="header">
      <h1>回复页面</h1>
      
    </div>
     <!--header end-->
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2>回复<span>留言</span></h2>
           </div>
           <% List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			if(bean==null){
			%>
			<%
			}
			else{ for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="content_text">
           <!--wz-->
           <div class="wz">
            <h3>标题：<%=bean2.getMessgaeTitle() %></h3>
             <dl>
             
               <dd>
                 <p class="dd_text_1">内容：<%=bean2.getMessageContent() %>></p>
                <form action="OperationServlet?flag=<%="reply" %>&id=<%=bean2.getID() %>" method="post"><p class="dd_text_1"><textarea name="replyContent"></textarea>
               	
               </p>
               <p class="dd_text_2">
               <span class="left author">用户：<%=bean2.getName() %></span>
               <span class="left sj">时间：<%=bean2.getDate1() %></span>
               <span class="left fl">主题：<%=bean2.getMessageThem() %></span>
               <span class="left "><a><input type="submit" value="回复" /></a>
               </span></form>
                <div class="clear"></div>
               </p>
               </dd>
               <div class="clear"></div>
             </dl>
            </div>
           <!--wz end-->
              <%} }%>               
           </div>
         </div>
         <!--left end-->
         
    <!--footer start-->
    <div id="footer">
     <p></p>
    </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>
