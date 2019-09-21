<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>忘记密码</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="taglibs.jsp" %>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <form name="form1" id="form1" action="${pathWeb}/resetPassword.do" data-ajax="false" method="post">
        <input type="hidden" name="publickey" id="publickey" value="${publickey}"/>
        <div class="dl_con">
            <h2>
                <img src="${configjscss }/images/dl-logo.png">
            </h2>
            <ul>
                <li>
                    <i><img src="${configjscss }/images/zc-ico2.png"></i>
                    <span><input id="userPhone" name="userPhone" type="text" placeholder="手机号"></span>
                </li>
                <li>
                    <i><img src="${configjscss }/images/zc-ico3.png"></i>
                    <span>
                        <input style="width: 50%; height: 2.5rem; color: #666 !important;background:none;" class="hqyzm" type="text" placeholder="请输入图形验证码" name="captcha" id="captcha" maxlength="4">
                        <img src="${path }/captcha.do" id="captchaImg" style="float: right; width: 3.5rem; height: 2rem; margin-top: 0.7rem; margin-right: 0.5rem;" onclick="this.src='${path}/captcha.do?d='+new Date()*1" title="验证码"/>
                    </span>
                </li>
                <li>
                    <i><img src="${configjscss }/images/zc-ico3.png"></i>
                    <span>
                        <input name="smsCode" id="smsCode" style="width: 50%;" type="text" placeholder="验证码">
                        <a class="hqyzm" id="sendCode" class="hqyzm" href="javascript:void(0)" onclick="sendMsg()">获取验证码</a>
                    </span>
                </li>
                <li>
                    <i><img src="${configjscss }/images/dl-ico.png"></i>
                    <span><input id="userPassword" name="userPassword" type="password" placeholder="设置密码"></span>
                </li>
                <li style="border: none;">
                    <i><img src="${configjscss }/images/dl-ico.png"></i>
                    <span><input id="passwordr" name="passwordr" type="password" placeholder="确认密码"></span>
                </li>
            </ul>
            <div class="btn">
                <a rel="external" href="javascript:void(0)" onclick="resetPassword()" class="com_btn">确&nbsp;定</a>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        var message = '${message}';
        if (message) {
            alert(message);
        }
        var success = '${success}';
        if (success) {
            setInterval(openPage("${pathWeb}/login.do"), 3000);
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
                    "tel": telNo,
                    "captcha": captcha
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
            setTimeout(function () {
                time();
            }, 1000);
        }
    }

    function checkPassword() {
        var passwordPartten = /^[\s|\S]{6,}$/;///^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,16}$/;
        if ($("#userPassword").val() == "") {
            alert("密码不能为空");
            return false;
        } else if (passwordPartten.test($("#userPassword").val()) == false) {
            alert("请输入6-16位字符");
            return false;
        } else {
            return true;
        }
    }

    function checkPwdRepeat() {
        if ($("#passwordr").val() == "") {
            alert("不能为空");
            return false;
        } else if ($("#userPassword").val() != $("#passwordr").val()) {
            alert("密码不一致，请确认");
            return false;
        } else {
            return true;
        }
    }

    function resetPassword() {
        if (checkUserPhone() && checkPassword() && checkPwdRepeat() && captchaValidate()) {
            form1.userPassword.value = encryptByDES(form1.userPassword.value, form1.publickey.value);
            $("#form1").submit();

            openAjax("${pathWeb }/resetPassword.do", $("#form1"), sendSmsCallBack);

        }
    }
</script>
</html>