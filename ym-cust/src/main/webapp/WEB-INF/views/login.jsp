<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>登录</title>
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
    <form action="${pathWeb}/login.do" name="loginForm" id="loginForm" method="post">
        <div class="dl_con">
            <h2>
                <img src="${configjscss }/images/dl-logo.png">
            </h2>
            <ul>
                <li>
                    <i><img src="${configjscss }/images/dl-ico3.png"></i>
                    <span><input type="number" placeholder="手机号" name="userAccount" id="userAccount" value=""></span>
                </li>
                <li style="border: none;">
                    <i><img src="${configjscss }/images/dl-ico.png"></i><span>
                    <input type="hidden" name="publickey" id="publickey" value="${publickey}"/>
                    <input type="password" placeholder="登录密码" name="userPassword" id="userPassword" value=""></span>
                </li>
            </ul>
            <div class="btn">
                <a rel="external" href="javascript:void(0)" onclick="login()" class="com_btn">登&nbsp;录</a>
                <a rel="external" href="${pathWeb }/toRegister.do" class="com_btn2">快速注册</a>
                <a rel="external" href="${pathWeb }/toFindPassword.do" class="com_btn3">忘记密码</a>
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

    function login() {
        var userAccount = $("#userAccount").val();
        var userPassword = $("#userPassword").val();
        var publickey = $("#publickey").val();
        if (userAccount == undefined || userAccount == '') {
            alert("登录名不能为空。");
            return false;
        } else if (userPassword == undefined || userPassword == '') {
            alert("密码不能为空。");
            return false;
        } else {
            userPassword = encryptByDES(userPassword, publickey);
            var data = {
                "userAccount": userAccount,
                "userPassword": userPassword
            };
            openAjax("${pathWeb }/login.do", data, loginCallBack);
        }
    }

    var $_SUCCESS_CODE3 = '3';

    function loginCallBack(data) {
        if ($_SUCCESS_CODE == data.code) {
            openPage("${pathWeb }/userIndex.do");
        } else if ($_SUCCESS_CODE3 == data.code) {
            openPage("${pathWeb }/store/storeLogin.do");
        } else {
            alert(data.msg);
        }
    }
</script>

</html>