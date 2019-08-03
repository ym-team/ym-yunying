<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>医美</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGINS -->
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
    <!-- END PAGE LEVEL PLUGINS -->
    <!-- BEGIN THEME GLOBAL STYLES -->
    <link href="${ctx}/metronic/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/css/style-common.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME GLOBAL STYLES -->
    <!-- BEGIN THEME LAYOUT STYLES -->
    <link href="${ctx}/metronic/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color"/>
    <link href="${ctx}/metronic/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME LAYOUT STYLES -->
    <script src="${ctx}/metronic/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${ctx}/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctx}/metronic/assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
    <link href="${ctx}/plugins/sweetalert/sweet-alert.css" rel="stylesheet" type="text/css"/>
    <script src="${ctx}/plugins/sweetalert/sweet-alert.min.js" type="text/javascript"></script>
    <link rel="shortcut icon" href="seework.ico"/>
    <style>
        .page-sidebar #page-sidebar-menu > li > a, .page-sidebar #page-sidebar-menu > li > a:hover,
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li > a {
            color: #dce2e6;
        }

        .page-sidebar #page-sidebar-menu > li > a > i[class*=icon-],
        .page-sidebar #page-sidebar-menu > li > a > i[class^=icon-],
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li > a > i[class*=icon-],
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li > a > i[class^=icon-] {
            color: #dce2e6;
        }

        .page-sidebar #page-sidebar-menu > li.heading > h3,
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li.heading > h3 {
            color: #dce2e6;
        }

        .page-sidebar #page-sidebar-menu .sub-menu > li > a,
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu .sub-menu > li > a {
            color: #dce2e6;
        }

        .page-sidebar #page-sidebar-menu .sub-menu > li > a > i[class*=icon-],
        .page-sidebar #page-sidebar-menu .sub-menu > li > a > i[class^=icon-],
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu .sub-menu > li > a > i[class*=icon-],
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu .sub-menu > li > a > i[class^=icon-] {
            color: #dce2e6;
        }

        table.table-bordered thead th, table.table-bordered thead td, table.table-bordered thead tr {
            background-color: #EEF1F5;
        }

        .page-sidebar #page-sidebar-menu > li.active.open > a,
        .page-sidebar #page-sidebar-menu > li.active > a,
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li.active.open > a,
        .page-sidebar-closed.page-sidebar-fixed .page-sidebar:hover #page-sidebar-menu > li.active > a {
            color: #fff;
        }

        .datetimepicker.datetimepicker-dropdown-bottom-left:after {
            right: 13px;
        }

        .table-break-word td {
            word-break: break-all; /* 支持IE和chrome，FF不支持*/
            word-wrap: break-word; /* 以上三个浏览器均支持 */
        }
    </style>
    <sitemesh:write property='head'/>
</head>

<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white">

<!-- BEGIN HEADER & CONTENT DIVIDER -->
<%@ include file="/WEB-INF/views/layouts/header.jsp" %>
<div class="clearfix"></div>
<!-- END HEADER & CONTENT DIVIDER -->

<!-- BEGIN CONTAINER -->
<div class="page-container">
    <%@ include file="/WEB-INF/views/layouts/left.jsp" %>
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">

        <!-- BEGIN CONTENT BODY -->
        <div class="page-content">

            <!-- BEGIN PAGE BAR -->
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <span>流动问卷</span>
                        <i class="fa fa-circle"></i>
                    </li>
                    <li>
                        <span>Model</span>
                    </li>
                </ul>
            </div>
            <!-- END PAGE BAR -->
            <h2></h2>
            <sitemesh:write property='body'/>
            <!-- END CONTENT BODY -->
        </div>
    </div>
    <!-- END CONTENT -->
</div>
<!-- END CONTAINER -->

<!-- BEGIN FOOTER -->
<%@ include file="/WEB-INF/views/layouts/footer.jsp" %>
<!-- END FOOTER -->

<!--[if lt IE 9]>
<script src="${ctx}/metronic/assets/global/plugins/respond.min.js"></script>
<script src="${ctx}/metronic/assets/global/plugins/excanvas.min.js"></script>
<![endif]-->
<!-- BEGIN CORE PLUGINS -->
<script src="${ctx}/metronic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN THEME GLOBAL SCRIPTS -->
<script src="${ctx}/metronic/assets/global/scripts/app.min.js" type="text/javascript"></script>
<!-- END THEME GLOBAL SCRIPTS -->
<!-- BEGIN THEME LAYOUT SCRIPTS -->
<script src="${ctx}/metronic/assets/layouts/layout/scripts/layout.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/layouts/layout/scripts/demo.min.js" type="text/javascript"></script>
<script src="${ctx}/metronic/assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
<!-- END THEME LAYOUT SCRIPTS -->
</body>
</html>
