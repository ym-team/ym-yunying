<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>咨询预约</title>
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
            <span onclick="history.go(-1)"></span>咨询预约<em></em>
        </h3>
    </header>

    <div class="wd_con sl_wd_con">
        <ul class="sl_czfs">
            <li class="sl_ji">
                <p>顾客姓名</p>
                <div class="position-rel">
                    <input type="text" class="form-control" style="width: 9rem;" placeholder="请输入顾客姓名">
                </div>
            </li>
            <li class="sl_ji">
                <p>顾客年龄</p>
                <div class="position-rel">
                    <input type="text" class="form-control" style="width: 9rem;" placeholder="请输入顾客年龄">
                </div>
            </li>
            <li class="sl_ji">
                <p>顾客电话</p>
                <div class="position-rel">
                    <input type="number" class="form-control" style="width: 9rem;" placeholder="请输入顾客电话">
                </div>
            </li>
            <li class="sl_ji">
                <p>顾客职业</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入顾客职业">
                </div>
            </li>
            <li class="sl_ji" style="line-height:inherit">
                <p>预约到院咨询时间</p>
                <div class="position-rel">
                    <input type="number" class="form-control" style="width: 9rem;" placeholder="请输入预约到院咨询时间">
                </div>
            </li>
            <li class="sl_ji">
                <p>咨询项目</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入咨询项目">
                </div>
            </li>
            <li class="sl_ji">
                <p>是否打板</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入是否打板">
                </div>
            </li>
            <li class="sl_ji">
                <p>是否分期</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入是否分期">
                </div>
            </li>
            <li class="sl_ji" style="line-height:inherit">
                <p>做过哪些整形项目</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入做过哪些整形项目">
                </div>
            </li>
            <li class="sl_ji" style="line-height:inherit">
                <p>做过的项目价格</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入做过的项目价格">
                </div>
            </li>
            <li class="sl_ji">
                <p>备注</p>
                <div class="position-rel">
                    <input type="text" style="width: 9rem;" class="form-control" placeholder="请输入备注">
                </div>
            </li>
        </ul>
    </div>
    <div class="btn4">
        <a style="margin-bottom: 5rem;" href="javascript:void(0)" onclick="sub();" class="com_btn1 sl_tixian">确认</a>
    </div>
    <jsp:include page="/h5/foot.do?footId=4"></jsp:include>
</div>
</body>
<script type="text/javascript">
    function sub() {
    	alert('test');
        var data = {};
        $.ajax({
            cache: false,
            type: "POST",
            url: "${pathWeb }/customer/list.do",
            data: data,
            async: false,
            error: function (request) {
                alert("系统繁忙，请稍后重试");
            },
            success: function (data) {
                if (data.code == "200") {
                    window.location.reload();
                }
            }
        });
    }
</script>
</html>