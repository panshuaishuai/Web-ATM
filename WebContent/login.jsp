<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ATM-登录</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="loginContainer" class="login-container">
		<div class="container-left">
			<img src="images/login.jpg">
		</div>
		<div class="container-right">
			<h1>ATM系统登录</h1>
			<form name="loginForm" action="LoginServlet" onsubmit="return login()" method="post">
				<div class="input-group">
					<label>用户名：</label> <input type="text" name="username" class="input" id="username" placeholder="请输入您的用户名！">
				</div>
				<div class="input-group">
					<label class="letter">密&nbsp;&nbsp;&nbsp;码：</label> <input type="password" name="password" class="input" id="passWord" placeholder="请输入您的登录密码！">
				</div>
				<div class="login-control">
					<button type="submit" class="">登录</button>
					<button type="reset" class="">重置</button>
				</div>
				<div id="message">
				<font color = "red">${message }</font> 
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		// 登陆验证函数
		function login() {
			//获取用户输入的用户名
			var username = document.getElementById("username").value;
			//获取用户输入的密码
			var password = document.getElementById("passWord").value;

			//验证用户输入项
			if (username == "") {
				alert("用户名不允许为空！");
				return false;
			} else if (password == "") {
				alert("密码不允许为空！");
				return false;
			}

			return true;
		}
	</script>
</body>
</html>