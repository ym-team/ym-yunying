<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"> 
<title>我的-预约客户</title>
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
			<span onclick="history.go(-1)"></span>我的预约客户<em></em>
		</h3>
	</header>
	
	 <c:forEach items="${listCustAppointment}" var="custAppointment" varStatus="index">
			<div class="jtag">
				<div class="taglist" id="borrowContent1">
					<div class="jlc-morelist">
						<div class="jlc-mlcon clearfix">
							<ol>
								<li><span>${index.count }</span></li>
								<li><p>${custAppointment.consuName }</p></li>
							</ol>
							<ul>
								<li><dl>
										<dt>年龄:</dt>
										<dt>${custAppointment.consuPhone }</dt><br/>
									</dl>
								</li>
								
								<li><dl>
										<dt>确定项目:</dt>
										<dt>${custAppointment.consuConfirmItem }</dt><br/>
									</dl>
								</li>
								
																
								<li><dl>
										<dt>预约医院:</dt>
										<dt>${custAppointment.consuYuYueHospital }</dt><br/>
									</dl>
								</li>
								
								
								<li><dl>
										<dt>接待员:</dt>
										<dt>${custAppointment.jieDaiYuan }</dt><br/>
									</dl>
								</li>
								
								
								
								<li>
								
									<dl>
										<dt>
											<p>
												预约时间: <b><span> <fmt:formatDate value="${custAppointment.appointmentTime}" pattern="yyyy-MM-dd" /> </span></b>
											</p>
										</dt><br/>
										
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