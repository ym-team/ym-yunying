<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>注册</title>
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<%@include file="taglibs.jsp"%>
</head>
<body>
	<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
		<form action="${pathWeb }/toNext.do" method="post" data-ajax="false" id="formSub">
			<input type="hidden" name="u" value="${u}" />
			<div class="dl_con">
				<h2><img src="${configjscss }/images/dl-logo.png"></h2>
				<ul>
					<li>
						<i><img src="${configjscss }/images/zc-ico2.png"></i>
						<span><input id="userPhone" name="userPhone" type="text" placeholder="手机号"></span>
					</li>
					<li>
						<i><img src="${configjscss }/images/zc-ico3.png"></i>
						<span><input style="width: 50%; height: 2.5rem; color: #666 !important;background:white !important;"
							class="hqyzm" type="text" placeholder="请输入图形验证码" name="captcha"
							id="captcha" maxlength="4"><img
							src="${path }/captcha.do" id="captchaImg"
							style="float: right; width: 3.5rem; height: 2rem; margin-top: 0.7rem; margin-right: 0.5rem;"
							onclick="this.src='${path}/captcha.do?d='+new Date()*1"
							title="验证码" /></span>
					</li>
					<li >
						<i><img src="${configjscss }/images/zc-ico3.png"></i>
						<span><input name="smsCode" id="smsCode" style="width: 50%;" type="number" placeholder="验证码"><a
							id="sendCode" class="hqyzm" href="javascript:void(0)"
							onclick="sendMsg()">获取验证码</a></span>
					</li>
				</ul>
				<div class="btn">
					<a rel="external" href="javascript:void(0)" onclick="next()" class="com_btn">下一步</a>
				</div>
				<div class="btn">
					<a rel="external" href="javascript:void(0)" onclick="history.go(-1)" class="com_btn">已有账号</a>
				</div>
				<div class="forget">
					<p>
						我已阅读并同意<a rel="external" href="${pathWeb }/getProtocol.do">《网站注册协议及隐私条款》</a>
					</p>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		
		var message = '${message}';
		if (message) {
			alert(message);
		}
		
	});

	function checkUserPhone() {
		var telNo = $.trim($("#userPhone").val());
		var phonePattern = /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^(([0\+]\d{2,3})?(0\d{2,3}))(\d{7,8})((\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
		if (!telNo) {
			alert("请先输入您的手机号码");
			return false;
		} else if (!phonePattern.test(telNo)) {
			alert("手机号格式不对");
			return false;
		} else {
			return true;
		}
	}

	//获取短信验证码
	var wait = 60;
	function sendMsg() {
		if (captchaValidate()) {
			if (wait != 60) {
				return;
			}
			var telNo = $.trim($("#userPhone").val());
			var captcha = $('#captcha').val();
			if (checkUserPhone()) {
				var data = {
					"tel" : telNo,
					"captcha" : captcha
				};
				openAjax("${pathWeb }/sendSms.do", data, sendSmsCallBack);
			}
		}
	}

	function sendSmsCallBack(data) {
		if ($_SUCCESS_CODE == data.code) {
			time();
		} else if (data.code == '899') {
			time();
		} else {
			alert(data.msg);
			$("#captcha").val("");
			$("#captchaImg").click();
		}
	}

	function sendAgain() {
		alert("请重新输入图形验证码");
		$("#captchaImg").click();
		$("#captcha").val("");
		$('#sendCode').attr("onclick", "sendMsg()");
	}

	//图形验证码
	function captchaValidate() {
		var captcha = $('#captcha').val();
		if (captcha == undefined || captcha == '') {
			alert("请输入图形验证码");
			return false;
		}
		return true;
	}

	function time() {
		if (wait == 0) {
			$("#sendCode").html("获取验证码");
			$("#sendCode").css("background", "#54acd9");
			$('#sendCode').attr("onclick", "sendAgain()");
			wait = 60;
		} else {
			$("#sendCode").html(wait + "秒后重新发送");
			$("#sendCode").removeAttr('onclick');
			$("#sendCode").css("background", "grey");
			wait--;
			setTimeout(function() {
				time();
			}, 1000);
		}
	}

	function checkUserAccount() {
		var userAccount = $("#userAccount").val();
		if (userAccount == undefined || userAccount == '') {
			alert("请输入登录名");
			return false;
		} else {
			return true;
		}
	}

	function checkSmsCode() {
		var smsCode = $("#smsCode").val();
		if (smsCode == undefined || smsCode == '') {
			alert("请输入验证码");
			return false;
		} else {
			return true;
		}
	}

	function checkCaptcha() {
		var captcha = $("#captcha").val();
		if (captcha == undefined || captcha == '') {
			alert("请输入图形验证码");
			return false;
		} else {
			return true;
		}
	}

	function next() {
		if (checkUserPhone() && checkSmsCode()
				&& checkCaptcha()) {
			$("#formSub").submit();
		}
	}

	
</script>
</html>