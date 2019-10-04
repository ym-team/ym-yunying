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
            <span onclick="history.go(-1)"></span>顾客预约<em></em>
        </h3>
    </header>

    <div class="wd_con sl_wd_con">
    
    	<form action="" id="custConsumer">
    	<input type="hidden" id ="${param.id}" name="consuId" value="${param.id}"></hidden>
    	  	<input type="hidden" id ="${param.shopId}" name="shopId" value="${param.shopId}"></hidden>
    	
        <ul class="sl_czfs">

            <li class="sl_ji">
                <p>客人姓名</p>
                <div class="position-rel">
                    <input type="text" id="consuName" readonly="readonly" eadonly="readonly"name="consuName" class="form-control" style="width: 9rem;" placeholder="${custConsumer.consuName }" value="${custConsumer.consuName }">
                </div>
            </li>
            <li class="sl_ji">
                <p>客人电话</p>
                <div class="position-rel">
                    <input type="text" id="consuPhone" readonly="readonly" name="consuPhone" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuPhone }" value="${custConsumer.consuPhone }">
                </div>
            </li>
			<li class="sl_ji">
                    <p>预约美容院</p>
                    <div class="position-rel">
                    	<input type="hidden" id="consuYuYueHospital" name="consuYuYueHospital">
                        <input type="text" id="consuYuYueHospitalName" name="consuYuYueHospitalName" style="width: 9rem;" class="form-control"  placeholder="请选中">
                        <div class="bank_xljt">
                        	<img class="jt_xz" width="20" src="${configjscss }/images/jtx.png" alt="">
                        </div>
                        <div id="${not empty disabled ? disabled : 'chose_bank' }" class="bank_xljt1"></div>
                    </div>
                    <div class="bank_xl" style="display: none">
                        <ul>
                        	<c:forEach var="item" items="${listHospital}">
								<li class="hotBank-list sl_rji">
                              		<a href="javascript:" id="${item.id}" class="hotBank-list-ico2" title="${item.name}">${item.name}</a>
                            	</li>
							</c:forEach>
                        </ul>
                    </div>
                </li>
            <li class="sl_ji">
                <p>客人年龄</p>
                <div class="position-rel">
                    <input type="text" id="consuAge" readonly="readonly" name="consuAge" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuAge }" value="${custConsumer.consuAge }">
                </div>
            </li>
            <li class="sl_ji">
                <p>确定项目</p>
                <div class="position-rel">
                    <input type="text" id="consuConfirmItem" readonly="readonly" name="consuConfirmItem" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuConfirmItem }" value="${custConsumer.consuConfirmItem }">
                </div>
            </li>
            <li class="sl_ji">
                <p>意向项目</p>
                <div class="position-rel">
                    <input type="text" id="consuWanttoItem" readonly="readonly" name="consuWanttoItem" style="width: 9rem;" class="form-control" placeholder="${custConsumer.consuWanttoItem }" value="${custConsumer.consuWanttoItem }">
                </div>
            </li>
            
            
            
            
            
            
            
            
            
             
                
                
                 
            
                 
                  <li class="sl_ji">
                <p>预约时间</p>
                <div class="position-rel">
                    <input type="text" id="appointmentTime"  name="appointmentTime" style="width: 9rem;" class="form-control" placeholder="预约时间"  onclick="WdatePicker({isShowClear:false,readOnly:true})">
                </div>
            </li>
            
     		<li class="sl_ji">
                <p>接待员</p>
                <div class="position-rel">
                    <input type="text" id="jieDaiYuan" name="jieDaiYuan" style="width: 9rem;" class="form-control" placeholder="接待员">
                </div>
            </li>
        </ul>
        </form>
    </div>
    
        <div class="btn4">
        <a style="margin-bottom: 1.6rem;" href="javascript:void(0)" onclick="sub();" class="com_btn1 sl_tixian">确认</a>
    </div>

    <jsp:include page="/foot.do?footId=4"></jsp:include>
</div>
</body>
<script type="text/javascript">
$(function(){
    $(".hotBank-list-ico2").bind('click',function(){
        $('#consuYuYueHospitalName').val($(this).attr('title'));
        $('#consuYuYueHospital').val($(this).attr('id'));
       
        $('.bank_xl').hide();
        $("#chose_bank").parent('div').find('img').addClass('jt_xz');
    });
    $("#chose_bank").click(function(){
        $('.bank_xl').show();
        $("#chose_bank").parent('div').find('img').removeClass('jt_xz');
    });
})
  
</script>

<script type="text/javascript">
    function sub() {
    	
	    var formdata = $("#custConsumer").serialize();

		//JSON.stringify(formdata)
		
        var data = {};
        $.ajax({
            cache: false,
            type: "POST",
            url: "${pathWeb }/appointMent/add.do",
            data: formdata,
            async: false,
            error: function (request) {
                alert("系统繁忙，请稍后重试");
            },
            success: function (data) {
                if (data.code == "200") {
                    //window.location.reload();
                	 openPage("${pathWeb }/appointMent/list.do");
                }
            }
        });
    }
</script>

<script>
    if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
        var msViewportStyle = document.createElement('style')
        msViewportStyle.appendChild(
                document.createTextNode(
                        '@-ms-viewport{width:auto!important}'
                )
        )
        document.querySelector('head').appendChild(msViewportStyle)
    }
</script>
</html>