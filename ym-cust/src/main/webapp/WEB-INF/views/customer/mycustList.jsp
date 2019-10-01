<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
<!-- 店家查看 -->
<title>我的-客户</title>
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
		
		<div class="xq_con">
			<header class="jwytz-header">
		<h3>
			<span onclick="history.go(-1)"></span>我的客户<em></em>
		</h3>
	</header>
	
	
	 <c:forEach items="${listCustConsumer}" var="custConsumer" varStatus="index">
		<div class="jtag">
				<div class="taglist" id="borrowContent1">
					<div class="jlc-morelist">
					
						<div class="jlc-mlcon clearfix">
							<ol>
								<li><span>${index.count }</span></li>
								<li><p>${custConsumer.consuName }</p></li>
							</ol>
							<ul>
								<li><dl>
										<dt>确定项目</dt>
										<dd style="float: right; ">${custConsumer.consuConfirmItem}</dd>
									</dl></li>
								<li>
								
									<dl>
										<dt>
											<p>
												创建时间 <b><span>
												<fmt:formatDate value="${custConsumer.createTime}" pattern="yyyy-MM-dd" />
												</span></b>
											</p>
											<p>
												<p>
												年收入 <b><span>${custConsumer.consuIncome}
											</p>
										</dt>
										<dd style="float: right; margin-top: 0.3rem;">
											<div class="jnbtn">
												<a data-ajax="false" href="${pathWeb }/customer/customerDetail.do?id=${custConsumer.id}">查看</a>
											</div>
										</dd>
									</dl>
									</li>
							</ul>
						</div>
					</div>
				</div>
			</div>	 
	 </c:forEach>
	
	
			

			 

			<%-- <div class="jtag">
				<div class="taglist" id="borrowContent1">
					<div class="jlc-morelist">
						<div class="jlc-mlcon clearfix">
							<ol>
								<li><span>3</span></li>
								<li><p>王五</p></li>
							</ol>
							<ul>
								<li><dl>
										<dt>级别</dt>
										<dd>
											<div class="jjd-w">
												<div class="jjd-n" style="width: 0%;"></div>
											</div>
										</dd>
										<dd>美业老师</dd>
									</dl></li>
								<li><dl>
										<dt>
											<p>
												加入时间 <b><span>2019-08-06</span></b>
											</p>
											<p>
												个人业绩 <b>100单</b>
											</p>
												<p>
												进行中
											</p>
										</dt>
										<dd style="float: right; margin-top: 0.3rem;">
											<div class="jnbtn">
												<a data-ajax="false" href="${pathWeb }/customer/detail.do">查看</a>
											</div>
										</dd>
									</dl></li>
							</ul>
						</div>
					</div>
				</div>
			</div> --%>
			<div class="wdlc-nrk">
				<div class="wdlc-lisat" style="display: block;" id="accountContent"></div>
			</div>
		</div>
</body>
</html>