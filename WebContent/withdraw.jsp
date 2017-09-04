<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ATM-取款</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="atmMain" class="atm-main">
		<form action="WithdrawServlet" method="post"
			onsubmit="return validateWithdraw();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入取款金额：</h3>
				<input id="withdrawAmount" type="text" name="withdrawAmount"
					value="" placeholder="取款金额">
			</div>
			<div class="main-right">
				<ul class="menu">
					<li>
						<button type="submit">确认</button>
					</li>
				</ul>
			</div>
			<div>
				<font color="red">${message }</font>
			</div>
		</form>
	</div>
	<script src="js/common.js" type="text/javascript"></script>
	<script type="text/javascript">
		//页面元素加载完成后，执行 window.onload 事件
		window.onload = function() {
			document.getElementById("withdrawAmount").focus();
		}

		// 验证取款金额有效性
		function validateWithdraw() {
			//获取页面中输入的取款金额
			var inputWithdrawAmount = document.getElementById("withdrawAmount").value;

			//取款金额不允许为空
			if (inputWithdrawAmount.trim() == "") {
				alert("请输入取款金额！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须为数字
			if (isNaN(inputWithdrawAmount)) {
				alert("请输入有效的取款金额！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须为100的整数倍
			if (inputWithdrawAmount % 100 != 0) {
				alert("取款金额必须为100的整数倍！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}

			//取款金额必须小于1000元
			if (parseInt(inputWithdrawAmount) > 1000) {
				alert("取款金额必须小于或等于1000元！");

				document.getElementById("withdrawAmount").value = "";
				document.getElementById("withdrawAmount").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>