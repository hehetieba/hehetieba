<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie8 no-ie10 no-ie11 no-ios no-ios7 ipad" lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">  
  <meta charset="utf-8">
  <title>Hehe</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
  <link rel="stylesheet" href="css/font-awesome.css" type="text/css">
  <link rel="stylesheet" href="css/simple-line-icons.css" type="text/css">
  <link rel="stylesheet" href="css/app.css" type="text/css">  
  <link rel="stylesheet" href="css/default.css">
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
  <section class="vbox">
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-info nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        <a href="" class="navbar-brand text-lt">
          <i class="icon-emoticon-smile"></i>
          <img src="images/logo.png" alt="." class="hide">
          <span class="hidden-nav-xs m-l-sm">HeHe</span>
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
          <i class="icon-settings"></i>
        </a>
      </div>      <ul class="nav navbar-nav hidden-xs">
        <li>
          <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
            <i class="icon-indent-right"></i>
          </a>
        </li>
      </ul>
      <form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs" role="search">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-btn">
              <button type="submit" class="btn btn-sm bg-white btn-icon rounded"><i class=" icon-search"></i></button>
            </span>
            <input class="form-control input-sm no-border rounded" placeholder="本吧搜索" type="text">
          </div>
        </div>
      </form>
      <div class="navbar-right ">
      <a id="modal-login" href="#modal-container-login" role="button" class="btn" data-toggle="modal">登录</a><a href="register" class="btn">注册</a>
	<c:if test="${not empty user}">
	<script> alert(1);</script>
	</c:if>
<!--         <ul class="nav navbar-nav m-n hidden-xs nav-user user"> -->
    
<!--           <li class="dropdown"> -->
<!--             <a href="#" class="dropdown-toggle bg clear" data-toggle="dropdown"> -->
<!--               <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm"> -->
<!--                 <img src="images/a0.png" alt="..."> -->
<!--               </span> -->
<!--                华dee<b class="caret"></b> -->
<!--             </a> -->
<!--             <ul class="dropdown-menu animated fadeInRight">             -->
<!--               <li> -->
<!--                 <span class="arrow top"></span> -->
<!--                 <a href="#">Settings</a> -->
<!--               </li> -->
<!--               <li> -->
<!--                 <a href="#">Profile</a> -->
<!--               </li> -->
<!--               <li> -->
<!--                 <a href="#"> -->
<!--                   <span class="badge bg-danger pull-right">3</span> -->
<!--                   Notifications -->
<!--                 </a> -->
<!--               </li> -->
<!--               <li> -->
<!--                 <a href="#">Help</a> -->
<!--               </li> -->
<!--               <li class="divider"></li> -->
<!--               <li> -->
<!--                 <a href="#" >Logout</a> -->
<!--               </li> -->
<!--             </ul> -->
<!--           </li> -->
<!--         </ul> -->
      </div>      
    </header>
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
        <aside class="bg-black dk nav-xs aside hidden-print" id="nav">          
          <section class="vbox">
            <section class="w-f-md scrollable">
              <div style="position: relative; overflow: hidden; width: auto; height: 514px;" class="slimScrollDiv"><div style="overflow: hidden; width: auto; height: 514px;" class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railopacity="0.2">
                


                <!-- nav -->                 
                <nav class="nav-primary hidden-xs">
                  <ul class="nav bg clearfix">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      Discover
                    </li>
                    <li>
                      <a href="#">
                        <i class="icon-refresh icon text-success"></i>
                        <span class="font-bold">What's new</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class=" icon-envelope icon"></i>
						<b class="badge bg-danger pull-right">6</b>
                        <span class="font-bold">Message</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="icon-drawer icon text-primary-lter"></i>
                        <b class="badge bg-primary pull-right">6</b>
                        <span class="font-bold">Events</span>
                      </a>
                    </li>
                    <li>
                      <a href="#">
                        <i class="icon-list icon  text-info-dker"></i>
                        <span class="font-bold">Listen</span>
                      </a>
                    </li>
                    <li>
                      <a href="#" data-target="#content" data-el="#bjax-el" data-replace="true">
                        <i class="icon-social-youtube icon  text-primary"></i>
                        <span class="font-bold">Video</span>
                      </a>
                    </li>
                    <li class="m-b hidden-nav-xs"></li>
                  </ul>
                  <ul class="nav" data-ride="collapse">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      Interface
                    </li>
                    <li>
                      <a href="#" class="auto">
                        <span class="pull-right text-muted">
                          <i class="fa fa-angle-left text"></i>
                          <i class="fa fa-angle-down text-active"></i>
                        </span>
                        <i class="icon-screen-desktop icon">
                        </i>
                        <span>Layouts</span>
                      </a>
                      <ul class="nav dk text-sm">
                        <li>
                          <a href="#" class="auto">                                                        
                            <i class="fa fa-angle-right text-xs"></i>

                            <span>Color option</span>
                          </a>
                        </li>
                        <li>
                          <a href="#" class="auto">                                                        
                            <i class="fa fa-angle-right text-xs"></i>

                            <span>Boxed layout</span>
                          </a>
                        </li>
                        <li>
                          <a href="#" class="auto">                                                        
                            <i class="fa fa-angle-right text-xs"></i>

                            <span>Fluid layout</span>
                          </a>
                        </li>
                      </ul>
                    </li>

                  
                  </ul>
                </nav>
                <!-- / nav -->
              </div><div style="background: none repeat scroll 0% 0% rgb(0, 0, 0); width: 10px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 0px; height: 514px;" class="slimScrollBar"></div><div style="width: 10px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: none repeat scroll 0% 0% rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 0px;" class="slimScrollRail"></div></div>
            </section>
		
          </section>
        </aside>
        <!-- /.aside -->
        <section id="content">
          <section class="hbox stretch">
            <section>
              <section class="vbox">
                <section  style="padding:0; overflow:auto;">
   				<div ><img src="images/bg.jpg"  style=" width:100%;"><img src="images/barhead.jpg" style=" width:14%;margin-left:3%; margin-top:-8%;">
                <p style="margin-left:20%; margin-top:-6%; color:#000; position:relative;">
                <span class="bar-title">电影吧</span>
                <span class="blue-btn-wrapper"><a class="blue-btn" href="#">取消</a></span>
                </p>	
                   <span class="fallow-wrapper">关注：<span style="color:#FF773C;">2222222</span></span> <span  class="post-wrapper">帖子：<span style="color:#FF773C;">2222222</span></span>
                <p style="margin-left:20%;">我掉这个是吧的个性签名吗？是的！</p>
                </div>
                	<div style=" background-color:#3a2;  width:100%; height:50px;">看帖</div>
			<div  class="tie-main">
            <ul style=" list-style:none; padding:0;">
                  <li style="padding: 15px 20px 10px 20px; display:table; border-bottom:1px solid #EBEBEB;">
                  
                  <div  style="display:table-cell;">  <span class="rank-num" >143345</span></div>
                     <div style="display:table-cell; width:100%; padding-left:10px;">
                <p><a style="vertical-align: -3px; font-size:16px; color:#00a2ea; " href="#">标题标题标题标题标题标题</a>   <i class="icon-user" style=" display:inline-block; width:150px;float:right;">sassssssadas</i></p>
                  <p><span>这个真的是内容内容，一楼的内容啊。。。</span><i class="icon-comment "  style=" display:inline-block; width:150px;float:right;" ><span style="display:inline-block; width:70px;">33ssssss3</span><span style="margin-left:20px;">22:00</span></i></p>
                  <img src="images/m0.jpg" style="height:100px;">
                  </div>
                  </li>
                  </ul></div>
                  <aside class="hidden-xs" style="float:right; width:30%; background:#000; height:500px;">
                  
                  </aside>
                
                </section>
              </section>
            </section>
           
          </section>
          <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
        </section>
      </section>
    </section>    
  </section>
   
			
			<div class="modal fade" id="modal-container-login" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								登录
							</h4>
						</div>
					
						<div class="modal-body">
                       
						<p>	<label>用户名</label> <input id="username" type="text"></p>
                           <p> <label>密码</label><input id="pwd" type="password"></p>
                           
						</div>
						<div class="modal-footer">
							 <a type="button" class="btn  btn-warning" href="register">注册</a> <button type="button" class="btn btn-primary login-btn">登录</button>
						</div>
					
					</div>
					
				</div>
				
			</div>
 <script src="js/jquery-1.9.1.min.js"></script>
  <!-- Bootstrap -->
  <script src="js/bootstrap.js"></script>
  <!-- App -->
  <script src="js/app.js"></script>  
  <script src="js/jquery.js"></script>
    <script src="js/app_002.js"></script>
  <script type="text/javascript" src="js/jquery_002.js"></script>
<script>
   $(document).ready(function(e) {
	   $(".login-btn").click(function(){
		      $.ajax({
		          	type:"post",
					url:"hehetieba/userAction_login",
					data:{
						username:$("#username").val(),
						pwd:$("#pwd").val()
						},
					dataType : "json",
					success:function(data){
						alert(data.flag);
						} ,
					error:function(){
						alert("未知错误");
						}	
		          })  
		});
    
});

</script>
</body></html>