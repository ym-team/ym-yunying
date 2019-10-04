<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>业务员</title>
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<%@include file="../taglibs.jsp"%>
<style type="text/css">
.my_yeji_content {
	padding: 18px;
	font-size: 16px;
	background: #fff;
	margin-top: 6px;
}

.my_yeji_content .item span {
	padding-left: 12px;
}

.xinzeng_kehu {
	display: flex;
	background: #fff;
	padding: 12px 0;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.xinzeng_kehu .item {
	flex: 1;
	text-align: center;
	font-size: 16px;
}

.xinzeng_kehu .item.hasborder {
	border-right: 1px solid #ccc;
}

.xinzeng_kehu .item .p2 {
	padding-top: 6px;
	font-size: 14px;
}

.store_list {
	display: flex;
	margin-top: 24px;
}

.store_list .avathr {
	width: 80px;
	height: 80px;
}

.store_list .avathr img {
	width: 100%;
	height: 100%;
}

.store_list .list_right {
	flex: 1;
}

.detail_title {
	margin-top: 0.5rem;
	font-weight: bold;
	padding-left: 12px;
	font-size: 16px;
	over-flow: hidden;
}

.detail_title .more {
	float: right;
	padding-right: 24px;
}
</style>
</head>
<body>
	<div class="my_yeji_content">
		<div class="item">
			<label>我的业绩:</label><span>190000</span>
		</div>
		<div class="item">
			<label>本月成交量:</label><span>180单</span>
		</div>
	</div>
	<div class="xinzeng_kehu">
		<div class="item hasborder">
			<a>
				<P class="p1">最近新增店面</P>
				<p class="p2">3人</p>
			</a>
		</div>
		<div class="item">
			<P class="p1">预约顾客</P>
			<p class="p2">5人</p>
		</div>
	</div>

	<div class="xq_con">
		<dl class="jtagtit clearfix">
		<dd class="cur">顾客列表</dd>
			<dd >店铺列表</dd>
		</dl>
		<div class="jtag">
		
		<div class="taglist" id="borrowContent1" >
		
		
		
		<c:forEach items="${listCustConsumer}" var="custConsumer" varStatus="index">
		
				<div class="jlc-morelist">
					<h3>${custConsumer.consuConfirmItem }</h3>
					<div class="jlc-mlcon clearfix">
						<ol>
							<li><span>${custConsumer.consuValue }￥</span></li>
							<li><p>${custConsumer.remark }</p></li>
						</ol>
						<ul>
							<li>
								<dl>
									<dt>变美进度</dt>
									<dd>
										<div class="jjd-w">
											<div class="jjd-n" style="width: 0%;"></div>
										</div>
									</dd>
									<dd>0%</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>
										<p>
											联系人 <b>${custConsumer.consuName }</b>
										</p>
										<p>
											联系电话 <b>${custConsumer.consuPhone }</b>
										</p>
									</dt>
									<dd style="float: right; margin-top: 0.3rem;">
										<div class="jnbtn">
											<a href="投资-投资详情.html">未预约</a>
										</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
				</c:forEach>
				<!-- <div class="jlc-morelist">
					<h3>这个是顾客咨询的项目信息</h3>
					<div class="jlc-mlcon clearfix">
						<ol>
							<li><span>1990</span></li>
							<li><p>xxx店铺老板</p></li>
						</ol>
						<ul>
							<li>
								<dl>
									<dt>变美进度</dt>
									<dd>
										<div class="jjd-w">
											<div class="jjd-n" style="width: 30%;"></div>
										</div>
									</dd>
									<dd>30%</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>
										<p>
											联系人 <b>张三</b>
										</p>
										<p>
											联系电话 <b>18028081307</b>
										</p>
									</dt>
									<dd style="float: right; margin-top: 0.3rem;">
										<div class="jnbtn">
											<a href="投资-投资详情.html">预约中</a>
										</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div> -->
			</div>
		
			<div class="taglist" id="borrowContent2" style="display: none">
				<div class="jlc-morelist">
					<h3>深圳市罗湖区xxx街道110号</h3>
					<div class="jlc-mlcon clearfix">
						<ol>
							<li><span><img alt="" src="${configjscss }/images/toux.png"></span></li>
						</ol>
						<ul>
							<li>
								<dl>
									<dd>深圳市xxx美容店</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>
										<p>
											联系人 <b>欧阳先生</b>
										</p> 
										<p>
											联系电话 <b>18028081307</b>
										</p>
									</dt>
									<dd style="float: right; margin-top: 0.3rem;">
										<div class="jnbtn">
											<a href="投资-投资详情.html">查看</a>
										</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="jlc-morelist">
					<h3>深圳市罗湖区xxx街道110号</h3>
					<div class="jlc-mlcon clearfix">
						<ol>
							<li><span><img alt="" src="${configjscss }/images/toux.png"></span></li>
						</ol>
						<ul>
							<li>
								<dl>
									<dd>深圳市xxx美容店</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>
										<p>
											联系人 <b>欧阳先生</b>
										</p> 
										<p>
											联系电话 <b>18028081307</b>
										</p>
									</dt>
									<dd style="float: right; margin-top: 0.3rem;">
										<div class="jnbtn">
											<a href="投资-投资详情.html">查看</a>
										</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="jlc-morelist">
					<h3>深圳市罗湖区xxx街道110号</h3>
					<div class="jlc-mlcon clearfix">
						<ol>
							<li><span><img alt="" src="${configjscss }/images/toux.png"></span></li>
						</ol>
						<ul>
							<li>
								<dl>
									<dd>深圳市xxx美容店</dd>
								</dl>
							</li>
							<li>
								<dl>
									<dt>
										<p>
											联系人 <b>欧阳先生</b>
										</p> 
										<p>
											联系电话 <b>18028081307</b>
										</p>
									</dt>
									<dd style="float: right; margin-top: 0.3rem;">
										<div class="jnbtn">
											<a href="投资-投资详情.html">查看</a>
										</div>
									</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="taglist" id="borrowContent3" style="display: none"></div>
		</div>
		<div id="pageDiv" class="btn"
			style="margin-bottom: 4rem; margin-top: 1.5rem;"></div>

	</div>


	<jsp:include page="/foot.do?footId=2"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			//切换效果
			$('.jtagtit dd').click(function() {
				var i = $(this).index();
				$(this).addClass('cur').siblings().removeClass('cur');
				$('.taglist').eq(i).show().siblings().hide();

			});
		});
	</script>
</body>
</html>