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
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/jquery-1.9.1.min.js"></script>
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
	background-color: #fff;
}

.spotlightWrapper ul li a img {
	width: 200px;
	/* you don't need this, i just rescaled the images they are bigger then i want them to be ' */
	position: relative; /* so we can use top and left positioning */
	border: none; /* remove the default blue border */
}

.spotlightWrapper ul li a p {
	position: absolute;
	font-size:12px;
	top: 158px;
	width: 180px;
	padding: 0px 10px;
}

.spotlightWrapper ul li a p span {
	float: left;
	width: 100px;
}

.spotlightWrapper ul li a p i {
	float: right;
	right: 0;
	margin-left:5px;
}

.spotlightWrapper ul li a img.active {
	border: 4px solid white; /* choose whatever you like */
	z-index: 1;
	/* show it on top of the other images (they have z-index 0) */
	left: -4px; /* same as border width but negative */
	top: -4px; /* same as border width but negative */
}

.clear {
	clear: both;
} /* to clear the float after the last item */
</style>
</head>
<body>
	<!-- start spotlightWrapper div -->
	<div class='spotlightWrapper'>
		<!-- start unordered list -->
		<ul>
			<div class='clear '></div>
		</ul>
		<!-- end unordered list -->
	</div>
	<!-- end spolightWrapper div -->
	<script>
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
							alert("一个贴吧也没有！");
						else if (data.pager.totalRecord > 0) {
							for (i = 0; i < data.pager.totalRecord; i++) {
								//	alert(data.pager.datas[i].tiebaName);
								if(data.pager.datas[i].bgImg==null){data.pager.datas[i].bgImg="unknow.png"}
								$(".clear").before(
							"<li><a href='/hehetieba/tie?tiebaId="+data.pager.datas[i].id+"'><img src='images/"+data.pager.datas[i].bgImg+"' /> <p><span>"+data.pager.datas[i].tiebaName+"吧</span><i class='icon-comment'>&nbsp;"+data.pager.datas[i].tieCount+"</i><i class='icon-user'>&nbsp;"+data.pager.datas[i].memberCount+"</i></p></a></li>");

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
								'height' : spotlight.imgHeight +30
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

				})
	</script>
</body>
</html>

