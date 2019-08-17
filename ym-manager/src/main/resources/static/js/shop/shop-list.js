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
            "url": ctx + '/api/shop/page',
            "type": 'post'
        },
        "columnDefs": [{
            "aTargets": [4],
            "mData": "download_link",
            "mRender": function (data) {
                var html = '<a class="btn btn-sm blue btn-outline filter-cancel" href="javascript:editFun(' + data.id + ')"><i class="fa fa-edit"></i>编辑</a>\n';
                html += '<a class="btn btn-sm red btn-outline filter-cancel" href="javascript:deleteFun(' + data.id + ')"><i class="fa fa-remove"></i>删除</a>';

                return html;
            }
        }],
        "columns": [
            {"data": "name"},
            {"data": "address"},
            {"data": "remark"},
            {"data": "phone"},
            {"data": null}
        ],
        "language": {
            "url": ctx + '/plugins/datatables/language-chinese.json'
        }
    });
});

function deleteFun(id) {
    commonFn.deleteData(id, ctx + "/api/doctor/delete", table);
}


function editFun(id) {
    window.location.href = ctx + "/doctor/handle?doctorId=" + id;
}

function addModal() {
    window.location.href = ctx + "/doctor/handle";
}




