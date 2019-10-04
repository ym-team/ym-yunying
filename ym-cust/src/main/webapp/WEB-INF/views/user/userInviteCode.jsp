<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>我的</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="../taglibs.jsp" %>
    <script type="text/javascript" src="${configjscss}/js/jquery.qrcode.min.js"></script>
</head>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <!-- header -->
    <header class="jwytz-header">
        <h3>
            <span onclick="history.go(-1)"></span>我的二维码<em></em>
        </h3>
    </header>
    <div class="hd-nrk" style="background: #fff; padding-bottom: 6rem;">
         <div class="yqtg-dak">
            <span>使用微信扫一扫下面您的专属二维码，或点击右上角设置 发送给朋友或分享到朋友圈，好友点击注册即可邀请：</span>
            <p id="sharePId" style="text-align: center;">
            <img id="shareImg" src=" ${pathWeb}${inviteCodeUrl }">
            </p>
        </div>
        <div class="wxts-n">
            <i>温馨提示：</i><br/>
            1. 使用过程中遇到问题，请联系客服1234567
        </div>
    </div>
    <jsp:include page="/foot.do?footId=4"></jsp:include>
</div>

 
</body>
</html>