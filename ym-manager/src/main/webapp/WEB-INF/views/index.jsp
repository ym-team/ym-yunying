<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap-modal/css/bootstrap-modal-bs3patch.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/metronic/assets/global/plugins/bootstrap-modal/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>
    <!-- BEGIN PAGE LEVEL SCRIPTS -->
    <script src="${ctx}/metronic/assets/global/plugins/bootstrap-modal/js/bootstrap-modalmanager.js" type="text/javascript"></script>
    <script src="${ctx}/metronic/assets/global/plugins/bootstrap-modal/js/bootstrap-modal.js" type="text/javascript"></script>
    <script src="${ctx}/metronic/assets/pages/scripts/ui-extended-modals.min.js" type="text/javascript"></script>
    <!-- DataTables CSS -->
    <link href="${ctx}/plugins/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <!-- DataTables Responsive CSS -->
    <link href="${ctx}/plugins/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
    <link href="${ctx}/plugins/showLoading/css/showLoading.css" rel="stylesheet" type="text/css">
    <!-- DataTables JavaScript -->
    <script src="${ctx}/plugins/datatables/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/plugins/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="${ctx}/plugins/datatables-responsive/dataTables.responsive.js"></script>
    <!-- validation JavaScript -->
    <script src="${ctx}/plugins/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="${ctx}/plugins/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <!-- jquery.form JavaScript -->
    <script src="${ctx}/plugins/jquery/jquery.form.js"></script>
    <script src="${ctx}/plugins/showLoading/js/jquery.showLoading.js"></script>
    <script src="${ctx}/js/see-admin-common.js"></script>
    <script src="${ctx}/plugins/jquery/formateDate.js"></script>
    <script>
        var ctx = '${ctx}';
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light bordered">
            <div class="portlet-body">
                <div id="main" style="height:200px;width:100%;margin-top:20px"></div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
