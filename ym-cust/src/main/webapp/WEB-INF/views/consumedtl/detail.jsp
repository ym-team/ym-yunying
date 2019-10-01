<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <style type="text/css">
        .form-control {
            width: 9rem;
        }
    </style>
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

<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
    <header class="jwytz-header">
        <h3>
            <span onclick="history.go(-1)"></span>资料上传<em></em>
        </h3>
    </header>
    <c:if test="${dtl.auditStatus=='1' || dtl.auditStatus=='2'}">
        <c:set value="disabled" var="disabled"/>
        <c:set value="readonly" var="readonly"/>
    </c:if>
    <div class="wd_con sl_wd_con">
        <form action="" id="consumeDtlForm">
            <input type="hidden" id="appointmentId" name="appointmentId" value="${param.id}"/>
            <input type="hidden" id="consumerId" name="consumerId" value="${param.consuId}"/>
            <input type="hidden" id="hospitalId" name="hospitalId" value="${param.consuYuYueHospital}"/>
            <input type="hidden" id="shopId" name="shopId" value="${param.shopId}"/>

            <ul class="sl_czfs">
                <li class="sl_ji">
                    <p>项目名称</p>
                    <div class="position-rel">
                        <input type="text" id="projectName" ${readonly} name="projectName" class="form-control" placeholder="项目名称" value="${dtl.projectName }">
                    </div>
                </li>
                <li class="sl_ji">
                    <p>总费用</p>
                    <div class="position-rel">
                        <input type="text" id="sumFee" ${readonly} name="sumFee" class="form-control" placeholder="总费用" value="${dtl.sumFee }">
                    </div>
                </li>

                <li class="sl_ji">
                    <p>材料费</p>
                    <div class="position-rel">
                        <input type="text" id="materialsFee" ${readonly} name="materialsFee" class="form-control" placeholder="材料费" value="${dtl.materialsFee }">
                    </div>
                </li>
                <li class="sl_ji">
                    <p>备注信息</p>
                    <div class="position-rel">
                        <input type="text" id="remark" ${readonly} name="remark" class="form-control" placeholder="备注信息" value="${dtl.remark }">
                    </div>
                </li>
                <c:if test="${dtl.auditStatus=='3'}">
                    <li class="sl_ji">
                        <p>不通过理由</p>
                        <div class="position-rel">
                            <input type="text" class="form-control" placeholder="不通过理由" value="${dtl.auditReason }">
                        </div>
                    </li>
                </c:if>
                <li class="sl_ji" style="height: 200px;">
                    <p>费用凭证图片</p>
                    <c:set value="${configjscss }/images/imgs/uppic3.png" var="attrUrl"/>
                    <c:if test="${not empty dtl.attrUrl}">
                        <c:set value="${pathWeb}/${dtl.attrUrl}" var="attrUrl"/>
                    </c:if>
                    <div class="position-rel">
                        <div class="sfzwrap prel" id="attrUrl_show" style="background-image: url('${attrUrl}');">
                            <div class="phoes" class="uploader-list">
                                <input type="file" name="attrUrl_file" ${disabled} id="attrUrl_file" accept="image/*" onchange="uploadImage()"/>
                                <input type="hidden" id="attrUrl" name="attrUrl" value="${dtl.attrUrl}"/>
                                <div class="hcamera pab">
                                    <img src="${configjscss}/images/imgs/hcamera.png">
                                </div>
                                <div class="sfztip pab">费用凭证图片</div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </form>
    </div>

    <div class="btn4">
        <c:if test="${dtl.auditStatus == 1 || dtl.auditStatus == 2}">
            <a style="margin-bottom: 5rem;" href="javascript:void(0)" data-audit-status="${dtl.auditStatus}" data-ajax="false" class="com_btn1 sl_tixian">
                <c:if test="${dtl.auditStatus == 1}">待审核</c:if>
                <c:if test="${dtl.auditStatus == 2}">审核通过</c:if>
            </a>
        </c:if>
        <c:if test="${dtl==null || dtl.auditStatus == 0 || dtl.auditStatus == 3}">
            <a style="margin-bottom: 5rem;" href="javascript:void(0)" data-audit-status="${dtl.auditStatus}" data-ajax="false" onclick="sub();" class="com_btn1 sl_tixian">
                <c:if test="${dtl.auditStatus == 3}">未通过</c:if>
                <c:if test="${dtl==null || dtl.auditStatus == 0}">提交</c:if>
            </a>
        </c:if>
    </div>

    <jsp:include page="/h5/foot.do?footId=4"></jsp:include>
</div>
</body>
<script type="text/javascript">
    function sub() {
        var formdata = $("#consumeDtlForm").serialize();
        var data = {};
        $.ajax({
            cache: false,
            type: "POST",
            url: "${pathWeb }/consumeDtl/save.do",
            data: formdata,
            async: false,
            error: function (request) {
                alert("系统繁忙，请稍后重试");
            },
            success: function (data) {
                if (data.code == "200") {
                    openPage("${pathWeb }/appointMent/list.do");
                }
            }
        });
    }

    function uploadImage() {
        var file = $("#attrUrl_file").val();
        if (file == "") {
            alert("请选择图片");
        }
        var formdata = new FormData();
        formdata.append('fileName', $('#attrUrl_file').get(0).files[0]);
        $.ajax({
            async: false,
            type: 'POST',
            url: "${pathWeb}/user/imageUpload",
            dataType: 'json',
            data: formdata,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#attrUrl_show").attr("style", "background-image:url(${pathWeb}/" + data.data + ")");
                $("#attrUrl").val(data.data);
            }
        });
    }
</script>
</html>