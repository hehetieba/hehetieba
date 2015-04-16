<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/login.min.css" type='text/css' />
<title>后台登录</title>
</head>
<body class="login login-action-register " style="background: #212421 !important;">
<div id="login">
		<h1>
			<a id="logo" href="book.do?method=index" title="">HeHe</a>
		</h1>
	<form action="bs.login?method=login" method="post" style="position: relative;">
			用户名
			<input class="input" type="text" name="username" />
			
			用户密码：
			<input class="input" type="password" name="password" />
			<br/>
			<input type="submit" value="管理员登录" class="reg_btn " style="position:absolute; bottom:20px;left:50%;margin-left: -50px;" />
		
			
	
	</form>
	</div>
</body>
</html>