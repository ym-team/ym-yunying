<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="../taglibs.jsp" %>
</head>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page"
     style="background: #eff2f7;">
    <header class="jwytz-header">
        <h3>
            <span onclick="history.go(-1)"></span>我的团队<em></em>
        </h3>
    </header>
    <div class="xq_con">
        <c:forEach items="${saleMans}" var="saleMan">
            <div class="jtag">
                <div class="taglist">
                    <div class="jlc-morelist">
                        <div class="jlc-mlcon clearfix">
                            <ol>
                                <li><span><img alt="" src="${configjscss }/images/toux.png"></span></li>
                                <c:if test="${not empty saleMan.realName}">
                                    <li><p>${saleMan.realName}</p></li>
                                </c:if>
                                <c:if test="${empty saleMan.realName}">
                                    <c:set value="${fn:length(saleMan.phone)}" var="phoneNumberLen"/>
                                    <li><p>*********${fn:substring(saleMan.phone,phoneNumberLen-4,phoneNumberLen)}</p></li>
                                </c:if>
                            </ol>
                            <ul>
                                <li>
                                    <dl>
                                        <dt style="margin-left: 40px;">级别</dt>
                                        <dd>&nbsp;<b>${saleMan.level}</b></dd>
                                    </dl>
                                </li>
                                <li>
                                    <dl>
                                        <dt>
                                            <p>
                                                加入时间 <b><span><fmt:formatDate value="${saleMan.createTime}" pattern="yyyy-MM-dd"/> </span></b>
                                            </p>
                                            <p>
                                                个人业绩 <b>${saleMan.achievement}单</b>
                                            </p>
                                        </dt>
                                        <dd style="float: right; margin-top: 0.3rem;display: none;">
                                            <div class="jnbtn">
                                                <a data-ajax="false" href="">查看</a>
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
</div>
</body>
</html>