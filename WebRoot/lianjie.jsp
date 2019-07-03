<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>学无止境-个人博客</title>
<meta name="keywords" content="个人博客" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/index.css"/>
<link rel="stylesheet" href="css/style.css"/>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<!-- bxSlider Javascript file -->
<script src="js/jquery.bxslider.min.js"></script>
<!-- bxSlider CSS file -->
<link href="css/jquery.bxslider.css" rel="stylesheet" />

<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
      <!--header start-->
    <div id="header">
      <h1>个人博客</h1>
      <p>青春是打开了,就合不上的书。人生是踏上了，就回不了头的路，爱情是扔出了，就收不回的赌注。</p>    
    </div>
     <!--header end-->
    <!--nav-->
     <div id="nav">
         <ul>
         <ul>
         <li><a href="index.jsp">首页</a></li>
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
     <ul class="bxslider">
  <li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/renren.png" />
             <div class="fire"></div> 
            <a href="https://www.renren.com" class="x" target="_blank"></a>

          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/zhifubao.png" />
            <div class="fire"></div>
            <a href="https://www.alipay.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/sina.png" />
              <div class="fire"></div> 
            <a href="https://www.sina.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/appstore.com.png" />
            <div class="fire"></div>
 						<a href="https://www.appstore.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/douban.png" />
             <div class="fire"></div> 
             <a href="https://www.douban.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/bdlogo.gif" />
            <div class="fire"></div>
             <a href="https://www.baidu.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/yahoo.com.png" />
             <div class="fire"></div> 
             <a href="https://www.yahoo.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/dangdang.png" />
            <div class="fire"></div>
             <a href="https://www.dangdang.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/youtube.png" />
             <div class="fire"></div> 
             <a href="https://www.youtube.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/twitter.com.png" />
            <div class="fire"></div>
             <a href="https://www.twitter.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/aiqiyi.png" />
             <div class="fire"></div> 
             <a href="https://www.aiqiyi.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/appstore.com.png" />
            <div class="fire"></div>
             <a href="https://www.appstore.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/amazon.com.png" />
              <div class="fire"></div> 
             <a href="https://www.amazon.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/youtube.com.png" />
            <div class="fire"></div>
             <a href="https://www.youtube.com" target="_blank" class="x"></a>
        </div>          
      </li>
  </ul>
</li>
<li>
    <ul>
        <li>
          <div class="case_w">
              <img src="images/bdlogo.gif" />
              <div class="fire"></div> 
             <a href="https://www.baidu.com" target="_blank" class="x"></a>
          </div>
        </li>
        <li>
        <div class="case_w">
            <img src="images/google.com.png" />
            <div class="fire"></div>
             <a href="https://www.google.com" target="_blank" class="x"></a>
        </div>          
      </li>
   </ul>
</li>
</ul>
</div>
         <div class="clear"></div>
         
    </div>
    <!--content end-->
 
    <!--footer end-->
    <script type="text/javascript">
$(function(){
  $(".bxslider li ul li").hover(function(){ 
    $(".x",this).stop().css({'left':'35px'}).animate({'left':"40px"},400).show();
    $(".y",this).stop().css({'right':'35px'}).animate({'right':"40px"},400).show();
    $('.fire',this).fadeIn(500);
  },function(){
    // $('.x, .y',this).stop().animate({"top":"30px"},400);
    $('.fire, .x, .y',this).fadeOut(500);
  }); 
});
</script>

<script type="text/javascript">
	$(document).ready(function(){
 	 	$('.bxslider').bxSlider({
 	 		  minSlides: 4,
			  maxSlides: 4,
			  nextSelector: '#slider-next',
  			prevSelector: '#slider-prev',
  			slideWidth: 240,
        slideMargin:0,
			  auto: false
 	 	});
	});
</script>
    <script type="text/javascript">jQuery(".lanmubox").slide({easing:"easeOutBounce",delayTime:400});</script>
    <script  type="text/javascript" src="js/nav.js"></script>
</body>
</html>