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
            "url": ctx + '/api/role/list',
            "type": 'post'
        },
        "columnDefs": [{
            "aTargets": [3],
            "mData": "download_link",
            "mRender": function (data) {
                var html = '<a class="btn btn-sm blue btn-outline filter-cancel" href="javascript:editRole(\'' + data.id + '\',\'' + data.name + '\',\'' + data.description + '\')"><i class="fa fa-edit"></i>编辑</a>\n' +
                    '<a class="btn btn-sm red btn-outline filter-cancel" href="javascript:deleteRole(' + data.id + ')"><i class="fa fa-remove"></i>删除</a>\n';

                return html;
            }
        }],
        "columns": [
            {"data": "name"},
            {"data": "description"},
            {
                "data": "createTime", "render": function (data) {
                    return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {"data": null}
        ],
        "language": {
            "url": ctx + '/plugins/datatables/language-chinese.json'
        }
    });
});

function deleteRole(id) {
    commonFn.deleteData(id, ctx + "/api/role/delete", table);
}

var $form = $('#addForm');

function editRole(id, name, description) {
    $form.validate().resetForm();

    $("#id").val(id);
    $("#name").val(name);
    $("#description").val(description);
    $("#name").removeClass("error");
    $("#description").removeClass("description");
    $("#addModal").modal('show');
    $("#myModalLabel").html("编辑角色");
}

function addRoleModal() {
    $form.validate().resetForm();

    $("#id").val("");
    $("#name").val("");
    $("#description").val("");
    $("#name").removeClass("error");
    $("#description").removeClass("error");
    $("#myModalLabel").html("添加角色");
    $("#saveBtn").prop("disabled", false);
}

$(document).ready(function () {
    commonFn.formSubmit($form, "saveBtn", "addModal", "", function ($form) {
        addFormRule($form)
    });
});

function addFormRule($form) {
    $form.find("input[name='name']").rules("add", {required: true, messages: {required: "请输入角色名称"}});
    $form.find("input[name='description']").rules("add", {required: true, messages: {required: "请输入角色描述"}});
}
