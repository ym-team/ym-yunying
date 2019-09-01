<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <%@include file="taglibs.jsp" %>
</head>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <form name="form1" id="form1" action="${pathWeb}/register.do" data-ajax="false" method="post">
        <input type="hidden" name="userAccount" value="${userPhone }"/>
        <input type="hidden" name="userPhone" value="${userPhone }"/>
        <input type="hidden" name="publickey" id="publickey" value="${publickey}"/>
        <div class="dl_con">
            <h2>
                <img src="${configjscss }/images/dl-logo.png">
            </h2>
            <ul>
                <li>
                    <i><img src="${configjscss }/images/dl-ico.png"></i>
                    <span><input id="userPassword" name="userPassword" type="password" placeholder="设置密码"></span>
                </li>
                <li>
                    <i><img src="${configjscss }/images/dl-ico.png"></i>
                    <span><input id="passwordr" name="passwordr" type="password" placeholder="确认密码"></span>
                </li>
                <li style="border: none;">
                    <i><img src="${configjscss }/images/yqm.png"></i>
                    <span><input id="inviteUserid" name="inviteUserid" value="${inviteUserid}" type="text" placeholder="邀请码（必填项）"></span>
                </li>
            </ul>
            <div class="btn">
                <a href="javascript:register()" class="com_btn">注&nbsp;册</a>
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
    });

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

    function checkInviteUserid() {
        if ($("#inviteUserid").val() == "") {
            alert("推荐码不能为空");
            return false;
        } else {
            return true;
        }
    }


    function register() {
        if (checkPassword() && checkPwdRepeat() && checkInviteUserid()) {
            form1.userPassword.value = encryptByDES(form1.userPassword.value, form1.publickey.value);
            $("#form1").submit();
        }
    }
</script>
</html>