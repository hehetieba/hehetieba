<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%String path = request.getContextPath();%>
<!DOCTYPE html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">  
  <meta charset="utf-8">
	<title>呵呵贴吧</title>
	<link rel="stylesheet" href="css/font-awesome.css" type="text/css">
	<script type="text/javascript" charset="utf-8" src="<%=path%>/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" charset="utf-8">
		$(window).load(function(){
			var spotlight = {
				 // the opacity of the "transparent" images - change it if you like
				opacity : 0.2,

				/*the vars bellow are for width and height of the images so we can make 
				the &lt;li&gt; same size */
				imgWidth : $('.spotlightWrapper ul li').find('img').width(), 
				imgHeight : $('.spotlightWrapper ul li').find('img').height() 
				
			};
			
			//set the width and height of the list items same as the images
			$('.spotlightWrapper ul li').css({ 'width' : spotlight.imgWidth, 'height' : spotlight.imgHeight +40});
			
			//when mouse over the list item...
			$('.spotlightWrapper ul li').hover(function(){
				
				//...find the image inside of it and add active class to it and change opacity to 1 (no transparency)
				$(this).find('img').addClass('active').css({ 'opacity' : 1});
				$(this).find('p').css({ 'opacity' : 1});
				
				
				//get the other list items and change the opacity of the images inside it to the one we have set in the spotlight array 
				$(this).siblings('li').find('img').css({'opacity' : spotlight.opacity}) ;
				$(this).siblings('li').find('p').css({'opacity' : spotlight.opacity}) ;
				//when mouse leave...
			}, function(){
				
				//... find the image inside of the list item we just left and remove the active class
				$(this).find('img').removeClass('active');
				
			});
			
			//when mouse leaves the unordered list...
			$('.spotlightWrapper ul').bind('mouseleave',function(){
				//find the images and change the opacity to 1 (fully visible)
				$(this).find('img').css('opacity', 1);
			});
			
		});
	</script>
	<style type="text/css" media="screen">
		body { background:black; color:white; font-family: 'georgia' } /* not important */
        img{padding-bottom:40px;}
		.spotlightWrapper ul { 
			list-style-type: none; /* remove the default style for list items (the circles) */ 
			margin:0px; /* remove default margin */
			padding:0px; /* remove default padding */
		}
		.spotlightWrapper ul li { 
			float:left; /* important: left float */
			position:relative; /* so we can use top and left positioning */
			background-color:#fff;
		}
		.spotlightWrapper ul li a img { 
			width:200px; /* you don't need this, i just rescaled the images they are bigger then i want them to be ' */
			position:relative; /* so we can use top and left positioning */
			border:none; /* remove the default blue border */
		}
		.spotlightWrapper ul li a img.active {
			border:4px solid white; /* choose whatever you like */
			z-index:1; /* show it on top of the other images (they have z-index 0) */
			left: -4px; /* same as border width but negative */
			top: -4px; /* same as border width but negative */
		}
		.clear { clear:both; } /* to clear the float after the last item */
	</style>
</head>
<body>
	<!-- start spotlightWrapper div -->
<div class='spotlightWrapper'>
		<!-- start unordered list -->
		<ul>
			<li><a href='#'><img src='images/1.jpg' /> <p style="position: absolute; top: 160px;width: 180px;padding: 0px 10px;"><span style="float: left; width: 100px;">贴吧名字</span><i class="icon-user" style="float:right; right: 0;">999</i></p></a></li>
			<li><a href='#'><img src='images/2.jpg' /></a></li>
			<li><a href='#'><img src='images/3.png' /></a></li>
			<li><a href='#'><img src='images/4.jpg' /></a></li>
			<li><a href='#'><img src='images/5.jpg' /></a></li>
			<li><a href='#'><img src='images/6.png' /></a></li>
			<li><a href='#'><img src='images/7.jpg' /></a></li>
			<li><a href='#'><img src='images/9.PNG' /></a></li>
			<li><a href='#'><img src='images/10.jpg' /></a></li>
			<li><a href='#'><img src='images/11.png' /></a></li>
			<li><a href='#'><img src='images/12.png' /></a></li>
			<li><a href='#'><img src='images/13.jpg' /></a></li>
			<li><a href='#'><img src='images/14.png' /></a></li>
			<li><a href='#'><img src='images/15.jpg' /></a></li>
			<li><a href='#'><img src='images/16.jpg' /></a></li>
			<div class='clear'></div>
		</ul>
		<!-- end unordered list -->
	</div>
	<!-- end spolightWrapper div -->
	<script> $.ajax({
			type:"post",
			url:"hehetieba/tiebaAction_listInIndex",
			dataType:"json",
			data:{
				index:'1',
				size:'999'
				},
			success:function(data){
					if(data.pager.totalRecord==0)
						alert("一个贴吧也没有！");
					else if(data.pager.totalRecord>0){
					for(i=0;i<data.pager.totalRecord;i++){
							alert(data.pager.datas[i].tiebaName);

						}
						}
				}


		})</script>
</body>
</html>

