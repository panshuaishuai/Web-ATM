<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ATM-修改密码</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="atmMain" class="atm-main">
		<form action="ChangePasswordServlet" method="post"
			onsubmit="return validateChangePassword();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain1();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入原密码：</h3>
				<input id="originalPassword" type="password" name="originalPassword"
					value="" placeholder="原密码...">
				<h3>请输入新密码：</h3>
				<input id="newPassword" type="password" name="newPassword" value=""
					placeholder="新密码...">
				<h3>请再次输入新密码：</h3>
				<input id="newPasswordAgain" type="password" name="newPasswordAgain"
					value="" placeholder="新密码..."> <br> <font color="red">${message }</font>
			</div>
			<div class="main-right">
				<ul class="menu">
					<li>
						<button type="submit">确认</button>
					</li>
				</ul>
			</div>
		</form>
	</div>
	<script src="js/common1.js" type="text/javascript"></script>
	<script type="text/javascript">
		//页面元素加载完成后，执行 window.onload 事件
		window.onload = function() {
			document.getElementById("originalPassword").focus();
		}

		// 验证密码输入有效性
		function validateChangePassword() {
			//获取页面中输入的原密码
			var inputOriginalPassword = document
					.getElementById("originalPassword").value;
			var inputNewPassword = document.getElementById("newPassword").value;
			var inputNewPasswordAgain = document
					.getElementById("newPasswordAgain").value;

			//原密码不允许为空
			if (inputOriginalPassword.trim() == "") {
				alert("请输入原密码！");

				document.getElementById("originalPassword").value = "";
				document.getElementById("originalPassword").focus();
				return false;
			}

			//新密码不允许为空
			if (inputNewPassword.trim() == "") {
				alert("请输入新密码！");

				document.getElementById("newPassword").value = "";
				document.getElementById("newPassword").focus();
				return false;
			}

			//新密码不允许为空
			if (inputNewPasswordAgain.trim() == "") {
				alert("请再次输入新密码！");

				document.getElementById("newPasswordAgain").value = "";
				document.getElementById("newPasswordAgain").focus();
				return false;
			}

			//验证两次输入的新密码是否一致
			if (inputNewPassword.trim() != inputNewPasswordAgain.trim()) {
				alert("再次输入的新密码不一致，请确认后重新输入！");

				return false;
			}

			return true;
		}
	</script>
</body>
</html>