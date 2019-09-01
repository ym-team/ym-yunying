<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="footer">
<ul>
	<li <c:if test="${ footId == 1 }"> class="current"</c:if> ><a rel="external" href="${pathWeb }/ym/performance/salesmanindex.do"><i></i><span>首页</span></a></li>
	<li  <c:if test="${ footId == 2 }"> class="current"</c:if>><a rel="external" href="${pathWeb }/ym/store/StoreEnterView.do"><i class="one3"></i><span>店门邀请</span></a></li>
	<li  <c:if test="${ footId == 3 }"> class="current"</c:if>><a rel="external" href="${pathWeb }/ym/beautify.do"><i class="one1"></i><span>顾客变美</span></a></li>
	<li  <c:if test="${ footId == 4 }"> class="current"</c:if>><a rel="external" href="${pathWeb }/ym/userIndex.do"><i class="one2"></i><span>我的</span></a></li>
</ul>
</div>