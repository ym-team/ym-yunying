var $addForm = $('#addForm');

function backModal() {
    window.location.href = ctx + "/doctor/list";
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
                        window.location.href = ctx + "/doctor/list";
                    });
                } else {
                    swal({title: "", text: result.msg, type: "error", closeOnConfirm: true});
                }
            }
        });
    })
});




function selectCoopType(val){
	var value = $(val).val();
	var url;
	if(value == 1 ){
		url = ctx + "/api/hospital/list" //医院 
	}else if(value == 2){
		url = ctx + "/api/shop/list"// 店家
	}else{
		return '请选择合作类型'; 
	}
	
	$.ajax({
	    url: url,
	    data: {type: value},
	    type: "POST",
	    dataType: "json",
	    success: function(data) {
	        // data = jQuery.parseJSON(data);  //dataType指明了返回数据为json类型，故不需要再反序列化
	        alert(data);
	        console.log(data);
	    }


})};










