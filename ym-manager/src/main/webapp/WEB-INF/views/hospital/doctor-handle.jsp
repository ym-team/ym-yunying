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
    <link rel="stylesheet" href="${ctx}/plugins/layer_mobile/need/layer.css"/>

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
    <script src="${ctx}/plugins/layer_mobile/layer.js"></script>
    <script>
        var ctx = '${ctx}';
    </script>
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="portlet light bordered">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-settings font-green"></i>
                    <span class="caption-subject font-green sbold uppercase">添加医生</span>
                </div>
                <div class="actions">
                    <div class="btn-group">
                        <a class="btn green" onclick="backModal()"><i class="glyphicon glyphicon-backward"></i>返回</a>
                    </div>
                    <div class="btn-group">
                        <a class="btn green" id="saveBtn"><i class="glyphicon glyphicon-save"></i>保存</a>
                    </div>
                </div>
            </div>
            <div class="portlet-body form">
                <form role="form" id="addForm" action="${ctx}/api/doctor/save" method="post">
                    <div class="form-body">
                        <input id="id" name="id" type="hidden" value="${doctor.id}">
                        <div class="form-group">
                            <label>医生名称：</label>
                            <input id="name" name="name" style="width: 50%" class="form-control" value="${doctor.name}">
                        </div>
                        <div class="form-group">
                            <label>职位：</label>
                            <input id="position" name="position" style="width: 50%" class="form-control" value="${doctor.position}">
                        </div>
                        <div class="form-group">
                            <label>联系电话：</label>
                            <input id="phone" name="phone" style="width: 50%" class="form-control" value="${doctor.phone}">
                        </div>
                        <div class="form-group">
                            <label>所属医院：</label>
                            <input id="hospitalId" name="hospitalId" style="width: 50%" class="form-control" value="${doctor.hospitalId}">
                        </div>
                        <div class="form-group">
                            <label>头像：</label>
                            <input id="headImg" name="headImg" data-max="12" style="width: 50%" class="form-control" value="${doctor.headImg}">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/js/hospital/doctor-handle.js"></script>
</body>
</html>
