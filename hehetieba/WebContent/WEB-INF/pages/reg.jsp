<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link rel="icon" type="image/x-icon" href="<%=path%>/img/favicon.ico"/>
<link rel="stylesheet" href="<%=path%>/css/login.min.css" type='text/css' />
	<link href="css/toastr.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"  src="<%=path%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/toastr.js"></script>
<script type="text/javascript">
	function checkReg() {
		if ($("#username").val() != '' && $("#nickname").val() != ''
				&& $("#password1").val() != '' && $("#password2").val() != ''
				&& $("#password1").val() == $("#password2").val()
				&& $("#password1").val().length > 5) {
			$(".reg_btn").css("display", "block");

		}
		if (!($("#username").val() != '' && $("#nickname").val() != ''
				&& $("#password1").val() != '' && $("#password2").val() != ''
				&& $("#password1").val() == $("#password2").val() && $(
				"#password1").val().length > 5)) {
			$(".reg_btn").css("display", "none");
		}

	}
	function checkUsername() {
		if ($("#username").val() != '') {
			$.ajax({
				type:"POST",
				url:"hehetieba/userAction_checkUsername",
				data:{
					username:$("#username").val()
					},
					dataType : "json",
				success:function(data){ 
					if(data.flag){
					toastr['error']("该用户已存在！");
					}else{
						$(".message").css("display", "none");
						}
					}
				});
			checkReg();
		}
		if ($("#username").val() == '') {
			$(".message").css("display", "block");
			toastr['error']("请输入正确的用户名（英文数字下划线）。");
		}
	}
	function checkNickname() {
		if ($("#nickname").val() !='') {
			$.ajax({
				type:"POST",
				url:"hehetieba/userAction_CheckNickname",
				data:{
					nickname:$("#nickname").val()
					},
					dataType : "json",
					success:function(data){ 
					if(data.flag){
					toastr['error']("该昵称已存在！");
					}else{
						$(".message").css("display", "none");
						}
					}
				});
			checkReg();
		}
		if ($("#nickname").val()=='') {		
			$(".message").css("display", "block");
			toastr['error']("请输入用户昵称！");
		}
	}
	function checkPas() {
		
		($("#password1").val().length > 5);
		{
			checkReg();
		}
		if ($("#password1").val().length<6) {
			$(".message").css("display", "block");
			toastr['error']("密码必须6位以上！");
		}
	}

	function checkPass() {
	
		if ($("#password1").val() == $("#password2").val()
				&& $("#password2").val().length > 5) {
			checkReg();
		}
		if ($("#password1").val() != $("#password2").val()) {
			$(".message").css("display", "block");
			toastr['error']("密码和确认密码不一致！请从新输入！");
		}

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
	
   $(document).ready(function(e) {

    
});
</script>
</head>

`
<body class="login login-action-register  ">
	<div id="login">
		<h1>
			<a id="logo" href="book.do?method=index" title="">HeHe</a>
		</h1>



		<form action="hehetieba/userAction_register" method="post">
			<p>
				<label>用户名<br /> <input type="text" id="username"
					name="username" class="input" onblur="checkUsername();"
					onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"
					onafterpaste="value=value.replace(/[^\w\.\/]/ig,'')" /></label>
			</p>
			<p>
				<label>用户昵称<br /> <input type="text" id="nickname"
					name="nickname" class="input" onblur="checkNickname();"  /></label>
					
			</p>
			<p>
				<label>密码<br /> <input type="password" id="password1"
					name="pwd" class="input" onblur="checkPas();" />
				</label>
			</p>
			<p>
				<label>确认密码<br /> <input type="password" id="password2"
					class="input" onblur="checkPass();" />
				</label>
			</p>
			<br class="clear" />

			<p class="submit">
				<input type="submit" class="reg_btn " value="注册"
					style="display: none;" />
			</p>
		</form>

		<p id="nav">
			<a href="all-tieba">返回主页</a>
		</p>

		<p id="backtoblog">
			<a href="book.do?method=inde" title="不知道自己在哪？">&larr; 回到Hehe</a>
		</p>

	</div>


	<div class="clear"></div>
</body>
</html>
