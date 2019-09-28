<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title></title>
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<%@include file="../taglibs.jsp"%>
</head>

<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
	<header class="jwytz-header">
		<h3>
			<span onclick="history.go(-1)"></span>店面信息<em></em>
		</h3>
	</header>

	<div class="wd_con sl_wd_con">
		<ul class="sl_czfs">
			<li class="sl_ji">
				<p>店面名称</p>
				<div class="position-rel">
					<input type="text" class="form-control" style="width: 9rem;" id="shopName" name="shopName"
						placeholder="请输入店门名称">
				</div>
			</li>
			<li class="sl_ji">
				<p>地址</p>
				<div class="position-rel">
					<input type="text" class="form-control" style="width: 9rem;" id="shopAddress" name="shopAddress"
						placeholder="请输入店门地址">
				</div>
			</li>
			<li class="sl_ji">
				<p>联系人</p>
				<div class="position-rel">
					<input type="text" class="form-control" style="width: 9rem;" id="shopUserName" name="shopUserName"
						placeholder="请输入联系人姓名">
				</div>
			</li>
			<li class="sl_ji">
				<p>联系电话</p>
				<div class="position-rel">
					<input type="text" style="width: 9rem;" class="form-control" id="shopPhone" name="shopPhone"
						placeholder="请输入联系人电话">
				</div>
			</li>
			<li class="sl_ji">
				<p>联系人证件号</p>
				<div class="position-rel">
					<input type="text" style="width: 9rem;" class="form-control" id="shopIdCard" name="shopIdCard"
						placeholder="请输入证件号码">
				</div>
				
			</li>
		</ul>
		<div class="forget">
			<p>
				我已阅读并同意<a rel="external" href="${pathWeb }/getProtocol.do">《入驻协议及隐私条款》</a>
			</p>
		</div>
	</div>
	<div class="btn4">
	
	<!-- 
		<a style="margin-bottom: 5rem;" href="javascript:void(0)"
			onclick="sub();" class="com_btn1 sl_tixian">确认</a> -->
			
			
		<a style="margin-bottom: 5rem;" href="${pathWeb }/business/store/StoreRegister.do"
			class="com_btn1 sl_tixian">确认</a>
			
			
	</div>
	<jsp:include page="/h5/foot.do?footId=4"></jsp:include>
</div>
</body>
<script type="text/javascript">
	function sub(){
		var shopName = $("#shopName").val();
        var shopAddress = $("#shopAddress").val();
        var shopUserName = $("#shopUserName").val();
        var shopIdCard = $("#shopIdCard").val();
        var shopPhone = $("#shopPhone").val();
		 var data = {
				 "shopName": shopName,
	                "shopAddress": shopAddress,
	                "shopUserName": shopUserName,
	                "shopIdCard": shopIdCard,
	                "shopPhone": shopPhone
		  };
		  $.ajax({
				cache : false,
				type : "POST",
				url : "${pathWeb }/business/store/saveEnter.do",
				data : data,
				async : false,
				error : function(request) {
					alert("系统繁忙，请稍后重试");
				},
				success : function(data) {
					if(data.code == "200"){
						window.location.reload();
					}
				}
			});
	}
</script>
</html>