<%@ page language="java" import="java.util.*,bean.*,dao.*,servlet.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
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
      <h1>详情页面</h1>
      <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>    
    </div>
     <!--header end-->
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2>具体<span>详情</span></h2>
           </div>
           <% List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="content_text">
           <!--wz-->
           <div class="wz">
            <h3>标题：<%=bean2.getMessgaeTitle() %></h3>
             <dl>
               <dd>
                 <p class="dd_text_1">内容：<%=bean2.getMessageContent() %></p>
               <p class="dd_text_2">
               <p class="left author">作者：<%=bean2.getName() %> </p><p class="left sj">时间：<%=bean2.getDate1() %> </p>
               <p class="left fl">主题：<%=bean2.getMessageThem() %></p><p class="left yd"><a href="MessageView" title="返回">返回</a>
               </p>
                <div class="clear"></div>
               </dd>
             </dl>
             <% List<ReplyBean> beanr=(List<ReplyBean>)request.getAttribute("reply");
			for(ReplyBean beanr2 : beanr)
			{ 
 			%>
 			<p class="dd_text_1">
 			  <br>回复编号：<%=beanr2.getID() %>
 			  <br>回复内容：<%=beanr2.getReplyContent() %>
 			  <br>回复人：<%=beanr2.getName() %>
 			  <br>回复时间: <%=beanr2.getReplyDate1() %>
 			</p>
 			<%} %>
            </div>
           <!--wz end-->
              <%} %>               
           </div>
         </div>
         <!--left end-->
       </div>  
    <!--footer start-->
    <div id="footer">
     <p></p>
    </div>
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>
