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
        <div class="sfzwrap prel" style="background-image: url('${configjscss }/images/imgs/uppic1.png');">
            <div class="phoes" id="mode1" class="uploader-list">
                <input type="file" id="choose" accept="image/*" multiple/>
                <input type="hidden" id="sfzzm" name="sfzzm"/>
                <ul class="img-list"></ul>
                <div class="hcamera pab" id="upload">
                    <img src="${configjscss }/images/imgs/hcamera.png" alt="">
                </div>
                <div class="sfztip pab">身份证正面照扫描上传</div>
            </div>
        </div>

        <!-- pho fm -->
        <div class="sfzwrap prel" style="background-image: url('${path }${saleMan.sfzFm }');">
            <div class="sfzwrap prel" style="background-image: url('${configjscss }/images/imgs/uppic2.png');">
                <div class="phoes" id="mode2" class="uploader-list">
                    <ul class="img-listfm"></ul>
                    <input type="file" id="choosefm"/>
                    <input type="hidden" id="sfzfm" name="sfzfm"/>
                    <div class="hcamera pab" id="uploadfm">
                        <img src="${configjscss }/images/imgs/hcamera.png" alt="">
                    </div>
                    <div class="sfztip pab">身份证反面照扫描上传</div>
                </div>
            </div>

            <!-- pho sc-->
            <div class="sfzwrap prel h130" style="background-image: url('${path }${saleMan.sfzSc }');">
                <div class="sfzwrap prel h130" style="background-image: url('${configjscss }/images/imgs/uppic3.png');">
                    <div class="phoes" id="mode3" class="uploader-list">
                        <input type="hidden" id="sfz_sc"/>
                        <input type="hidden" id="sfzsc" name="sfzsc"/>
                        <ul class="img-listsc"></ul>
                        <div style="display: none;">
                            <input type="file" id="choosesc"/>
                        </div>
                        <div class="hcamera pab" id="uploadsc">
                            <img src="${configjscss }/images/imgs/hcamera.png" alt="">
                        </div>
                        <div class="sfztip pab">手持身份证照扫描上传</div>
                    </div>
                </div>

                <div class="btn4">
                    <a href="javascript:;" onclick="sub();" data-audit-status="${saleMan.auditStatus}" data-ajax="false" class="com_btn1 sl_tixian">
                        <c:if test="${saleMan.auditStatus == 1}">认证通过</c:if>
                        <c:if test="${saleMan.auditStatus == 2}">提交</c:if>
                        <c:if test="${saleMan.auditStatus == 3}">认证不通过</c:if>
                        <c:if test="${saleMan.auditStatus == 4}">待审核</c:if>
                    </a>
                </div>
            </div>
            <br>
            <br>
            <jsp:include page="foot.do?footId=4"></jsp:include>
        </div>

        <script>
            var filechooser = document.getElementById("choose");
            var filechooserfm = document.getElementById("choosefm");
            var filechoosersc = document.getElementById("choosesc");
            //    用于压缩图片的canvas
            var canvas = document.createElement("canvas");
            var ctx = canvas.getContext('2d');
            //    瓦片canvas
            var tCanvas = document.createElement("canvas");
            var tctx = tCanvas.getContext("2d");
            var maxsize = 100 * 1024;
            $("#upload").on("click", function () {
                filechooser.click();
            }).on("touchstart", function () {
                $(this).addClass("touch")
            }).on("touchend", function () {
                $(this).removeClass("touch")
            });
            filechooser.onchange = function () {
                if (!this.files.length) return;
                var files = Array.prototype.slice.call(this.files);
                if (files.length > 1) {
                    alert("最多同时只可上传9张图片");
                    return;
                }
                files.forEach(function (file, i) {
                    if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
                    var reader = new FileReader();
                    var li = document.createElement("li");
//          获取图片大小
                    var size = file.size / 1024 > 1024 ? (~~(10 * file.size / 1024 / 1024)) / 10 + "MB" : ~~(file.size / 1024) + "KB";
                    li.innerHTML = '<div class="progress"><span></span></div><div class="size">' + size + '</div>';
                    $(".img-list").append($(li));

                    reader.onload = function () {
                        var result = this.result;
                        var img = new Image();
                        img.src = result;
                        $(li).css("background-image", "url(" + result + ")");
                        //如果图片大小小于100kb，则直接上传
                        if (result.length <= maxsize) {
                            img = null;
                            upload(result, file.type, $(li));
                            return;
                        }
//      图片加载完毕之后进行压缩，然后上传
                        if (img.complete) {
                            callback();
                        } else {
                            img.onload = callback;
                        }

                        function callback() {
                            var data = compress(img);
                            upload(data, file.type, $(li));
                            data = data.replace(/^data:image\/\w+;base64,/, "");
                            var data = {
                                "filepath": data,
                                "suffix": file.type,
                                "fileImagePrType": 'zm'
                            };
                            $.ajax({
                                cache: false,
                                type: "POST",
                                url: "${pathWeb}/user/upload/testUploadmore",
                                data: data,
                                async: false,
                                error: function (request) {

                                },
                                success: function (data) {
                                    $("#sfzzm").val(data);
                                }
                            });


                            img = null;
                        }
                    };
                    reader.readAsDataURL(file);
                })
            };


            $("#uploadfm").on("click", function () {
                filechooserfm.click();
            })
                .on("touchstart", function () {
                    $(this).addClass("touch")
                })
                .on("touchend", function () {
                    $(this).removeClass("touch")
                });
            filechooserfm.onchange = function () {
                if (!this.files.length) return;
                var files = Array.prototype.slice.call(this.files);
                if (files.length > 9) {
                    alert("最多同时只可上传9张图片");
                    return;
                }
                files.forEach(function (file, i) {
                    if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
                    var reader = new FileReader();
                    var li = document.createElement("li");
//	          获取图片大小
                    var size = file.size / 1024 > 1024 ? (~~(10 * file.size / 1024 / 1024)) / 10 + "MB" : ~~(file.size / 1024) + "KB";
                    li.innerHTML = '<div class="progress"><span></span></div><div class="size">' + size + '</div>';
                    $(".img-listfm").append($(li));
                    reader.onload = function () {
                        var result = this.result;
                        var img = new Image();
                        img.src = result;
                        $(li).css("background-image", "url(" + result + ")");
                        //如果图片大小小于100kb，则直接上传
                        if (result.length <= maxsize) {
                            img = null;
                            upload(result, file.type, $(li));
                            return;
                        }
//	      图片加载完毕之后进行压缩，然后上传
                        if (img.complete) {
                            callback();
                        } else {
                            img.onload = callback;
                        }

                        function callback() {
                            var data = compress(img);
                            upload(data, file.type, $(li));
                            data = data.replace(/^data:image\/\w+;base64,/, "");
                            var data = {
                                "filepath": data,
                                "suffix": file.type,
                                "fileImagePrType": 'fm'
                            };
                            $.ajax({
                                cache: false,
                                type: "POST",
                                url: "${pathWeb}/user/upload/testUploadmore",
                                data: data,
                                async: false,
                                error: function (request) {

                                },
                                success: function (data) {
                                    $("#sfzfm").val(data);
                                }
                            });


                            img = null;
                        }
                    };
                    reader.readAsDataURL(file);
                })
            };


            $("#uploadsc").on("click", function () {
                filechoosersc.click();
            })
                .on("touchstart", function () {
                    $(this).addClass("touch")
                })
                .on("touchend", function () {
                    $(this).removeClass("touch")
                });
            filechoosersc.onchange = function () {
                if (!this.files.length) return;
                var files = Array.prototype.slice.call(this.files);
                if (files.length > 9) {
                    alert("最多同时只可上传9张图片");
                    return;
                }
                files.forEach(function (file, i) {
                    if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
                    var reader = new FileReader();
                    var li = document.createElement("li");
//		          获取图片大小
                    var size = file.size / 1024 > 1024 ? (~~(10 * file.size / 1024 / 1024)) / 10 + "MB" : ~~(file.size / 1024) + "KB";
                    li.innerHTML = '<div class="progress"><span></span></div><div class="size">' + size + '</div>';
                    $(".img-listsc").append($(li));
                    reader.onload = function () {
                        var result = this.result;
                        var img = new Image();
                        img.src = result;
                        $(li).css("background-image", "url(" + result + ")");
                        //如果图片大小小于100kb，则直接上传
                        if (result.length <= maxsize) {
                            img = null;
                            upload(result, file.type, $(li));
                            return;
                        }
//		      图片加载完毕之后进行压缩，然后上传
                        if (img.complete) {
                            callback();
                        } else {
                            img.onload = callback;
                        }

                        function callback() {
                            var data = compress(img);
                            upload(data, file.type, $(li));
                            data = data.replace(/^data:image\/\w+;base64,/, "");
                            var data = {
                                "filepath": data,
                                "suffix": file.type,
                                "fileImagePrType": 'sc'
                            };
                            $.ajax({
                                cache: false,
                                type: "POST",
                                url: "${pathWeb}/user/upload/testUploadmore",
                                data: data,
                                async: false,
                                error: function (request) {

                                },
                                success: function (data) {
                                    $("#sfzsc").val(data);
                                }
                            });


                            img = null;
                        }
                    };
                    reader.readAsDataURL(file);
                })
            };


            //    使用canvas对大图片进行压缩
            function compress(img) {
                var initSize = img.src.length;
                var width = img.width;
                var height = img.height;
                //如果图片大于四百万像素，计算压缩比并将大小压至400万以下
                var ratio;
                if ((ratio = width * height / 4000000) > 1) {
                    ratio = Math.sqrt(ratio);
                    width /= ratio;
                    height /= ratio;
                } else {
                    ratio = 1;
                }
                canvas.width = width;
                canvas.height = height;
//        铺底色
                ctx.fillStyle = "#fff";
                ctx.fillRect(0, 0, canvas.width, canvas.height);
                //如果图片像素大于100万则使用瓦片绘制
                var count;
                if ((count = width * height / 1000000) > 1) {
                    count = ~~(Math.sqrt(count) + 1); //计算要分成多少块瓦片
//            计算每块瓦片的宽和高
                    var nw = ~~(width / count);
                    var nh = ~~(height / count);
                    tCanvas.width = nw;
                    tCanvas.height = nh;
                    for (var i = 0; i < count; i++) {
                        for (var j = 0; j < count; j++) {
                            tctx.drawImage(img, i * nw * ratio, j * nh * ratio, nw * ratio, nh * ratio, 0, 0, nw, nh);
                            ctx.drawImage(tCanvas, i * nw, j * nh, nw, nh);
                        }
                    }
                } else {
                    ctx.drawImage(img, 0, 0, width, height);
                }
                //进行最小压缩
                var ndata = canvas.toDataURL('image/jpeg', 0.1);
                console.log('压缩前：' + initSize);
                console.log('压缩后：' + ndata.length);
                console.log('压缩率：' + ~~(100 * (initSize - ndata.length) / initSize) + "%");
                tCanvas.width = tCanvas.height = canvas.width = canvas.height = 0;
                return ndata;
            }

            //    图片上传，将base64的图片转成二进制对象，塞进formdata上传
            function upload(basestr, type, $li) {
                var text = window.atob(basestr.split(",")[1]);
                var buffer = new Uint8Array(text.length);
                var pecent = 0, loop = null;
                for (var i = 0; i < text.length; i++) {
                    buffer[i] = text.charCodeAt(i);
                }
                var blob = getBlob([buffer], type);
                var xhr = new XMLHttpRequest();
                var formdata = getFormData();
                formdata.append('imagefile', blob);
                xhr.open('post', '/cupload');
                xhr.onreadystatechange = function () {
                    if (xhr.readyState == 4 && xhr.status == 200) {
                        var jsonData = JSON.parse(xhr.responseText);
                        var imagedata = jsonData[0] || {};
                        var text = imagedata.path ? '上传成功' : '上传失败';
                        console.log(text + '：' + imagedata.path);
                        clearInterval(loop);
                        //当收到该消息时上传完毕
                        $li.find(".progress span").animate({'width': "100%"}, pecent < 95 ? 200 : 0, function () {
                            $(this).html(text);
                        });
                        if (!imagedata.path) return;
                        $(".pic-list").append('<a href="' + imagedata.path + '">' + imagedata.name + '（' + imagedata.size + '）<img src="' + imagedata.path + '" /></a>');
                    }
                };
                //数据发送进度，前50%展示该进度
                xhr.upload.addEventListener('progress', function (e) {
                    if (loop) return;
                    pecent = ~~(100 * e.loaded / e.total) / 2;
                    $li.find(".progress span").css('width', pecent + "%");
                    if (pecent == 50) {
                        mockProgress();
                    }
                }, false);

                //数据后50%用模拟进度
                function mockProgress() {
                    if (loop) return;
                    loop = setInterval(function () {
                        pecent++;
                        $li.find(".progress span").css('width', pecent + "%");
                        if (pecent == 99) {
                            clearInterval(loop);
                        }
                    }, 100)
                }

                xhr.send(formdata);
            }

            /**
             * 获取blob对象的兼容性写法
             * @param buffer
             * @param format
             * @returns {*}
             */
            function getBlob(buffer, format) {
                try {
                    return new Blob(buffer, {type: format});
                } catch (e) {
                    var bb = new (window.BlobBuilder || window.WebKitBlobBuilder || window.MSBlobBuilder);
                    buffer.forEach(function (buf) {
                        bb.append(buf);
                    });
                    return bb.getBlob(format);
                }
            }

            /**
             * 获取formdata
             */
            function getFormData() {
                var isNeedShim = ~navigator.userAgent.indexOf('Android')
                    && ~navigator.vendor.indexOf('Google')
                    && !~navigator.userAgent.indexOf('Chrome')
                    && navigator.userAgent.match(/AppleWebKit\/(\d+)/).pop() <= 534;
                return isNeedShim ? new FormDataShim() : new FormData()
            }

            /**
             * formdata 补丁, 给不支持formdata上传blob的android机打补丁
             * @constructor
             */
            function FormDataShim() {
                console.warn('using formdata shim');
                var o = this,
                    parts = [],
                    boundary = Array(21).join('-') + (+new Date() * (1e16 * Math.random())).toString(36),
                    oldSend = XMLHttpRequest.prototype.send;
                this.append = function (name, value, filename) {
                    parts.push('--' + boundary + '\r\nContent-Disposition: form-data; name="' + name + '"');
                    if (value instanceof Blob) {
                        parts.push('; filename="' + (filename || 'blob') + '"\r\nContent-Type: ' + value.type + '\r\n\r\n');
                        parts.push(value);
                    }
                    else {
                        parts.push('\r\n\r\n' + value);
                    }
                    parts.push('\r\n');
                };
                // Override XHR send()
                XMLHttpRequest.prototype.send = function (val) {
                    var fr,
                        data,
                        oXHR = this;
                    if (val === o) {
                        // Append the final boundary string
                        parts.push('--' + boundary + '--\r\n');
                        // Create the blob
                        data = getBlob(parts);
                        // Set up and read the blob into an array to be sent
                        fr = new FileReader();
                        fr.onload = function () {
                            oldSend.call(oXHR, fr.result);
                        };
                        fr.onerror = function (err) {
                            throw err;
                        };
                        fr.readAsArrayBuffer(data);
                        // Set the multipart content type and boudary
                        this.setRequestHeader('Content-Type', 'multipart/form-data; boundary=' + boundary);
                        XMLHttpRequest.prototype.send = oldSend;
                    }
                    else {
                        oldSend.call(this, val);
                    }
                };
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
                var cardNum = $("#cardNum").val();
                if (cardNum == "" || cardNum == null) {
                    alert("身份证号不能为空");
                    return;
                }

                //检查
                var cardNoInfo = getIdCardInfo(cardNum);
                if (!cardNoInfo.isTrue) {
                    alert("身份证号格式错误.");
                    return;
                }
                var sfzzm = $("#sfzzm").val();
                var sfzfm = $("#sfzfm").val();
                var sfzsc = $("#sfzsc").val();
                if (sfzzm == '' || sfzfm == '' || sfzsc == '') {
                    alert("请上传相关证件！");
                    return;
                }

                var data = {
                    "realName": realName,
                    "cardNum": cardNum,
                    "sfzzm": sfzzm,
                    "sfzfm": sfzfm,
                    "sfzsc": sfzsc
                };
                $.ajax({
                    cache: false,
                    type: "POST",
                    url: "${pathWeb}/user/realNameAttestation.do",
                    data: data,
                    async: false,
                    error: function (request) {
                        alert("系统繁忙，请稍后重试");
                    },
                    success: function (data) {
                        if (data.code == "100") {
                            alert(data.msg);
                            window.location.href = "${pathWeb}/user/bandMobileView.do";
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