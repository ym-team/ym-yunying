<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>我的</title>
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
	<div class="ui-page ui-page-theme-a ui-page-active" data-role="page">
	<header class="jwytz-header">
			<h3>
				<span onclick="history.go(-1)"></span>我的业绩<em></em>
			</h3>
		</header>
		<div class="wd_con sl_wd_con1">
			<div class="sl_zhzl">
				<img class="sl_zhzl5" src="${configjscss }/images/wdzh_07.png" alt=""> <img
					src="${configjscss }/images/wdzh_06.png" alt="">
				<ul class="sl_kyye">
					<li>我的业绩<span id="MyMoney"><fmt:formatNumber value="" pattern="#,##0.00" />元</span>
					</li>
					</li>
					<li>本月成交量<span id="myOrderCount"></span>
					</li>
					<li>本月工资 <span><fmt:formatNumber value="0" pattern="#,##0.00" />元</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
	
	
		<script type="text/javascript">
		$(document).ready(function() {
			
	        $.ajax({
	            cache: false,
	            type: "GET",
	            url: "${pathWeb }/myMoney/myMoney.do",
	            data: {},
	            async: false,
	            error: function (request) {
	                alert("系统繁忙，请稍后重试");
	            },
	            success: function (data) {
	                if (data.code == "200") {
	                    //window.location.reload();
	                	 //openPage("${pathWeb }/appointMent/list.do");
	                	 $("#MyMoney").text(data.data+"元");
	                }
	            }
	        });
	        
	        $.ajax({
	            cache: false,
	            type: "GET",
	            url: "${pathWeb }/myMoney/myOrder.do",
	            data: {},
	            async: false,
	            error: function (request) {
	                alert("系统繁忙，请稍后重试");
	            },
	            success: function (data) {
	                if (data.code == "200") {
	                    //window.location.reload();
	                	// openPage("${pathWeb }/appointMent/list.do");
	               	 $("#myOrderCount").text(data.data+"单");
	                }
	            }
	        });
	
		});
	</script>
	
	
</body>
</html>