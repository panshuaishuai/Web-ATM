<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ATM-存款</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="atmMain" class="atm-main">
		<form action="DeposiServlet" method="post"
			onsubmit="return validateDeposit();">
			<div class="main-left">
				<ul class="menu">
					<li>
						<button type="button" onclick="returnMain1();">返回</button>
					</li>
				</ul>
			</div>
			<div class="main-content">
				<h3>请输入存款金额：</h3>
				<input id="depositAmount" type="text" name="depositAmount" value=""
					placeholder="存款金额"> <br> <font color="red">${message }</font>
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
			document.getElementById("depositAmount").focus();
		}

		// 验证存款金额有效性
		function validateDeposit() {
			//获取页面中输入的存款金额
			var inputDepositAmount = document.getElementById("depositAmount").value;

			//存款金额不允许为空
			if (inputDepositAmount.trim() == "") {
				alert("请输入存款金额！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}

			//存款金额必须为数字
			if (isNaN(inputDepositAmount)) {
				alert("请输入有效的存款金额！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}

			//存款金额必须为100的整数倍
			if (inputDepositAmount % 100 != 0) {
				alert("存款金额必须为100的整数倍！");

				document.getElementById("depositAmount").value = "";
				document.getElementById("depositAmount").focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>