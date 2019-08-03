var table;
$(document).ready(function () {
    table = $('#dataTables-user').DataTable({
        "responsive": true,
        "paginate": true,
        "processing": true,
        "serverSide": true,
        "searching": false,
        "ordering": false,
        "pagingType": 'full_numbers',
        "ajax": {
            "url": ctx + '/api/user/list',
            "type": 'post'
        },
        "columnDefs": [{
            "aTargets": [6],
            "mData": "download_link",
            "mRender": function (data) {
                var html = '<a class="btn btn-sm blue btn-outline filter-cancel" href="javascript:editUser(\'' + data.id + '\',\'' + data.name + '\',\'' + data.mobile + '\',\'' + data.email + '\')"><i class="fa fa-edit"></i>编辑</a>\n';
                html += '<a class="btn btn-sm purple btn-outline filter-cancel" href="javascript:addUserRole(\'' + data.id + '\',\'' + data.roleIds + '\')"><i class="fa fa-users"></i>分配角色</a>\n';
                html += '<a class="btn btn-sm red btn-outline filter-cancel" href="javascript:deleteUser(' + data.id + ')"><i class="fa fa-remove"></i>删除</a>';

                return html;
            }
        }],
        "createdRow": function (row, data, index) {
            $('td', row).eq(4).attr('style', 'width:200px;word-wrap:break-word;');
        },
        "columns": [
            {"data": "name"},
            {"data": "mobile"},
            {"data": "email"},
            {"data": "roleNames"},
            {
                "data": "status", "render": function (data) {
                    return data == 1 ? '启用' : '禁用';
                }
            },
            {
                "data": "createTime", "render": function (data) {
                    return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {"data": null}
        ],
        "language": {
            "url":ctx + '/plugins/datatables/language-chinese.json'
        }
    });
});

function deleteUser(id) {
    commonFn.deleteData(id, ctx + "/api/user/delete", table);
}

var $addUserForm = $('#addUserForm');
var $addUserRoleForm = $('#addUserRoleForm');

function editUser(id, name, mobile, email) {
    $addUserForm.validate().resetForm();
    commonFn.removeClass();

    $("#id").val(id);
    $("#name").val(name);
    $("#mobile").val(mobile);
    $("#email").val(email);
    $("#passwordDiv").hide();
    $("#addUserModal").modal('show');
    $("#myModalLabel").html("编辑用户");
}

function addUserModal() {
    $addUserForm.validate().resetForm();
    commonFn.removeClass();
    commonFn.emptyVal();

    $("#passwordDiv").show();
    $("#myModalLabel").html("添加用户");
    $("#saveUserBtn").prop("disabled", false);
}

function addUserRole(userId, userRoleIds) {
    $addUserForm.validate().resetForm();
    commonFn.removeCheck();

    $(".checkbox-inline input[type='checkbox']").each(function () {
        var value = $(this).attr('value')
        for (var i = 0; i < userRoleIds.length; i++) {
            if (userRoleIds[i] == value) {
                $.uniform.update($(this).prop("checked", true));
            }
        }
    });

    $("#userId").val(userId);
    $("#addUserRoleModal").modal('show');
    $("#saveUserBtn").prop("disabled", false);
}

$(document).ready(function () {
    commonFn.formSubmit($addUserForm, "saveUserBtn", "addUserModal", "", function ($addUserForm) {
        addFormRule($addUserForm);
    });

    commonFn.formSubmit($addUserRoleForm, "saveUserRoleBtn", "addUserRoleModal", "", function ($addUserRoleForm) {
        //addUserRoleFormRule($addUserRoleForm);
    });
});

function addFormRule($form) {
    $form.find("input[name='name']").rules("add", {required: true, messages: {required: "请输入用户名"}});
    $form.find("input[name='password']").rules("add", {required: true, messages: {required: "请输入密码"}});
}

function addUserRoleFormRule($form) {
    $form.find("input[name='roleIds']").rules("add", {required: true, messages: {required: "请选择用户角色"}});
}



