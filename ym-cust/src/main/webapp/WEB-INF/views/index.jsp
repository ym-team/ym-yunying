<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>画眉鸟</title>
<meta http-equiv="Expires" content="-1">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<%@include file="taglibs.jsp"%>

<style type="text/css">
.jlc-mlcon ul {
    width: 50%;
    float: right;
    box-sizing: border-box;
    padding-left: 0.3rem;
}
.jlc-mlcon ol {
    width: 50%;
    float: left;
    text-align: center;
    box-sizing: border-box;
    border-right: 1px solid #ccc;
}
</style>
</head>
<body>
	<div class="ui-page ui-page-theme-a ui-page-active" data-role="page"
		style="background: #fff;">
		<div class="xq_con">
		
		
		<div class="swiper-container">
				<div class="swiper-wrapper" style="height: 181px;">
					 <div class="swiper-slide">
								<a href="#"><img style="width: 100%;height: 200px;"
									src="${configjscss }/images/1.jpg" /></a>
							</div>
							<div class="swiper-slide">
								<a href="#"><img style="width: 100%;height: 200px;"
									src="${configjscss }/images/3.jpg" /></a>
							</div>
							<div class="swiper-slide">
								<a href="#"><img style="width: 100%;height: 200px;"
									src="${configjscss }/images/3.jpg" /></a>
							</div>
				</div>
				<!-- Add Pagination -->
				<div class="swiper-pagination"></div>
			</div>
		<script src="${configjscss }/js/swiper-3.3.1.jquery.min.js"></script>
			<script>
				var swiper = new Swiper('.swiper-container', {
					pagination : '.swiper-pagination',
					paginationClickable : true,
					spaceBetween : 30,
					centeredSlides : true,
					autoplay : 25000,
					autoplayDisableOnInteraction : false
				});
			</script>
		
			 
              
		<div class="xq_con">
		<div class="box">
		<input type="hidden" id="dftId" name="dftId" value="${dftId }">
			<!----类别----->
			<dl class="jtagtit clearfix">
			<c:forEach items="${list }" var="list">
				<dd  class="${not empty list.remark?list.remark:''}"  id="${list.id}">${list.categoryName }</dd>
			</c:forEach> 
			
			<!-- <dd  class="cur"  id="0">推荐</dd>
			<dd  class=""  id="1">鼻部</dd>
			<dd  class=""  id="2">眼部</dd>
			<dd  class=""  id="3">面部轮廓</dd>
			<dd  class=""  id="4">脂肪填充</dd>
			<dd  class=""  id="5">齿科</dd> -->
			</dl>
			</div>
			 
			<div class="jtag">
					<div class="taglist" id="borrowContent0">

						<div class="jlc-morelist">
							<div class="jlc-mlcon clearfix">
									<li><span><img src="${configjscss }/images/1.jpg" /></span></li>
									<li><p>1222fdsafdsa</p></li>
							</div>
						</div>

						<%-- <div class="jlc-mlcon clearfix">
							<ul>
								<li><dl>
										<p>
											<a href="#"><img style="height: 60%;"
												src="${configjscss }/images/t1.jpg" /></a>
										</p>
										<p>可爱的我来了~~~~最近做了一个统计，感觉这一年生了很大一笔护肤品的钱哦，</p>
									</dl></li>
							</ul>

							<ul>
								<li><dl>
										<p>
											<a href="#"><img style="height: 60%;"
												src="${configjscss }/images/t1.jpg" /></a>
										</p>
										<p>可爱的我来了~~~~最近做了一个统计，感觉这一年生了很大一笔护肤品的钱哦</p>
									</dl></li>
							</ul>
						</div> --%>
					</div>
				
				<div class="taglist" id="borrowContent1" style="display: none"></div>
				<div class="taglist" id="borrowContent2" style="display: none"></div>
				<div class="taglist" id="borrowContent3" style="display: none"></div>
				<div class="taglist" id="borrowContent4" style="display: none"></div>
				<div class="taglist" id="borrowContent5" style="display: none"></div>
			</div>
			</div>
		</div>
		<jsp:include page="/foot.do?footId=1"></jsp:include>
	</div>
</body>


<script type="text/javascript">
var borrowContent = 'borrowContent0';
var rateId =$("#dftId").val();
	$(document).ready(function() {
		var url = '${pathWeb}/borrow/getIndex.do';
		//切换效果
		 $('.jtagtit dd').click(function() {
			var rateId = $(this).attr("id");
			var i = $(this).index();
			$("#dftIndex").val(i);
			$("#dftPkId").val( $(this).attr("id"));
			$(this).addClass('cur').siblings().removeClass('cur');
			$('.taglist').eq(i).show().siblings().hide();
				borrowContent = 'borrowContent'+i; 
				url = '${pathWeb}/borrow/getIndex.do';
				openAjax(url, {
					"id" : rateId
				}, borrowRecommendCallback);
			$("#" + borrowContent).html("");
		}); 
		//项目列表 
		 openAjax(url, {
			"id" : rateId
		}, borrowRecommendCallback); 
	});
	
	function borrowRecommendCallback(data) {
		var jsonResult = data.data;
		
		
		
		
		//<div class="jlc-morelist"><div class="jlc-mlcon clearfix"><ol><li><span>1<i>%</i></span></li><li><p>日利率</p></li></ol><ul><li><dl><dt><p>每期还款 <b>1￥</b></p><p>含日利息 <b>1￥</b></p></dt></dl></li></ul></div></div><div class="jlc-bottom"><div class="jnbtn"><a data-ajax="false" rel="external" href="/ym/borrow/householdFinance.do?inputFee=1&ratePkId=1" >去借钱</a></div></div>
 
		
		
		
		
		
		
		
		
		 $.each(jsonResult,
					function(i, borrow) {
						if (data.code == $_SUCCESS_CODE) {
							var borrowHtml = '';
							borrowHtml += '<div class="jlc-morelist">';
							borrowHtml += '<div class="jlc-mlcon clearfix">';
							borrowHtml += '<ul>';
							borrowHtml += '<li><dl>';
							borrowHtml += '<p>';
							borrowHtml += '<a href="#"><img style="height: 60%;" src="${configjscss }/images/t1.jpg" /></a>';
							borrowHtml += '</p>';
							borrowHtml += '<p>';
							borrowHtml += borrow.descriptor
							borrowHtml += '</p>';
							borrowHtml += '</dl></li>';
							borrowHtml += '</ul>';
							borrowHtml += '<ul>';
							borrowHtml += '<li><dl>';
							borrowHtml += '<p>';
							borrowHtml += '<a href="#"><img style="height: 60%;"src="${configjscss }/images/t1.jpg" /></a>';
							borrowHtml += '</p>';
							borrowHtml += '<p>可爱的我来了~~~~最近做了一个统计，感觉这一年生了很大一笔护肤品的钱哦</p>';
							borrowHtml += '</dl></li>';
							borrowHtml += '</ul>';
							borrowHtml += '</div>';
							borrowHtml += '</div>'; 
						//	$("#" + borrowContent).append(borrowHtml);
						}
						
						
					})
		
	} 
	
	
	
	
	
	
	
	
	
	
/* 
	if (data.code == $_SUCCESS_CODE) {
		var borrowHtml = '';
		var jsonResult = strToJson(data.msg);
		if (jsonResult.list.length > 0) {
			if (jsonResult.totalPage == jsonResult.currentPage) {
				pageNum = jsonResult.totalPage;
				$("#pageDiv").html("");
			} else {
				var btu = '<a rel="external" class="com_btn2" href="javascript:void(0)" onclick="loadPage()">加载更多</a>';
				$("#pageDiv").html(btu);
			}
			$
					.each(
							jsonResult.list,
							function(i, borrow) {
								var isDayStr = '';
								if (borrow.is_day == 2) {
									isDayStr = '<span>'
											+ borrow.borrow_time_limit
											+ '</span><em>个月</em>';
								} else if (borrow.is_day == 1) {
									isDayStr = '<span>'
											+ borrow.borrow_time_limit
											+ '</span><em>天</em>';
								}

								var tenderBtu = '';
								if (borrow.borrow_status == 2) {
									tenderBtu = '<div class="jnbtn"><a data-ajax="false" href="${pathWeb}/borrow/showBorrowInfo/'+borrow.eid +'.do">立即投资</a></div>';
								} else {
									tenderBtu = '<div class="jnbtn"><a data-ajax="false" href="${pathWeb}/borrow/showBorrowInfo/'+borrow.eid +'.do" style = "background:#666666;">'
											+ ALL_STATUS[borrow.borrow_status]
											+ '</a></div>';
								}

								var annual_interest_rate = '<span>'
										+ addCommas(borrow.annual_interest_rate
												.toFixed(1)) + '%</span>';

								borrowHtml += '<div class="jlc-morelist"><h3>'
										+ borrow.borrow_title
										+ '</h3><div class="jlc-mlcon clearfix"><ol><li>'
										+ annual_interest_rate
										+ '</li><li><p>预期年化收益</p></li></ol><ul><li><dl><dt>投资进度</dt><dd><div class="jjd-w"><div class="jjd-n" style="width: '
										+ borrow.tenderProgressRate
										+ '%;"></div></div></dd><dd>'
										+ borrow.tenderProgressRate
										+ '%</dd></dl></li><li><dl><dt><p>理财期限 <b>'
										+ isDayStr
										+ '</b></p><p>投标奖励 <b>+'
										+ borrow.proportion_rate
										+ '%</b></p></dt><dd style="float: right; margin-top: 0.3rem;">'
										+ tenderBtu
										+ '</dd></dl></li></ul></div></div>';

							});
			alert(borrowHtml)
			$("#" + borrowContent).append(borrowHtml);
		} else {
			$("#pageDiv").find("a").addClass("ui-state-disabled");
			$.alert("暂无数据");
		}
	}
	
	 */
	
	
	
	
	
	
	
</script>
</html>