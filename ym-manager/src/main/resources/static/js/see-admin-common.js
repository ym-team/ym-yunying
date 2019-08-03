var delClass = "btn btn-sm red btn-outline filter-cancel ";

var editClass = "btn btn-sm blue btn-outline filter-cancel ";

var commonFn = {
    removeClass: function () {
        var select = $('.modal-body').find('select');
        $(select).each(function () {
            $(this).removeClass("error");
        });
        var input = $('.modal-body').find('input');
        $(input).each(function () {
            $(this).removeClass("error");
        });
    },
    emptyVal: function () {
        var select = $('.modal-body').find('select');
        $(select).each(function () {
            $(this).val("");
        });
        var input = $('.modal-body').find('input');
        $(input).each(function () {
            var type = $(this).attr("type");
            if ("checkbox" == type) {
                $(this).removeAttr("checked");
            } else {
                $(this).val("");
            }
        });
    },
    checkAll: function (id) {
        var checkAll = $("#" + id).prop("checked");
        $(".checkbox-inline input[type='checkbox']").each(function () {
            if (checkAll) {
                $.uniform.update($(this).prop("checked", true));
            } else {
                $.uniform.update($(this).attr("checked", false));
            }
        });
    },
    removeCheck: function () {
        $.uniform.update($("#checkAll").prop("checked", false));
        $(".checkbox-inline input[type='checkbox']").each(function () {
            $.uniform.update($(this).attr("checked", false));
        });
    },
    subStr: function (data, length) {
        if (data == null || data == undefined) {
            return "";
        }
        return data.length > length ? data.substring(0, length) + "..." : data;
    },
    deleteData: function (id, url, table) {
        swal({
                title: "",
                text: "确认删除该数据？",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#458ae6",
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                closeOnConfirm: false,
                closeOnCancel: true
            },
            function (isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: {
                            id: id
                        },
                        success: function (result) {
                            if (result.code == "200") {
                                swal({
                                    title: "",
                                    text: "删除成功!",
                                    type: "success",
                                    closeOnConfirm: true
                                }, function () {
                                    table.ajax.reload();
                                });
                            } else {
                                swal({title: "", text: result.msg, type: "error", closeOnConfirm: true});
                            }
                        }
                    })
                }
            });
    },
    synData: function (id, url, table) {
        swal({
                title: "",
                text: "确认同步数据？",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#458ae6",
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                closeOnConfirm: false,
                closeOnCancel: true
            },
            function (isConfirm) {
                if (isConfirm) {
                    $.ajax({
                        type: 'POST',
                        url: url,
                        data: {
                            profileId: id
                        },
                        success: function (result) {
                            if (result.code == "200") {
                                swal({
                                    title: "",
                                    text: "同步成功!",
                                    type: "success",
                                    closeOnConfirm: true
                                }, function () {
                                    table.ajax.reload();
                                });
                            } else {
                                swal({title: "", text: result.msg, type: "error", closeOnConfirm: true});
                            }
                        }
                    });
                }
            });
    },
    formSubmit: function ($form, saveBtn, addModal, tipMsg, callBackFun) {
        $form.validate({
            onfocusout: function (element) {
                $(element).valid();
            }
        });
        callBackFun($form);

        $("#" + saveBtn).on("click", function () {
            var id = $("#id").val();
            var tip = "添加成功!";
            if (id != '' && id != null) {
                tip = "更新成功!";
            }
            var msg;
            if (tipMsg == '') {
                msg = tip;
            } else {
                msg = tipMsg;
            }
            $form.ajaxSubmit({
                beforeSubmit: function (formData, form, options) {
                    var valid = form.valid();
                    if (!valid) {
                        return false;
                    }
                    $("#" + saveBtn).prop("disabled", true);
                    return true;
                },
                success: function (result) {
                    $("#" + saveBtn).prop("disabled", false);
                    $("#" + addModal).modal('hide');
                    if (result.code == "200") {
                        swal({
                            title: "",
                            text: msg,
                            type: "success",
                            closeOnConfirm: true
                        }, function () {
                            table.ajax.reload();
                        });
                    } else {
                        swal({title: "", text: result.msg, type: "error", closeOnConfirm: true});
                    }
                }
            });
        })
    },
    confirmTips: function (msg, callBackFun, args) {
        swal({
                title: "",
                text: msg,
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#458ae6",
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                closeOnConfirm: true,
                closeOnCancel: true,

            },
            function (isConfirm) {
                if (isConfirm) {
                    callBackFun(args);
                }
            });
    }
};
