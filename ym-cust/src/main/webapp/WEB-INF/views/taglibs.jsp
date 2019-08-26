<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String pathWeb = request.getContextPath() ;
	String configjscss = path + "/common/ym";
%>

<c:set var="path" value="<%=path%>"></c:set>
<c:set var="pathWeb" value="<%=pathWeb%>"></c:set>
<c:set var="configjscss" value="<%=configjscss%>"></c:set>
<script type="text/javascript">
	var path = "${path}/";
</script>
<link rel="stylesheet" type="text/css" href="${configjscss }/css/jquery.mobile-1.4.2.min.css">
<link rel="stylesheet" type="text/css" href="${configjscss }/css/common.css">
<link rel="stylesheet" type="text/css" href="${configjscss }/css/jcss.css" />
<link rel="stylesheet" type="text/css" href="${configjscss }/css/swiper.min.css" />

<script type="text/javascript" src="${configjscss }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${configjscss }/js/jquery.mobile-1.4.2.min.js"></script>
<script type="text/javascript" src="${configjscss }/js/base.js"></script>
<script type="text/javascript" src="${configjscss }/js/jquery.validate.js"></script>
<script type="text/javascript" src="${configjscss }/js/jquery-validate-methods.js"></script>
<script type="text/javascript" src="${configjscss }/js/global-1.1.0.min.js"></script>
<script type="text/javascript" src="${path }/common/js/desencrypt.js"></script>
<script type="text/javascript" src="${path }/common/js/tripledes.js"></script>
<script type="text/javascript" src="${path }/common/js/mode-ecb.js"></script>
