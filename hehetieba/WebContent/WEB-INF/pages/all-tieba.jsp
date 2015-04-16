<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>呵呵贴吧</title>
<link rel="stylesheet" href="css/font-awesome.css" type="text/css">
	<link href="css/toastr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="js/toastr.js">
		</script>
<script type="text/javascript" charset="utf-8">
	$(window).load(function() {

	});
</script>
<style type="text/css" media="screen">
body {
	background: black;
	color: white;
	font-family: 'georgia'
} /* not important */
img {
	padding-bottom: 30px;
}

.spotlightWrapper ul {
	list-style-type: none;
	/* remove the default style for list items (the circles) */
	margin: 0px; /* remove default margin */
	padding: 0px; /* remove default padding */
}

.spotlightWrapper ul li {
	float: left; /* important: left float */
	position: relative; /* so we can use top and left positioning */
	background-color: #000;
	margin-left: 5px;
}

.spotlightWrapper ul li a img {
	width: 200px;
	/* you don't need this, i just rescaled the images they are bigger then i want them to be ' */
	position: relative; /* so we can use top and left positioning */
	border: none; /* remove the default blue border */
}

.spotlightWrapper ul li a p {
background:#fff;
	position: absolute;
	font-size:12px;
	top: 158px;
	width: 180px;
	padding:0 10px;
	height: 30px;
	line-height: 30px;
	
}

.spotlightWrapper ul li a p span {
	float: left;
	width: 100px;
}

.spotlightWrapper ul li a p i {
	float: right;
	right: 0;
	margin-left:5px;
	margin-top: 10px;
}

.spotlightWrapper ul li a img.active {
	
	/* show it on top of the other images (they have z-index 0) */
	left: -4px; /* same as border width but negative */
	top: -4px; /* same as border width but negative */
	width: 208px;
	height: 208px;
}
.spotlightWrapper img{ width: 200px; height: 200px;} 
.clear {
	clear: both;
} /* to clear the float after the last item */
.search-input{padding:5px 10px; margin-top:35px; width: 200px;}
.search-btn{border: none; padding: 5px; cursor: pointer; }
</style>
</head>
<body>
	<div style="height: 100px;width: 100%;">
	<input  class="search-input" type="text">
	<button class="search-btn">搜吧</button>
	</div>
	<div class='spotlightWrapper'>
		<ul class="result-con">
			<div class='clear'></div>
		</ul>
	</div>

	<script>

	function cj(){

		$.ajax({
			type:"post",
			url:"tiebaApplyAction_saveTiebaApply?tiebaName="+$(".search-input").val(),
			dataType:"json",
			success:function(data){
				toastr['success'](data.msg);
				
				}

			})
}
	$(".search-btn").click(function(){
		$(".result-con").html("<div class='clear'></div>");
		$.ajax({
			type:"post",
			url:"tiebaAction_findByTiebaName",
			data:{
				tiebaName:$(".search-input").val(),
				index:1,
				size:999
				},
				dataType:"json",
				success:function(data){
					if (data.pager.totalRecord == 0)
						{
						toastr['error']("没有搜到贴吧！");
						var sbStr="<li>“"+$(".search-input").val()+"”吧尚未建立。欢迎创建此吧，与今后来到这里的朋友交流讨论。<button onclick='cj()' style='border: none; padding: 5px; cursor: pointer; '>我来创建</button></li>"
						$(".result-con").append(sbStr);
						}
					
					else if (data.pager.totalRecord > 0) {
						for (i = 0; i < data.pager.totalRecord; i++) {
							//	alert(data.pager.datas[i].tiebaName);
							if(data.pager.datas[i].headImg==null||data.pager.datas[i].headImg==""){
								data.pager.datas[i].headImg="images/unknow.png"
									}else{data.pager.datas[i].headImg="upload/"+data.pager.datas[i].headImg}

				
							$(".clear").before(
						"<li><a href='/hehetieba/tie?tiebaId="+data.pager.datas[i].id+"'><img src='"+data.pager.datas[i].headImg+"' /> <p><span>"+data.pager.datas[i].tiebaName+"吧</span><i class='icon-comment'>&nbsp;"+data.pager.datas[i].tieCount+"</i><i class='icon-user'>&nbsp;"+data.pager.datas[i].memberCount+"</i></p></a></li>");

						}
						var spotlight = {
							opacity : 0.2,
							imgWidth : $('.spotlightWrapper ul li').find(
									'img').width(),
							imgHeight : $('.spotlightWrapper ul li').find(
									'img').height()

						};

						$('.spotlightWrapper ul li').css({
							'width' : spotlight.imgWidth,
							'height' : spotlight.imgHeight
						});
						$('.spotlightWrapper ul li').hover(function() {
							$(this).find('img').addClass('active').css({
								'opacity' : 1
							});
							$(this).find('p').css({
								'opacity' : 1
							});
							$(this).siblings('li').find('img').css({
								'opacity' : spotlight.opacity
							});
							$(this).siblings('li').find('p').css({
								'opacity' : spotlight.opacity
							});
						}, function() {
							$(this).find('img').removeClass('active');
						});
						$('.spotlightWrapper ul').bind('mouseleave',
								function() {
									$(this).find('img').css('opacity', 1);
								});
					}

					}
			
		});



		});


	
		$.ajax({
					type : "post",
					url : "hehetieba/tiebaAction_listInIndex",
					dataType : "json",
					data : {
						index : '1',
						size : '999'
					},
					success : function(data) {
						if (data.pager.totalRecord == 0)
							toastr['error']("一个贴吧也没有！");
						else if (data.pager.totalRecord > 0) {
							for (i = 0; i < data.pager.totalRecord; i++) {
								//	alert(data.pager.datas[i].tiebaName);
								if(data.pager.datas[i].headImg==null||data.pager.datas[i].headImg==""){
									data.pager.datas[i].headImg="images/unknow.png"
										}else{data.pager.datas[i].headImg="upload/"+data.pager.datas[i].headImg}

								$(".clear").before(
							"<li><a href='/hehetieba/tie?tiebaId="+data.pager.datas[i].id+"'><img src='"+data.pager.datas[i].headImg+"' /> <p><span>"+data.pager.datas[i].tiebaName+"吧</span><i class='icon-comment'>&nbsp;"+data.pager.datas[i].tieCount+"</i><i class='icon-user'>&nbsp;"+data.pager.datas[i].memberCount+"</i></p></a></li>");

							}
							var spotlight = {
								opacity : 0.2,
								imgWidth : $('.spotlightWrapper ul li').find(
										'img').width(),
								imgHeight : $('.spotlightWrapper ul li').find(
										'img').height()

							};

							$('.spotlightWrapper ul li').css({
								'width' : spotlight.imgWidth,
								'height' : spotlight.imgHeight
							});
							$('.spotlightWrapper ul li').hover(function() {
								$(this).find('img').addClass('active').css({
									'opacity' : 1
								});
								$(this).find('p').css({
									'opacity' : 1
								});
								$(this).siblings('li').find('img').css({
									'opacity' : spotlight.opacity
								});
								$(this).siblings('li').find('p').css({
									'opacity' : spotlight.opacity
								});
							}, function() {
								$(this).find('img').removeClass('active');
							});
							$('.spotlightWrapper ul').bind('mouseleave',
									function() {
										$(this).find('img').css('opacity', 1);
									});
						}
					}

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

