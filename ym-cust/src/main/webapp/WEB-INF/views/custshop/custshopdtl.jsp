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
			<span onclick="history.go(-1)"></span>店面入驻<em></em>
		</h3>
	</header>

	<div class="wd_con sl_wd_con">
		<ul class="sl_czfs">
			<li class="sl_ji">
				<p>店面名称</p>
				<div class="position-rel">
				<span>${custShop.shopName }</span>
				</div>
			</li>
			<li class="sl_ji">
				<p>地址</p>
				<div class="position-rel">
				<span>${custShop.shopAddress }</span>
				</div>
			</li>
			<li class="sl_ji">
				<p>联系人</p>
				<div class="position-rel">
					 <span>${custShop.shopUserName }</span>
				</div>
			</li>
			<li class="sl_ji">
				<p>联系电话</p>
				<div class="position-rel">
				 <c:set value="${fn:length(custShop.shopPhone)}" var="phoneLen"/>
				 <span>${fn:substring(custShop.shopPhone,0,3)}****${fn:substring(custShop.shopPhone,phoneLen-4,phoneLen)}</span>
				</div>
			</li>
			<li class="sl_ji">
				<p>联系人证件号</p>
				<div class="position-rel">
				 <c:set value="${fn:length(custShop.shopIdCard)}" var="cardNumberLen"/>
				 <span>${fn:substring(custShop.shopIdCard,0,4)}****${fn:substring(custShop.shopIdCard,14,cardNumberLen)}</span>
					 
				</div>
				
			</li>
		</ul>
		 
	</div>
	<div class="wdlc-nrk">
				<div class="wdlc-lisat" style="display: block;"></div>
			</div>
	<jsp:include page="/foot.do?footId=3"></jsp:include>
</div>
</body> 
</html>