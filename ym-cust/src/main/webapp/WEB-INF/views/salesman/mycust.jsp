<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
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
										<dt>年龄:</dt>
										<dt>${custConsumer.consuAge }</dt><br/>
									</dl>
								</li>
								
								<li><dl>
										<dt>确定项目:</dt>
										<dt>${custConsumer.consuConfirmItem }</dt><br/>
									</dl>
								</li>
								<li>
								
									<dl>
										<dt>
											<p>
												创建时间: <b><span>${custConsumer.createTime }</span></b>
											</p>
										</dt><br/>
										
									</dl>
									
									
									
									</li>
									
									
																	<li>
								
									<dl>
										<dt>
											<p>
												年收入: <b><span>${custConsumer.consuIncome }</span></b>
											</p>
										</dt><br/>
										
										<dd style="float: right; margin-top: 0.3rem;">
											<div class="jnbtn">
												<a data-ajax="false" href="${pathWeb }/performance/consumerDetail.do?id=${custConsumer.id }">查看</a>
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
	
		</div>
</body>
</html>