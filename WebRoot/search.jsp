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
      <h1>搜索结果</h1>
    </div>
     <!--header end-->
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           <h2>查询<span>结果：</span></h2>
           </div>
           <% List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
          <div class="content_text">
           <!--wz-->
           <div class="wz">
            <h3><%=bean2.getMessgaeTitle() %></h3>
             <dl>
             
               <dd>
                 <p class="dd_text_1"><%=bean2.getMessageContent() %>></p>
               <p class="dd_text_2">
               <span class="left author"><%=bean2.getName() %></span>
               <span class="left fl">主题：<%=bean2.getMessageThem() %></span><br/><hr/> <%} %> <span class="left yd"><a href="MessageView" title="返回">返回</a>
               </span>
                <div class="clear"></div>
               </dd>
             </dl>
            </div>
           <!--wz end-->
                          
           </div>
         </div>
         <!--left end-->
       </div>  
    <!--footer start-->
    <!--footer end-->
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>
