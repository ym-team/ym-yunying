var $addForm = $('#addForm');

function backModal() {
    window.location.href = ctx + "/hospital/list";
}

$(document).ready(function () {
    $("#saveBtn").on("click", function () {
        var id = $("#id").val();
        var tip = "添加成功!";
        if (id != '' && id != null) {
            tip = "更新成功!";
        }
        $addForm.ajaxSubmit({
            beforeSubmit: function (formData, form, options) {
                var valid = form.valid();
                if (!valid) {
                    return false;
                }
                $("#saveBtn").prop("disabled", true);
                return true;
            },
            success: function (result) {
                $("#saveBtn").prop("disabled", false);
                if (result.code == "200") {
                    swal({
                        title: "",
                        text: tip,
                        type: "success",
                        closeOnConfirm: true
                    }, function () {
                        window.location.href = ctx + "/hospital/list";
                    });
                } else {
                    swal({title: "", text: result.msg, type: "error", closeOnConfirm: true});
                }
            }
        });
    })
});


function addFormRule($form) {
    $form.find("input[name='name']").rules("add", {required: true, messages: {required: "请输入用户名"}});
    $form.find("input[name='password']").rules("add", {required: true, messages: {required: "请输入密码"}});
}

function addUserRoleFormRule($form) {
    $form.find("input[name='roleIds']").rules("add", {required: true, messages: {required: "请选择用户角色"}});
}



