<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>顾客信息</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="../taglibs.jsp" %>
</head>

<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <header class="jwytz-header">
        <h3>
            <span onclick="history.go(-1)"></span>顾客信息<em></em>
        </h3>
    </header>

    <div class="wd_con sl_wd_con">
    
    	<form action="" id="custConsumer">
        <ul class="sl_czfs">

            <li class="sl_ji">
                <p>客人姓名</p>
                <div class="position-rel">
                    <input type="text" id="consuName" name="consuName" class="form-control" style="width: 9rem;" placeholder="${custConsumer.consuName }">
                </div>
            </li>
            <li class="sl_ji">
                <p>客人电话</p>
                <div class="position-rel">
                    <input type="text" id="consuPhone" name="consuPhone" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuPhone }">
                </div>
            </li>

            <li class="sl_ji">
                <p>客人年龄</p>
                <div class="position-rel">
                    <input type="text" id="consuAge" name="consuAge" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuAge }">
                </div>
            </li>
            <li class="sl_ji">
                <p>确定项目</p>
                <div class="position-rel">
                    <input type="text" id="consuConfirmItem" name="consuConfirmItem" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuConfirmItem }">
                </div>
            </li>
            <li class="sl_ji">
                <p>意向项目</p>
                <div class="position-rel">
                    <input type="text" id="consuWanttoItem" name="consuWanttoItem" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuWanttoItem }">
                </div>
            </li>

            <li class="sl_ji">
                <p>享受政策</p>
                <div class="position-rel">
                    <input type="text" id="enjoyPolicy" name="enjoyPolicy" style="width: 9rem;" class="form-control" placeholder="${custConsumer.enjoyPolicy }">
                </div>
            </li>
            <li class="sl_ji">
                <p>服务顾问</p>
                <div class="position-rel">
                    <input type="text" id="serviceConsult" name="serviceConsult" style="width: 9rem;" class="form-control" placeholder="${custConsumer.serviceConsult }">
                </div>
            </li>
            <li class="sl_ji">
                <p>顾客分析</p>
                <div class="position-rel">
                    <input type="text" id="consuAnaylise" name="consuAnaylise" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuAnaylise }">
                </div>
            </li>
            <li class="sl_ji">
                <p>工作</p>
                <div class="position-rel">
                    <input type="text" id="consuWork" name="consuWork" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuWork }">
                </div>
            </li>
            <li class="sl_ji">
                <p>性格</p>
                <div class="position-rel">
                    <input type="text" id="consuCharacter" name="consuCharacter" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuCharacter }">
                </div>
            </li>
            <li class="sl_ji">
                <p>年收入</p>
                <div class="position-rel">
                    <input type="text" id="consuIncome" name="consuIncome" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuIncome }">
                </div>
            </li>
            <li class="sl_ji">
                <p>消费价值观</p>
                <div class="position-rel">
                    <input type="text" id="consuValue" name="consuValue" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuValue }">
                </div>
            </li>
            <li class="sl_ji">
                <p>铺垫次数</p>
                <div class="position-rel">
                    <input type="text" id="consuPreCount" name="consuPreCount" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuPreCount }">
                </div>
            </li>
            <li class="sl_ji" style="line-height:inherit">
                <p>最大的抗拒点是什么</p>
                <div class="position-rel">
                    <input type="text" id="consuMaxReject" name="consuMaxReject" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuMaxReject }">
                </div>
            </li>
            <li class="sl_ji">
                <p>备注</p>
                <div class="position-rel">
                    <input type="text" id="remark" name="remark" style="width: 9rem;" class="form-control" placeholder="${custConsumer.remark }">
                </div>
            </li>
        </ul>
        </form>
    </div>
	</div>
    <jsp:include page="/h5/foot.do?footId=4"></jsp:include>
</div>
</body>
<script type="text/javascript">
    function sub() {
	    var formdata = $("#custConsumer").serialize();
		//JSON.stringify(formdata)
        var data = {};
        $.ajax({
            cache: false,
            type: "POST",
            url: "${pathWeb }/customer/toCustomerAdd.do",
            data: formdata,
            async: false,
            error: function (request) {
                alert("系统繁忙，请稍后重试");
            },
            success: function (data) {
                if (data.code == "200") {
                    //window.location.reload();
                	 openPage("${pathWeb }/customer/list.do");
                }
            }
        });
    }
</script>
</html>