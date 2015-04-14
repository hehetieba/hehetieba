<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html
	class="app js no-touch no-android no-chrome firefox no-iemobile no-ie no-ie8 no-ie10 no-ie11 no-ios no-ios7 ipad"
	lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Hehe</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.css" type="text/css">
<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css">
<link rel="stylesheet" href="css/app.css" type="text/css">
<link rel="stylesheet" href="css/default.css">
	<link href="css/toastr.css" rel="stylesheet" type="text/css"/>
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
  	<script src="js/jquery-1.9.1.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.js"></script>
	<!-- App -->
	<script src="js/app.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/app_002.js"></script>
	<script type="text/javascript" src="js/jquery_002.js"></script>
	<script src="ueditor/ueditor.config.js"></script>
	<script src="ueditor/ueditor.all.min.js"></script>
	<script src="js/extendPagination.js"></script>
	<script type="text/javascript" src="js/toastr.js"></script>
</head>
<style>
img {
	max-width: 100%;
}
</style>

<body class="">
<input type="hidden" id="louzhu">
<input id="totalRecord" type="hidden"  value='' >
		<section class="vbox">
		<header
			class="bg-white-only header header-md navbar navbar-fixed-top-xs">
			<div class="navbar-header aside bg-info nav-xs">
				<a class="btn btn-link visible-xs"
					data-toggle="class:nav-off-screen,open" data-target="#nav,html">
					<i class="icon-list"></i>
				</a> <a href="all-tieba" class="navbar-brand text-lt"> <i
					class="icon-emoticon-smile"></i> <img src="images/logo.png" alt="."
					class="hide"> <span class="hidden-nav-xs m-l-sm">HeHe</span>
				</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
					data-target=".user"> <i class="icon-settings"></i>
				</a>
			</div>
			<ul class="nav navbar-nav hidden-xs">
				<li><a href="#nav,.navbar-header"
					data-toggle="class:nav-xs,nav-xs" class="text-muted"> <i
						class="icon-indent-right"></i>
				</a></li>
			</ul>
			<div class="navbar-right ">
				<c:if test="${empty user}">

					<a id="modal-login" href="#modal-container-login" role="button"
						class="btn m1" data-toggle="modal">登录</a>
					<a href="register" class="btn m1">注册</a>
					<span style="line-height: 34px; float: right;" class="visible-xs">请先登录哦！</span>
				</c:if>
				<c:if test="${not empty user}">
					<ul class="nav navbar-nav m-n hidden-xs nav-user user">

						<li class="dropdown"><a href="#"
							class="dropdown-toggle bg clear" data-toggle="dropdown"> <span
								class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
									<c:if test="${not empty user.headImg}">
										<img class="'myhead'" src='${user.headImg}' alt='...'>
									</c:if> <c:if test="${empty user.headImg}">
										<img class="'myhead'" src='images/unknow.png' alt='...'>
									</c:if>
							</span> ${user.nickname}<b class="caret"></b>
						</a>
							<ul class="dropdown-menu animated fadeInRight">
								<li><span class="arrow top"></span> <a href="myindex">个人中心</a>
								</li>
								<li class="divider"></li>
								<li><a id="logout-btn">注销</a></li>
							</ul></li>
					</ul>
				</c:if>

			</div>
		</header>
		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-black dk nav-xs aside hidden-print" id="nav">
					<section class="vbox">
						<section class="w-f-md scrollable">
							<div
								style="position: relative; overflow: hidden; width: auto; height: 514px;"
								class="slimScrollDiv">
								<div style="overflow: hidden; width: auto; height: 514px;"
									class="slim-scroll" data-height="auto"
									data-disable-fade-out="true" data-distance="0" data-size="10px"
									data-railopacity="0.2">
									<!-- nav -->
									<nav class="nav-primary hidden-xs">
										<ul class="nav bg clearfix">
											<li><a href="all-tieba"> <i class=" icon-home icon"></i>
													<span class="font-bold">主页</span>
											</a></li>
											<li
												class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
												发现</li>
											<li><a
												href="tie?tiebaId=<%=request.getParameter("tiebaId")%>">
													<i class="icon-refresh icon text-success"></i> <span
													class="font-bold">刷新</span>
											</a></li>

											<li><c:if test="${not empty user}">
													<a href="myindex">
												</c:if> <c:if test="${empty user}">
													<a onclick="toastr['error']('请先登录！')">
												</c:if> <i class="icon-user icon text-primary-lter"></i> <span
												class="font-bold">个人中心</span> </a></li>
											<li class="m-b hidden-nav-xs"></li>
										</ul>
										<ul class="nav" data-ride="collapse">

											<li><a href="#" class="auto"> <span
													class="pull-right text-muted"> <i
														class="fa fa-angle-left text"></i> <i
														class="fa fa-angle-down text-active"></i>
												</span> <i class="icon-heart icon"> </i> <span>爱逛的吧</span>
											</a>
												<ul class="nav dk text-sm myfa">
													<li><a class='auto'>请先登录</a></li>
												</ul></li>


										</ul>
									</nav>
									<!-- / nav -->
								</div>
								<div
									style="background: none repeat scroll 0% 0% rgb(0, 0, 0); width: 10px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 0px; height: 514px;"
									class="slimScrollBar"></div>
								<div
									style="width: 10px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 7px; background: none repeat scroll 0% 0% rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 0px;"
									class="slimScrollRail"></div>
							</div>
						</section>

					</section>
				</aside>
				<!-- /.aside -->
				<section id="content">
					<section class="vbox">
						<section class="scrollable wrapper-lg">
							<div class="row">
								<div class="col-sm-9">
									<div style="margin-bottom: 20px;"><h1 class=" title"></h1><span  class="tie-manager btn btn-primary" style="position:relative;margin-right: 15px;float: right;cursor: pointer;display: none;">帖子管理
									<ul class="dlist">
									<li><a onclick="deltie();">删除</a></li>
									<li><a onclick="jiajing();">加精</a></li>
									<li><a onclick="cancelJiajing()">取消加精</a></li>
									<li><a onclick="settop()">置顶</a></li>
									<li><a onclick="cancelSettop()">取消置顶</a></li>
									</ul></span>
									<div style="clear: both;"></div>
									
									</div>
									<div class="blog-post"></div>
								
									<div id="callBackPager"></div>
									<script id="editor" type="text/plain"
										style="width: 100%; height: 200px;"></script>
									<a <c:if test="${not empty user}">id="submit-btn"</c:if>
												<c:if test="${empty user}">onclick="toastr['error']('请先登录！')"</c:if>
												class="btn btn-success"
												style="float: right; margin-top: 10px; margin-bottom: 10px;">发帖</a>

								</div>
							</div>
						</section>
					</section>


				</section>
			</section>
		</section>
	</section>


	<div class="modal fade" id="modal-container-login" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>

				<div class="modal-body">

					<p>
						<label>用户名</label> <input id="username" type="text" class="form-control">
					</p>
					<p>
						<label>密码</label><input id="pwd" type="password" class="form-control">
					</p>

				</div>
				<div class="modal-footer">
					<a type="button" class="btn  btn-warning" href="register">注册</a>
					<button type="button" class="btn btn-primary login-btn">登录</button>
				</div>

			</div>

		</div>

	</div>
	<script>
	$.ajax({
		type : "POST",
		url : "hehetieba/tiebaAction_listFavoriteTiebas",
		data : {
			userId : '${user.id}'
		},
		dataType : "json",
		success : function(data) {
			var favStr = "";
			var favStr1 = "";
			for (var i = 0; i < data.FavoriteTiebas.length; i++) {
				favStr1 += "<li><a class='auto' href='tie?tiebaId="
						+ data.FavoriteTiebas[i].id + "'>"
						+ data.FavoriteTiebas[i].tiebaName + "吧</a></li>"
			}
			$(".myfa").html(favStr1);
			// <li><a class='auto'></a></li>

		}

	});
	UE.getEditor('editor');
	function reply(e){
			if(e.hasClass("on")){
				e.removeClass("on");
				e.next().remove();
					e.html("回复")
				}
			else{
		e.html("收起回复")
		e.parent().append("<div><input type='text' class='form-control xhh'><button class='btn btn-default' onclick='replyInTie($(this));'>回复</button></div>");
		e.addClass("on");
			}		
	}	
	function replyInTie(e){
	
		if('${user.id}'==""){
toastr['error']("请先登录！");

			}else{
		tieId=e.parent().parent().parent().attr("id")
		body=e.prev().val();
 		$.ajax({
 				type:"post",
 				url:"replyAction_reply",
				data:{
 					tieTitleId:'<%=request.getParameter("tieTitleId")%>',
 					tieId:tieId,
 					sendUserId:'${user.id}',
 					beSendUserId:$("#louzhu").val(),
 					body:body
					},
				dataType:"json",
				success:function(data){toastr['success']("回复成功！")}

 			})
		}
	}


		$(document).ready(function(e) {

			   function callBackPagination() {
				   $.ajax({
						type:"post",
						url: "hehetieba/tieAction_listInTiePage?index=1&size=10&tieTitleId="
							+
							<%=request.getParameter("tieTitleId")%>,
							dataType : "json",
							success : function(data) {
								$("#totalRecord").val(data.pager.totalRecord);		
								$("#louzhu").val(data.pager.datas[0][1].id);
								$(".title").html(data.title)
							    createTable(1, 10,data.pager.totalRecord);
								},
							error : function() {
								toastr['error']("未知错误");
							}
				 }); 
        var totalCount = parseInt($("#totalRecord").val()), showCount =10,
                limit =10;

        $('#callBackPager').extendPagination({
            totalCount: totalCount,
            showCount: showCount,
            limit: limit,
            callback: function (curr, limit, totalCount) {
                createTable(curr, limit, totalCount);
            }
        });
    }
    function createTable(currPage, limit, total) {
    	 var html = '', showNum = limit;
	        if (total - (currPage * limit) < 0) showNum = total - ((currPage - 1) * limit);
			$.ajax({
				type:"post",
				url:"hehetieba/tieAction_listInTiePage",
				data:{
					tieTitleId:'<%=request.getParameter("tieTitleId")%>',
					index:currPage,
					size:limit
					},
					dataType : "json",
					success : function(data) {
						var str="";
						  for (var i = 0; i <showNum; i++) {		
							  str= "<div id='"+data.pager.datas[i][0].id+"' class='post-item'><div class='caption wrapper-lg'>"
									+ data.pager.datas[i][0].body
									+ "<i class='fa fa-user icon-muted'></i><a href='#' class='m-r-sm'>"
									+ data.pager.datas[i][0].sendUser.nickname
									+ "</a><i class='fa fa-clock-o icon-muted'></i>"
									+ data.pager.datas[i][0].createdDate
									+ "<button class='btn-success btn reply-btn' onClick='reply($(this));'>回复</button></div></div></div>"
									  $(".blog-post").append(str);
									  
									var qq=data.pager.datas[i][0].id;	
														 
				 					$.ajax({
				 					type:"post",
				 					async:false,  
									url:"replyAction_listInTiePage",
									data:{
										index:1,
										size:999,
										tieId:data.pager.datas[i][0].id
										},
										dataType:"json",
									success:function(result){
										var replyStr="";
										  for (var i = 0; i <result.pager2.totalRecord; i++) {
											  replyStr +="<div class='reply-list'>" +result.pager2.datas[i][0].sendUser.nickname+":回复"+result.pager2.datas[i][0].body+"</div><br>";
											
												  }
	
										$("#"+qq).append(replyStr);	
									

										}
								 });
				 					
					        }
						
			
					
					},
					error : function() {toastr['error']("拉取数据失败！");}	
				});     
    }
	callBackPagination(); 			
			$("#submit-btn").click(function(){
				var main_html=UE.getEditor('editor').getContent();	
				var tieTitleId='<%=request.getParameter("tieTitleId")%>';
				var	userId='${user.id}';
					$.ajax({
						type:'post',
						url:'hehetieba/tieAction_post',
						data:{
							sendUserId:userId,
							tieTitleId:tieTitleId,
							beSendUserId:$("#louzhu").val(),
							body:main_html
							},
					success:function(){
						toastr['success']("回复成功")
						setTimeout(function() {
							window.top.location.reload()
						}, 500);
						}

						});
			});
			$("#logout-btn").click(function() {
				$.ajax({
					type : "POST",
					url : "hehetieba/userAction_logout"
				})
					window.top.location.reload()
			
			});
			$(".login-btn").click(function() {
				$.ajax({
					type : "post",
					url : "hehetieba/userAction_login",
					data : {
						username : $("#username").val(),
						pwd : $("#pwd").val()
					},
					dataType : "json",
					success : function(data) {
						if (data.flag == true) {
							toastr['success']("登录成功");
							setTimeout(function() {
								window.top.location.reload()
							}, 500);
						} else {
							toastr['error']("账号或密码错误");
						}
					},
					error : function() {
						toastr['error']("未知错误");
					}
				})
			});

			$.ajax({
				type:"POST",
				url:"userTiebaAction_checkBaZhu",
				data:{userId:'${user.id}',
					tiebaId:'<%=request.getParameter("tiebaId")%>'
					},
				dataType:"json",
				success:function(data){
					if(data.flag=true){
						$(".tie-manager").css("display","block");
						}

					}
				});
			$(".tie-manager").mouseover(function(){
				$(".tie-manager").children().css("display","block");
				})

					$(".tie-manager").mouseleave(function(){
				$(".tie-manager").children().css("display","none");
				})			
		});
		function deltie(){
		$.ajax({
			type:"post",
			url:"tieTitleAction_delete?tieTitleId="+<%=request.getParameter("tieTitleId")%>,
			success:function(){
              toastr['success']("删除成功");
				}
			});
			}
		function jiajing(){

			$.ajax({
				type:"post",
				url:"tieTitleAction_jiajing?id="+<%=request.getParameter("tieTitleId")%>,
				success:function(){
	              toastr['success']("加精成功");
					}
				});

			}
		function cancelJiajing(){

			$.ajax({
				type:"post",
				url:"tieTitleAction_cancelJiajing?id="+<%=request.getParameter("tieTitleId")%>,
				success:function(){
	              toastr['success']("取消加精成功");
					}
				});

			}
		function settop(){

			$.ajax({
				type:"post",
				url:"tieTitleAction_setTop?id="+<%=request.getParameter("tieTitleId")%>,
				success:function(){
	              toastr['success']("置顶成功");
					}
				});

			}
		function cancelSettop(){

			$.ajax({
				type:"post",
				url:"tieTitleAction_cancelSetTop?id="+<%=request.getParameter("tieTitleId")%>,
				success:function(){
	              toastr['success']("取消置顶成功");
					}
				});

			}
		toastr.options = {
				"closeButton" : true,
				"debug" : false,
				"positionClass" : "toast-top-full-width",
				"onclick" : null,
				"showDuration" : "30",
				"hideDuration" : "5000",
				"timeOut" : "5000",
				"extendedTimeOut" : "1000",
				"showEasing" : "swing",
				"hideEasing" : "swing",
				"showMethod" : "show",
				"hideMethod" : "hide"
			}
	</script>
</body>
</html>