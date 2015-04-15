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
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/app.js"></script>
<script src="js/jquery.js"></script>
<script src="js/app_002.js"></script>
<script src="js/jquery_002.js"></script>
<script src="js/extendPagination.js"></script>
<script src="ueditor/ueditor.config.js"></script>
<script src="ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="js/toastr.js"></script>
</head>
<body>
	<input id="tiebaId" type="hidden"
		value='<%=request.getParameter("tiebaId")%>'>
	<input id="totalRecord" type="hidden" value=''>
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
										<img class="myhead" src="upload/${user.headImg}" alt='...'>
									</c:if> <c:if test="${empty user.headImg}">
										<img class="myhead" src='images/unknow.png' alt='...'>
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
					<section class="hbox stretch">
						<section>
							<section class="vbox">
								<section style="padding: 0; overflow: auto;">
									<div style="background-color: #00a2ea;">
										<img src="images/bg.jpg" style="width: 100%;"><img
											class="tieba-headImg" src="images/barhead.jpg"
											style="width: 14%; margin-left: 3%; margin-top: -8%;">
										<p
											style="margin-left: 20%; margin-top: -6%; color: #000; position: relative;">
											<span class="bar-title"></span> <span
												class="blue-btn-wrapper"><button type="button"
													class="btn btn-default" id="gz-btn">关注</button>
												<button type="button" class="btn btn-primary" id="qxgz-btn">已关注</button></span>
												
										</p>
										<span class="fallow-wrapper">关注：<span
											class="tieba-member" style="color: #FF773C;"></span></span> <span
											class="post-wrapper">帖子：<span class="tieba-count"
											style="color: #FF773C;"></span></span>

											<a  class="btn btn-success" id="xgtb-btn" href="#modal-container-xgtb" role="button" data-toggle="modal" style="margin-top: -17px;display: none;margin-left: 10px;">修改吧信息</a>
										<p class="tieba-intruduction"
											style="margin-left: 20%; margin-bottom: 0; padding-bottom: 10px; color: #fff;"></p>
											
									</div>

									<div class="tie-main">
										<ul id="tieresult">

										</ul>

										<!--Todo -->

										<div id="callBackPager"></div>
										<div style="padding: 0 20px;">
											<p style="font-size: 20px;">发表新帖</p>
											<input type="text" id="tie-title"
												style="margin: 10px 0; width: 250px;">
											<script id="editor" type="text/plain"
												style="width: 100%; height: 200px;"></script>
											<a <c:if test="${not empty user}">id="submit-btn"</c:if>
												<c:if test="${empty user}">onclick="toastr['error']('请先登录！')"</c:if>
												class="btn btn-success"
												style="float: right; margin-top: 10px; margin-bottom: 10px;">发帖</a>
										</div>
									</div>
									<aside class="hidden-xs "
										style="float: right; margin-top: -110px; padding: 20px; width: 30%; background: #fff; height: 110px;">
										<c:if test="${empty user}">
											<p>登录后关注该吧吧！</p>
										</c:if>
										<c:if test="${not empty user}">
											<p>我关注的吧：</p>
										</c:if>

										<div class="myfavourite"></div>
									</aside>

								</section>
							</section>
						</section>

					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
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
						<label>用户名</label> <input id="username" type="text"
							class="form-control">
					</p>
					<p>
						<label>密码</label><input id="pwd" type="password"
							class="form-control">
					</p>

				</div>
				<div class="modal-footer">
					<a type="button" class="btn  btn-warning " href="register">注册</a>
					<button type="button" class="btn btn-primary login-btn">登录</button>
				</div>

			</div>

		</div>

	</div>


		<div class="modal fade" id="modal-container-xgtb" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								修改贴吧信息
							</h4>
						</div>
					
						<div class="modal-body">
          			<form action="tiebaAction_changeMessage" method="post" enctype="multipart/form-data">
          			<p>贴吧背景</p>
          			<input value='<%=request.getParameter("tiebaId")%>' name="tiebaId" >
          			<input type="file" name="files">
          			<p>贴吧头像</p>
          			<input type="file"  name="files">
          			<p>贴吧简介</p>
          			<input type="text" class="form-control intro" name="introduction" >
          		<input type="submit" value="ssss">
          		</form>
                           
						</div>
						<div class="modal-footer">
							 <a type="button" class="btn  btn-warning xgxx-btn" >修改</a> <button type="button" class="btn btn-primary" data-dismiss="modal">返回</button>
						</div>
					
					</div>
					
				</div>
				
			</div>
	<script>
		$("#qxgz-btn").click(function() {

			$.ajax({
				type : "post",
				url : "userTiebaAction_cancelFocus",
				data : {
					userId : '${user.id}',
					tiebaId :
	<%=request.getParameter("tiebaId")%>
		},
				dataType : "json",
				success : function(data) {
					window.top.location.reload();
				}
			})

		});
		$("#gz-btn").click(function() {

			$.ajax({
				type : "post",
				url : "userTiebaAction_focus",
				data : {
					userId : '${user.id}',
					tiebaId :
	<%=request.getParameter("tiebaId")%>
		},
				dataType : "json",
				success : function(data) {
					window.top.location.reload();
				}
			})
		});

		$.ajax({
			type : "post",
			url : "userTiebaAction_checkFocus",
			data : {
				userId : '${user.id}',
				tiebaId :
	<%=request.getParameter("tiebaId")%>
		},
			dataType : "json",
			success : function(data) {
				if (data.flag == true) {
					$("#qxgz-btn").css("display", "block");

				} else {
					$("#gz-btn").css("display", "block");
				}

			}

		})
		$
				.ajax({
					type : "post",
					url : "hehetieba/tiebaAction_getTiebaById?tiebaId="
							+
	<%=request.getParameter("tiebaId")%>
		,
					dataType : "json",
					success : function(data) {
						$(".bar-title").html(data.tieba.tiebaName + "吧");
						if (data.tieba.headImg == null) {
							data.tieba.headImg = "unknow.png"
						}
						$(".tieba-headImg").attr("src",
								"images/" + data.tieba.headImg);
						$(".tieba-intruduction").html(data.tieba.intruduction);
						$(".tieba-member").html(data.tieba.memberCount);
						$(".tieba-count").html(data.tieba.tieCount);
					},
					error : function() {
						toastr['error']("未知错误");
					}
				})

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
					favStr += "<a href='tie?tiebaId="
							+ data.FavoriteTiebas[i].id + "'>"
							+ data.FavoriteTiebas[i].tiebaName + "吧</a>"
					favStr1 += "<li><a class='auto' href='tie?tiebaId="
							+ data.FavoriteTiebas[i].id + "'>"
							+ data.FavoriteTiebas[i].tiebaName + "吧</a></li>"
				}
				$(".myfavourite").html(favStr);
				$(".myfa").html(favStr1);
				// <li><a class='auto'></a></li>

			}

		});
		function location_tie(e) {
			window.location = "tiezi?tiebaId="
					+
	<%=request.getParameter("tiebaId")%>
		+ "&tieTitleId=" + e
		}

		$.ajax({
			type:"POST",
			url:"userTiebaAction_checkBaZhu",
			data:{userId:'${user.id}',
				tiebaId:'<%=request.getParameter("tiebaId")%>'
				},
			dataType:"json",
			success:function(data){
				if(data.flag=true){
				$("#xgtb-btn").css("display","inline-block");
				$("#qxgz-btn").css("display","none");
					}

				}
			});
		$(document)
				.ready(
						function(e) {
							function callBackPagination() {

								$
										.ajax({
											type : "post",
											url : "hehetieba/tieTitleAction_listInTiebaPage",
											data : {
												tiebaId : $("#tiebaId").val(),
												index : 1,
												size : 1
											},
											dataType : "json",
											success : function(data) {
												$("#totalRecord").val(
														data.pager.totalRecord);
												createTable(1, 10,
														data.pager.totalRecord);
											},
											error : function() {
												toastr['error']("未知错误");
											}
										});
								var totalCount = parseInt($("#totalRecord")
										.val()), showCount = 10, limit = 10;

								$('#callBackPager').extendPagination(
										{
											totalCount : totalCount,
											showCount : showCount,
											limit : limit,
											callback : function(curr, limit,
													totalCount) {
												createTable(curr, limit,
														totalCount);
											}
										});
							}
							function createTable(currPage, limit, total) {
								var html = '', showNum = limit;
								if (total - (currPage * limit) < 0)
									showNum = total - ((currPage - 1) * limit);
								$
										.ajax({
											type : "post",
											url : "hehetieba/tieTitleAction_listInTiebaPage",
											data : {
												tiebaId : $("#tiebaId").val(),
												index : currPage,
												size : limit
											},
											dataType : "json",
											success : function(data) {

												for (var i = 0; i < showNum; i++) {
													if (data.pager.datas[i].jiajing == 1) {
														var jiajing = "jiajing";
														var jing = "<span style='padding:0 5px; background:#AE1D2C;border-radius:5px; color:#fff;'>精</span>"
													} else {
														var jiajing = "";
														var jing = ""
													}
													if (data.pager.datas[i].top == 1) {
														var top = "<span style='padding:0 5px; background:#F6C100;border-radius:5px; color:#fff;'>置顶</span>"
													} else {
														var top = ""
													}
													if (data.pager.datas[i].lastPostTime == null) {
														data.pager.datas[i].lastPostTime = ''
													}
													html += "<li onClick='location_tie("
															+ data.pager.datas[i].id
															+ ")'><div class='tie-wrapper'><span class='rank-num btn btn-warning'>"
															+ data.pager.datas[i].replyCount
															+ "</span></div><div class='tie-content'><p>"
															+ jing
															+ top
															+ "<a href='#' class="+jiajing+">"
															+ data.pager.datas[i].title
															+ "</a></p><div style='width: 150px; float: right; margin-top: -30px;'><i class='icon-user icon-author'>&nbsp;"
															+ data.pager.datas[i].user.nickname
															+ "</i><i class='icon-comment icon-last-author'><span>&nbsp;"
															+ data.pager.datas[i].lastPostUserName
															+ "</span><span>"
															+ data.pager.datas[i].lastPostTime
																	.substring(
																			11,
																			16)
															+ "</span></i></div><p><span class='tie-text'></span></p></div></li>";
												}
												$('#tieresult').html(html);
											},
											error : function() {
												toastr['error']("拉取数据失败！");
											}
										});
							}
							callBackPagination();

							$("#logout-btn").click(function() {
								$.ajax({
									type : "POST",
									url : "hehetieba/userAction_logout"
								})
								setTimeout(function() {
									window.top.location.reload()
								}, 500);
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
											window.top.location.reload();
										} else {
											toastr['error']("账号或密码错误");
										}
									},
									error : function() {
										toastr['error']("未知错误");
									}
								})
							});

						});
		UE.getEditor('editor');

		$("#submit-btn").click(function() {
			var main_html = UE.getEditor('editor').getContent();
			$.ajax({
				type : 'post',
				url : 'hehetieba/tieTitleAction_faTie',
				data : {
					userId : '${user.id}',
					tiebaId : $("#tiebaId").val(),
					title : $("#tie-title").val(),
					body : main_html
				},
				success : function() {
					toastr['success']("发帖成功");
					setTimeout(function() {
						window.top.location.reload()
					}, 500);
				}
			});
		});
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