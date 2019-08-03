var table;
$(document).ready(function () {
    table = $('#dataTables').DataTable({
        "responsive": true,
        "paginate": true,
        "processing": true,
        "serverSide": true,
        "searching": false,
        "ordering": false,
        "pagingType": 'full_numbers',
        "ajax": {
            "url": ctx + '/api/hospital/list',
            "type": 'post'
        },
        "columnDefs": [{
            "aTargets": [7],
            "mData": "download_link",
            "mRender": function (data) {
                var html = '<a class="btn btn-sm blue btn-outline filter-cancel" href="javascript:editFun(' + data.id + ')"><i class="fa fa-edit"></i>编辑</a>\n';
                html += '<a class="btn btn-sm red btn-outline filter-cancel" href="javascript:deleteFun(' + data.id + ')"><i class="fa fa-remove"></i>删除</a>';

                return html;
            }
        }],
        "createdRow": function (row, data, index) {
            $('td', row).eq(4).attr('style', 'width:200px;word-wrap:break-word;');
        },
        "columns": [
            {"data": "name"},
            {"data": "address"},
            {"data": "contactor"},
            {"data": "phone"},
            {"data": "remark"},
            {"data": "logo"},
            {
                "data": "createTime", "render": function (data) {
                    return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {"data": null}
        ],
        "language": {
            "url": ctx +'/plugins/datatables/language-chinese.json'
        }
    });
});

function deleteFun(id) {
    commonFn.deleteData(id, ctx + "/api/hospital/delete", table);
}


function editFun(id) {
    window.location.href = ctx + "/hospital/handle?hospitalId=" + id;
}

function addModal() {
    window.location.href = ctx + "/hospital/handle";
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




