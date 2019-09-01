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
            "url": ctx + '/api/cfgCooperationRate/page',
            "type": 'post'
        },
        "columnDefs": [{
            "aTargets": [10],
            "mData": "download_link",
            "mRender": function (data) {
                var html = '<a class="btn btn-sm blue btn-outline filter-cancel" href="javascript:editFun(' + data.id + ')"><i class="fa fa-edit"></i>编辑</a>\n';
                html += '<a class="btn btn-sm red btn-outline filter-cancel" href="javascript:deleteFun(' + data.id + ')"><i class="fa fa-remove"></i>删除</a>';

                return html;
            }
        }],
        "columns": [
            {"data": "id"},
            {"data": "amortization_id"},
            {"data": "status"},
            {"data": "rate"},
            {"data": "type"},
            {
                "data": "create_time", "render": function (data) {
                    return (new Date(data)).Format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {"data": "update_time"},
            {"data": "remark"},
            {"data": "update_id"},
            {"data": "create_id"},
     

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
    window.location.href = ctx + "/cfgCooperationRate/handle";
}




