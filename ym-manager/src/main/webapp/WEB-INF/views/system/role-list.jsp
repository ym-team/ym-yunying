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
    <link href="${ctx}/plugins/zTree_v3/css/metroStyle/metroStyle.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css">
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
    <script src="${ctx}/plugins/jquery/formateDate.js"></script>
    <script src="${ctx}/plugins/zTree_v3/js/jquery.ztree.all.js"></script>
    <script src="${ctx}/plugins/showLoading/js/jquery.showLoading.js"></script>
    <script src="${ctx}/js/see-admin-common.js"></script>
    <script>
        var ctx = '${ctx}';
    </script>
    <style>
        #menuDialog {
            width: 600px;
        }
    </style>
</head>
<body>

<div class="row">
    <div class="col-md-12">
        <div class="portlet light bordered">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-settings font-green"></i>
                    <span class="caption-subject font-green sbold uppercase">角色列表</span>
                </div>
                <div class="actions">
                    <div class="btn-group">
                        <a class="btn green" data-toggle="modal" href="#addModal" onclick="addRoleModal()"><i class="glyphicon glyphicon-plus"></i>添加</a>
                    </div>
                </div>
            </div>
            <div class="portlet-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-user">
                    <thead>
                    <tr>
                        <th>角色名称</th>
                        <th>角色描述</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加角色</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="addForm" action="${ctx}/api/role/save" method="post">
                    <input id="id" name="id" type="hidden">
                    <div class="form-group">
                        <label>角色名称</label>
                        <input id="name" name="name" class="form-control" placeholder="角色名称">
                    </div>
                    <div class="form-group" id="passwordDiv">
                        <label>角色描述</label>
                        <input id="description" name="description" class="form-control" placeholder="角色描述">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
            </div>
        </div>
    </div>

    <div class="modal fade form-horizontal" id="menuDialog" tabindex="-1" role="dialog" aria-hidden="false" style="display: none;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">角色菜单分配 </h4>
            </div>
            <input type="hidden" id="menuModalId" name="menuModalId">
            <input type="hidden" id="roleId" name="roleId">
            <div class="modal-body">
                <div class="col-md-6">
                    <div class="portlet light bordered">
                        <div class="portlet-body">
                            <div class="left">
                                <ul id="menu" name="menus" class="ztree" style="width:250px;"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" style="height: auto;">
                    <div class="portlet light bordered" style="height: 587px;">
                        <div class="portlet-body">
                            <ul id="permissions" class="ztree pt-10">

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer" style="border-top: 0px">
                <button id="menuModalSave" class="btn btn-primary">保存并关闭</button>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/js/system/role-list.js"></script>
</body>
</html>
