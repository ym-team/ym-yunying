<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
<title>我的-店面</title>
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
<body>



	<div class="ui-page ui-page-theme-a ui-page-active" data-role="page"
		style="background: #eff2f7;">
		<header class="jwytz-header">
		<h3>
			<span onclick="history.go(-1)"></span>店面列表<em></em>
		</h3>
	</header>
	 
		
		  <div class="hd-nrk">
			 
			<div class="wdlc-nrk">
				<div class="wdlc-lisat" style="display: block;" id="accountContent"></div>
			</div>
			<jsp:include page="/foot.do?footId=4"></jsp:include>
		</div>
</body>


<script type="text/javascript">
	var pageNum = 0;
	var data = {};

	$(document).ready(function() {
		loadPage();
	});

	function loadPage() {
		pageNum++;
		data.pageNum = pageNum;
		openAjax('${pathWeb}/business/custshop/storeList.do', data,
				generateCallback);
	}

	 
	function generateCallback(data) {
		var jsonResult = data;
		var accountHtml = '';
		if (jsonResult.length > 0) {
			$.each(jsonResult,
							function(i, custShop) { 
				var href = '<a rel="external" href="javascript:void(0)" onclick="queryDtl(\''+custShop.id+'\')">';
				var hrefend ='</a>';
				var shopXieyiStatus  ="";
				switch (custShop.shopXieyiStatus) {
				case 1:
					shopXieyiStatus ='已签约'
					break;
				case 2:
					shopXieyiStatus = '未签约'
					break;
				case 3 :
					shopXieyiStatus = "作废";
					break;
				}
			accountHtml += href
					+'<div class="wdlc-listd"><h2>'
					+ '</h2><dl><dd>店面名称</dd><dd>负责人</dd><dd>手机号码</dd><dd>签约状态</dd><dt>'
					+ custShop.shopName
					+ '</dt><dt>'
					+ custShop.shopUserName
					+ '</dt><dt>'
					+ custShop.shopPhone
					
					+ '</dt><dt>'
					+shopXieyiStatus
					+ '</dt></dl></div>'
					+hrefend;
							});
			$("#accountContent").append(accountHtml);
		} else {
			$("#pageDiv").find("a").addClass("ui-state-disabled");
			$.alert("暂无数据");
		}
	}
	
	function queryDtl(obj){
		openPage("${pathWeb }/business/custshop/queryCustShopDtlById?id="+obj);
	}
</script>
</html>