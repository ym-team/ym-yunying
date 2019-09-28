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
	<div class="ui-page ui-page-theme-a ui-page-active" data-role="page"
		style="background: #fff;">
		<div class="wd_con">
			<div class="phone_con">
				<p class="phone">您好！${realName }</p>
				<span><fmt:formatNumber
						value="${totalMoney }"
						pattern="#,##0.00" /></span>
				<p></p>
			</div>
			
			<div class="sl_cz9">
				<a rel="external" data-ajax="false" href="${pathWeb }/index.do" class="com_btn5 ">立即邀请</a> <a
					rel="external" data-ajax="false" href="${pathWeb }/backMoney/backMoneyListView" class="com_btn5 col">我的服务</a>
			</div>
			
			<div class="list_con">
				<ul>
					<li><a rel="external"
						href="${pathWeb }/user/userInfoView.do">
							<div class="pic">
								<img src="${configjscss }/images/sfxx.png">
							</div> <span>身份信息</span>
					</a></li>
					<li><a rel="external"
						href="${pathWeb }/performance/teamView.do">
							<div class="pic">
								<img src="${configjscss }/images/wdtd.png">
							</div> <span>我的团队</span>
					</a></li>
					<li><a rel="external"
						href="${pathWeb }/performance/performanceView.do" class="zc_pic">
							<div class="pic">
								<img src="${configjscss }/images/yj.png">
							</div> <span>我的业绩</span>
					</a></li>
					<li><a rel="external"
						href="${pathWeb }/business/custshop/queryCustomerListView.do">
							<div class="pic">
								<img src="${configjscss }/images/gk.png">
							</div> <span>我的店家</span>
					</a></li>
					<li><a rel="external"
						href="${pathWeb }/performance/myCustView.do">
							<div class="pic">
								<img src="${configjscss }/images/dm.png">
							</div> <span>我的客户</span>
					</a></li>
					<li><a rel="external"
						href="${pathWeb }/user/userCode.do" class="zc_pic">
							<div class="pic">
								<img src="${configjscss }/images/ewm.png">
							</div> <span>我的二维码</span>
					</a></li>
					
					<li><a rel="external"
						href="${pathWeb }/logout.do" class="zc_pic">
							<div class="pic">
								<img src="${configjscss }/images/tc.png">
							</div> <span>退出</span>
					</a></li> 
					
					<li><a rel="external"
						href="${pathWeb }/user/materialsView.do" class="zc_pic">
							<div class="pic">
								<img src="${configjscss }/images/sj.png">
							</div> <span>我要升级</span>
					</a></li>
				</ul>
			</div>

		</div>
		<!--gd_con-->
		<jsp:include page="/foot.do?footId=4"></jsp:include>
	</div>
<script type="text/javascript">
if("${message}"){
	alert("${message}");
}
</script>
</body>
</html>