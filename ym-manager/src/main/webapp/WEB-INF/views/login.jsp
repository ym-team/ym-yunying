<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>医美</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/pages/css/login.min.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="seework.ico"/>
</head>
<body class=" login">
<div class="logo">
    <h2 style="color:#fff6ec"><span style="font-weight: bold">医美</span></h2>
</div>
<div class="content">
    <form class="login-form" action="${ctx}/login" method="post">
        <h3 class="form-title font-green">登录</h3>
        <c:if test="${userInfo!=null}">
            <div class="alert alert-danger">
                <button class="close" data-close="alert"></button>
                <span> ${userInfo} </span>
            </div>
        </c:if>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">用户名</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" name="userName"/></div>
        <div class="form-group">
            <label class="control-label visible-ie8 visible-ie9">密码</label>
            <input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" name="password"/></div>
        <div class="form-actions">
            <button type="submit" class="btn green uppercase" >登录</button>
            <a href="javascript:forgetPassword();" class="forget-password">忘记密码?</a>
        </div>
    </form>
</div>
<!--[if lt IE 9]>
<script src="${ctx}/metronic/assets/global/plugins/respond.min.js"></script>
<script src="${ctx}/metronic/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/metronic/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/scripts/app.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/pages/scripts/login.min.js" type="text/javascript"></script>
<script type="text/javascript">
    function forgetPassword() {
        alert("请找管理员重置密码");
    }
</script>
</body>
</html>
