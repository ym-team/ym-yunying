<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>预约-客户</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <%@include file="../taglibs.jsp" %>
</head>
<body>
<div class="ui-page ui-page-theme-a ui-page-active" data-role="page"
     style="background: #eff2f7;">

    <div class="xq_con">
        <header class="jwytz-header">
            <h3>
                <span onclick="history.go(-1)"></span>预约客户<em></em>
            </h3>
        </header>
        <div class="jtag">
            <div class="taglist">
                <div class="jlc-morelist">
                    <div class="jlc-mlcon clearfix">
                        <ol>
                            <li><span>1</span></li>
                            <li><p>张三</p></li>
                        </ol>
                        <ul>
                            <li>
                                <dl>
                                    <dt>顾客职业：</dt>
                                    <dd>老师</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>
                                        <p>
                                            加入时间 <b><span>2019-08-06</span></b>
                                        </p>
                                        <p>
                                            咨询项目 <b>整容</b>
                                        </p>
                                    </dt>
                                    <dd style="float: right; margin-top: 0.3rem;">
                                        <div class="jnbtn">
                                            <a data-ajax="false" href="${pathWeb }/customer/detail.do">查看</a>
                                        </div>
                                    </dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="jtag">
            <div class="taglist">
                <div class="jlc-morelist">
                    <div class="jlc-mlcon clearfix">
                        <ol>
                            <li><span>2</span></li>
                            <li><p>李四</p></li>
                        </ol>
                        <ul>
                            <li>
                                <dl>
                                    <dt>顾客职业：</dt>
                                    <dd>司机</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>
                                        <p>
                                            加入时间 <b><span>2019-08-06</span></b>
                                        </p>
                                        <p>
                                            咨询项目 <b>整容</b>
                                        </p>
                                    </dt>
                                    <dd style="float: right; margin-top: 0.3rem;">
                                        <div class="jnbtn">
                                            <a data-ajax="false" href="${pathWeb }/customer/detail.do">查看</a>
                                        </div>
                                    </dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="jtag">
            <div class="taglist">
                <div class="jlc-morelist">
                    <div class="jlc-mlcon clearfix">
                        <ol>
                            <li><span>3</span></li>
                            <li><p>王五</p></li>
                        </ol>
                        <ul>
                            <li>
                                <dl>
                                    <dt>顾客职业：</dt>
                                    <dd>教授</dd>
                                </dl>
                            </li>
                            <li>
                                <dl>
                                    <dt>
                                        <p>
                                            加入时间 <b><span>2019-08-06</span></b>
                                        </p>
                                        <p>
                                            咨询项目 <b>整容</b>
                                        </p>
                                    </dt>
                                    <dd style="float: right; margin-top: 0.3rem;">
                                        <div class="jnbtn">
                                            <a data-ajax="false" href="${pathWeb }/customer/detail.do">查看</a>
                                        </div>
                                    </dd>
                                </dl>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>