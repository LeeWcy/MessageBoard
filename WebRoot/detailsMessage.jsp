<%@ page language="java" import="java.util.*,bean.*,dao.*,servlet.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="dao.*" %>
<%@page import="dao.MessageDao.*" %>
<%@page import="bean.*" %>
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
      <h1>详情页面</h1>
    </div>
     <!--header end-->
    <!--content start-->
    <div id="content">
         <!--left-->
         <div class="left" id="c_left">
           <div class="s_tuijian">
           		<h2>具体<span>详情</span></h2>
           </div>
           
          <div class="content_text">
           <!--wz-->
           <% List<MessageBean> bean=(List<MessageBean>)request.getAttribute("message");
			for(MessageBean bean2 : bean)
			{ 
 			%>
           <div class="wz">
            <h3>标题：<%=bean2.getMessgaeTitle() %></h3>
             <dl>
               <dd>
                 <p class="dd_text_1"><strong>内容</strong>：<%=bean2.getMessageContent() %></p>
                 <p class="left author">&nbsp;&nbsp;&nbsp;&nbsp;<strong>作者</strong>：<%=bean2.getName() %> &nbsp;&nbsp;</p>
                 <p class="left sj"><strong>时间</strong>：<%=bean2.getDate1() %> &nbsp;&nbsp;</p>
                 <p class="left fl"><strong>主题</strong>：<%=bean2.getMessageThem() %> &nbsp;&nbsp;</p>
                 <% if(bean2.getReplyNum()!=null) {%>
                 	<p class="left fl"><strong>回复数</strong>：<%=bean2.getReplyNum() %> &nbsp;&nbsp;</p>
                 <%} %>  
                 <p class="left yd"><a href="MessageView" title="返回">返回</a></p>
                 <div class="clear"></div>
               </dd>
             </dl>
             <% List<ReplyBean> beanr=(List<ReplyBean>)request.getAttribute("reply");
             if(beanr != null){
				for(ReplyBean beanr2 : beanr)
				{ 
 			 %>
 			 <div class="my_reply">
	 			<p class="dd_text_1">
	 			  <br>回复编号：<%=beanr2.getID() %>
	 			  <br>回复内容：<%=beanr2.getReplyContent() %>
	 			  <br>回复人：<%=beanr2.getName() %>
	 			  <br>回复时间: <%=beanr2.getReplyDate1() %>
	 			</p>
	 		</div>
 			<%} }%>
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
