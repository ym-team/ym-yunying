<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${ctx}/js/see-admin-common.js"></script>
    <script>
        var ctx = '${ctx}';
    </script>
    <style>
        #addUserProfileModal {
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
                    <span class="caption-subject font-green sbold uppercase">用户列表</span>
                </div>
                <div class="actions">
                    <div class="btn-group">
                        <a class="btn green" data-toggle="modal" href="#addUserModal" onclick="addUserModal()"><i class="glyphicon glyphicon-plus"></i>添加</a>
                    </div>
                </div>
            </div>
            <div class="portlet-body">
                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-user">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>手机号</th>
                        <th>邮箱</th>
                        <th>用户角色</th>
                        <th>状态</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="addUserForm" action="${ctx}/api/user/save" method="post">
                    <input id="id" name="id" type="hidden">
                    <div class="form-group">
                        <label>用户名</label>
                        <input id="name" name="name" class="form-control" placeholder="用户名">
                    </div>
                    <div class="form-group" id="passwordDiv">
                        <label>密码</label>
                        <input id="password" name="password" type="password" class="form-control" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <label>手机号</label>
                        <input id="mobile" name="mobile" class="form-control" placeholder="手机号">
                    </div>
                    <div class="form-group">
                        <label>邮箱帐号</label>
                        <input id="email" name="email" class="form-control" placeholder="邮箱帐号">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveUserBtn">保存</button>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addUserRoleModal" tabindex="-1" role="dialog" aria-labelledby="addUserRoleLabel" aria-hidden="true">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="addUserRoleLabel">分配角色</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="addUserRoleForm" action="${ctx}/api/user/addUserRole" method="post">
                    <input id="userId" name="userId" type="hidden">
                    <div class="form-group" id="roleIdDiv">
                        <label>角色(<input type="checkbox" id="checkAll" onclick="commonFn.checkAll('checkAll')">全选 )</label>
                        <div class="row">
                            <div class="checkbox">
                                <c:forEach items="${roles}" var="role">
                                    <div class="col-md-4 form-group">
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="roleIds" value="${role.id}">${role.description}
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="saveUserRoleBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}/js/system/user-list.js"></script>
</body>
</html>
