<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>身份信息</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="../taglibs.jsp" %>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        li {
            list-style-type: none;
        }

        a, input {
            outline: none;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
        }

        #choose {
            display: none;
        }

        #choosefm {
            display: none;
        }

        #choosesc {
            display: none;
        }

        canvas {
            width: 100%;
            border: 1px solid #000000;
        }

        #upload {
            display: block;
            height: 60px;
            text-align: center;
            line-height: 60px;
            border: 1px solid;
            border-radius: 5px;
            cursor: pointer;
        }

        #uploadfm {
            display: block;
            height: 60px;
            text-align: center;
            line-height: 60px;
            border: 1px solid;
            border-radius: 5px;
            cursor: pointer;
        }

        #uploadsc {
            display: block;
            height: 60px;
            text-align: center;
            line-height: 60px;
            border: 1px solid;
            border-radius: 5px;
            cursor: pointer;
        }

        .touch {
            background-color: #ddd;
        }

        .img-list {
            margin: 10px 5px;
        }

        .img-list li {
            position: relative;
            display: inline-block;
            width: 95%;
            height: 170px;
            margin: -5px 5px 20px 5px;
            border: 1px solid rgb(100, 149, 198);
            background: #fff no-repeat center;
            background-size: cover;
        }

        .img-listfm {
            margin: 10px 5px;
        }

        .img-listfm li {
            position: relative;
            display: inline-block;
            width: 95%;
            height: 170px;
            margin: -5px 5px 20px 5px;
            border: 1px solid rgb(100, 149, 198);
            background: #fff no-repeat center;
            background-size: cover;
        }

        .img-listsc {
            margin: 10px 5px;
        }

        .img-listsc li {
            position: relative;
            display: inline-block;
            width: 95%;
            height: 170px;
            margin: -5px 5px 20px 5px;
            border: 1px solid rgb(100, 149, 198);
            background: #fff no-repeat center;
            background-size: cover;
        }

        .progress {
            position: absolute;
            width: 100%;
            height: 20px;
            line-height: 20px;
            bottom: 0;
            left: 0;
            background-color: rgba(100, 149, 198, .5);
        }

        .progress span {
            display: block;
            width: 0;
            height: 100%;
            background-color: rgb(100, 149, 198);
            text-align: center;
            color: #FFF;
            font-size: 13px;
        }

        .size {
            position: absolute;
            width: 100%;
            height: 15px;
            line-height: 15px;
            bottom: -18px;
            text-align: center;
            font-size: 13px;
            color: #666;
        }

        .tips {
            display: block;
            text-align: center;
            font-size: 13px;
            margin: 10px;
            color: #999;
        }

        .pic-list {
            margin: 10px;
            line-height: 18px;
            font-size: 13px;
        }

        .pic-list a {
            display: block;
            margin: 10px 0;
        }

        .pic-list a img {
            vertical-align: middle;
            max-width: 30px;
            max-height: 30px;
            margin: -4px 0 0 10px;
        }

        .sfzwrap {
            border: 1px solid #ccc;
            border-radius: 8px;
            height: 190px;
        }

        .prel {
            position: relative;
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }

        .phoes {
            height: auto;
        }

        .phoes {
            height: 118px;
            display: block;
        }

        .sfzwrap input {
            position: absolute;
            width: 100%;
            height: 120px;
            opacity: 0;
        }

        .sfzp {
            margin: 6px;
        }

        .sfzp, .shahead {
            text-align: center;
        }

        .sfzp img {
            height: 186px;
        }

        img {
            border: 0;
        }

        .hcamera {
            width: 60px;
            height: 60px;
            top: 50%;
            left: 50%;
            margin-left: -30px;
            margin-top: -30px;
        }

        .pab {
            position: absolute;
        }

        .hcamera img {
            width: 100%;
        }

        .sfztip {
            color: #fff;
            font-size: 14px;
            line-height: 28px;
            width: 162px;
            top: 74%;
            left: 50%;
            margin-left: -81px;
            background: #9cf;
            opacity: .5;
            padding: 0 9px;
        }
    </style>
</head>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <header class="jwytz-header">
        <h3>
            <span onclick="history.go(-1)"></span>我的身份<em></em>
        </h3>
    </header>
    <input type="hidden" name="saleManId" id="saleManId" value="${saleMan.id}">
    <c:if test="${saleMan.auditStatus=='1' || saleMan.auditStatus=='4'}">
        <c:set value="disabled" var="disabled"/>
    </c:if>
    <div class="wd_con sl_wd_con">
        <ul class="sl_czfs">
            <li class="sl_ji sl_ji1">
                <c:if test="${saleMan.auditStatus == 2 || saleMan.auditStatus == 3}">
                    <input type="text" class="form-control" placeholder="真实姓名" name="realName" id="realName" value="${saleMan.realName}">
                </c:if>
                <c:if test="${saleMan.auditStatus == 1 || saleMan.auditStatus == 4}">
                    <input type="text" class="form-control" placeholder="真实姓名" ${disabled} name="realName" id="realName" value="${fn:substring(saleMan.realName, 0, 1) }****">
                </c:if>
            </li>
            <li class="sl_ji sl_ji1">
                <c:if test="${saleMan.auditStatus == 2 || saleMan.auditStatus == 3}">
                    <input type="text" class="form-control" placeholder="身份证号" name="idCard" id="idCard" value="${saleMan.idCard}">
                </c:if>
                <c:if test="${saleMan.auditStatus == 1 || saleMan.auditStatus == 4}">
                    <c:set value="${fn:length(saleMan.idCard)}" var="cardNumberLen"/>
                    <input type="text" class="form-control" placeholder="身份证号" ${disabled} name="idCard" id="idCard"
                           value="${fn:substring(saleMan.idCard,0,4)}*********${fn:substring(saleMan.idCard,14,cardNumberLen)}">
                </c:if>
            </li>
        </ul>

        <!-- pho zm-->
        <c:set value="${configjscss }/images/imgs/uppic1.png" var="sfzzm"/>
        <c:if test="${not empty saleMan.sfzZm}">
            <c:set value="${pathWeb}/${saleMan.sfzZm}" var="sfzzm"/>
        </c:if>
        <div class="sfzwrap prel" id="sfzzm_show" style="background-image: url('${sfzzm}');">
            <div class="phoes" class="uploader-list">
                <input type="file" name="sfzzm_file" id="sfzzm_file" ${disabled} accept="image/*" onchange="uploadImage()"/>
                <input type="hidden" id="sfzzm" name="sfzzm" value="${saleMan.sfzZm}"/>
                <div class="hcamera pab">
                    <img src="${configjscss}/images/imgs/hcamera.png">
                </div>
                <div class="sfztip pab">身份证正面照扫描上传</div>
            </div>
        </div>

        <!-- pho fm -->
        <c:set value="${configjscss }/images/imgs/uppic2.png" var="sfzfm"/>
        <c:if test="${not empty saleMan.sfzFm}">
            <c:set value="${pathWeb}/${saleMan.sfzFm}" var="sfzfm"/>
        </c:if>
        <div class="sfzwrap prel" id="sfzfm_show" style="background-image: url('${sfzfm}');">
            <div class="phoes" class="uploader-list">
                <input type="file" name="sfzfm_file" id="sfzfm_file" ${disabled} accept="image/*" onchange="uploadImage2()"/>
                <input type="hidden" id="sfzfm" name="sfzfm" value="${saleMan.sfzFm}"/>
                <div class="hcamera pab">
                    <img src="${configjscss }/images/imgs/hcamera.png">
                </div>
                <div class="sfztip pab">身份证反面照扫描上传</div>
            </div>
        </div>

        <c:set value="${configjscss }/images/imgs/uppic3.png" var="sfzsc"/>
        <c:if test="${not empty saleMan.sfzSc}">
            <c:set value="${pathWeb}/${saleMan.sfzSc}" var="sfzsc"/>
        </c:if>
        <!-- pho sc-->
        <div class="sfzwrap prel h130" id="sfzsc_show" style="background-image: url('${sfzsc }');">
            <div class="phoes" class="uploader-list">
                <input type="file" id="sfzsc_file" name="sfzsc_file" ${disabled} accept="image/*" onchange="uploadImage3()"/>
                <input type="hidden" id="sfzsc" name="sfzsc" value="${saleMan.sfzSc}"/>
                <div class="hcamera pab">
                    <img src="${configjscss }/images/imgs/hcamera.png">
                </div>
                <div class="sfztip pab">手持身份证照扫描上传</div>
            </div>
        </div>

        <div class="btn4">
            <a href="javascript:;" ${disabled} onclick="sub();" data-audit-status="${saleMan.auditStatus}" data-ajax="false" class="com_btn1 sl_tixian">
                <c:if test="${saleMan.auditStatus == 1}">认证通过</c:if>
                <c:if test="${saleMan.auditStatus == 2}">提交</c:if>
                <c:if test="${saleMan.auditStatus == 3}">认证不通过</c:if>
                <c:if test="${saleMan.auditStatus == 4}">待审核</c:if>
            </a>
        </div>
        <br>
        <br>
        <jsp:include page="foot.do?footId=4"></jsp:include>
    </div>
</div>

<script type="text/javascript">
    function uploadImage() {
        var file = $("#sfzzm_file").val();
        if (file == "") {
            alert("请选择图片");
        }
        var formdata = new FormData();
        formdata.append('fileName', $('#sfzzm_file').get(0).files[0]);
        $.ajax({
            async: false,
            type: 'POST',
            url: "${pathWeb}/user/imageUpload",
            dataType: 'json',
            data: formdata,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#sfzzm_show").css("background-image:", "url(${pathWeb}/" + data.data + ")");
                $("#sfzzm_show").attr("style", "background-image:url(${pathWeb}/" + data.data + ")");
                $("#sfzzm").val(data.data);
            }
        });
    }

    function uploadImage2() {
        var file = $("#sfzfm_file").val();
        if (file == "") {
            alert("请选择图片");
        }
        var formdata = new FormData();
        formdata.append('fileName', $('#sfzfm_file').get(0).files[0]);
        $.ajax({
            async: false,
            type: 'POST',
            url: "${pathWeb}/user/imageUpload",
            dataType: 'json',
            data: formdata,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#sfzfm_show").css("background-image:", "url(${pathWeb}/" + data.data + ")");
                $("#sfzfm_show").attr("style", "background-image:url(${pathWeb}/" + data.data + ")");
                $("#sfzfm").val(data.data);
            }
        });
    }

    function uploadImage3() {
        var flag = true;
        var file = $("#sfzsc_file").val();
        if (file == "") {
            flag = false;
            alert("请选择图片");
        }
        var formdata = new FormData();
        formdata.append('fileName', $('#sfzsc_file').get(0).files[0]);
        $.ajax({
            async: false,
            type: 'POST',
            url: "${pathWeb}/user/imageUpload",
            dataType: 'json',
            data: formdata,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#sfzsc_show").css("background-image:", "url(${pathWeb}/" + data.data + ")");
                $("#sfzsc_show").attr("style", "background-image:url(${pathWeb}/" + data.data + ")");
                $("#sfzsc").val(data.data);
            }
        });
    }
</script>

<script type="text/javascript">
    function sub() {
        if ('${disabled}' === 'disabled') {
            return;
        }
        var realName = $("#realName").val();
        if (realName == "" || realName == null) {
            alert("真实姓名不能为空");
            return;
        }
        var idCard = $("#idCard").val();
        if (idCard == "" || idCard == null) {
            alert("身份证号不能为空");
            return;
        }

        //检查
        var cardNoInfo = getIdCardInfo(idCard);
        if (!cardNoInfo.isTrue) {
            alert("身份证号格式错误.");
            return;
        }
        var saleManId = $("#saleManId").val();
        var sfzzm = $("#sfzzm").val();
        var sfzfm = $("#sfzfm").val();
        var sfzsc = $("#sfzsc").val();
        if (sfzzm == '' || sfzfm == '' || sfzsc == '') {
            alert("请上传相关证件！");
            return;
        }

        var data = {
            "saleManId": saleManId,
            "realName": realName,
            "cardNum": idCard,
            "sfzzm": sfzzm,
            "sfzfm": sfzfm,
            "sfzsc": sfzsc
        };
        $.ajax({
            cache: false,
            type: "POST",
            url: "${pathWeb}/user/realNameAuth.do",
            data: data,
            async: false,
            error: function (request) {
                alert("系统繁忙，请稍后重试");
            },
            success: function (data) {
                if (data.code == "200") {
                    alert("提交成功，等待审核.");
                    window.location.href = "${pathWeb}/user/userIndex.do";
                } else {
                    alert(data.msg);
                    window.location.reload();
                }
            }
        });
    }

    function getIdCardInfo(cardNo) {
        var info = {
            isTrue: false,
            year: null,
            month: null,
            day: null,
            isMale: false,
            isFemale: false
        };
        if (!cardNo && 15 != cardNo.length && 18 != cardNo.length) {
            info.isTrue = false;
            return info;
        }
        if (15 == cardNo.length) {
            var year = cardNo.substring(6, 8);
            var month = cardNo.substring(8, 10);
            var day = cardNo.substring(10, 12);
            var p = cardNo.substring(14, 15); //性别位
            var birthday = new Date(year, parseFloat(month) - 1, parseFloat(day));
            // 对于老身份证中的年龄则不需考虑千年虫问题而使用getYear()方法
            if (birthday.getYear() != parseFloat(year)
                || birthday.getMonth() != parseFloat(month) - 1
                || birthday.getDate() != parseFloat(day)) {
                info.isTrue = false;
            } else {
                info.isTrue = true;
                info.year = birthday.getFullYear();
                info.month = birthday.getMonth() + 1;
                info.day = birthday.getDate();
                if (p % 2 == 0) {
                    info.isFemale = true;
                    info.isMale = false;
                } else {
                    info.isFemale = false;
                    info.isMale = true
                }
            }
            info.isTrue = false;
            return info;
        }
        if (18 == cardNo.length) {
            var year = cardNo.substring(6, 10);
            var month = cardNo.substring(10, 12);
            var day = cardNo.substring(12, 14);
            var p = cardNo.substring(14, 17)
            var birthday = new Date(year, parseFloat(month) - 1,
                parseFloat(day));
            // 这里用getFullYear()获取年份，避免千年虫问题
            if (birthday.getFullYear() != parseFloat(year)
                || birthday.getMonth() != parseFloat(month) - 1
                || birthday.getDate() != parseFloat(day)) {
                info.isTrue = false;
                return info;
            }
            var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,
                1];// 加权因子
            var Y = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2];// 身份证验证位值.10代表X
            // 验证校验位
            var sum = 0; // 声明加权求和变量
            var _cardNo = cardNo.split("");
            if (_cardNo[17].toLowerCase() == 'x') {
                _cardNo[17] = 10;// 将最后位为x的验证码替换为10方便后续操作
            }
            for (var i = 0; i < 17; i++) {
                sum += Wi[i] * _cardNo[i];// 加权求和
            }
            var i = sum % 11;// 得到验证码所位置
            if (_cardNo[17] != Y[i]) {
                return info.isTrue = false;
            }
            info.isTrue = true;
            info.year = birthday.getFullYear();
            info.month = birthday.getMonth() + 1;
            info.day = birthday.getDate();
            if (p % 2 == 0) {
                info.isFemale = true;
                info.isMale = false;
            } else {
                info.isFemale = false;
                info.isMale = true
            }
            return info;
        }
        return info;
    }
</script>
</body>
</html>