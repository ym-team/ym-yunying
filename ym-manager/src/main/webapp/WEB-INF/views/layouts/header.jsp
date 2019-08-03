<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="page-header navbar navbar-fixed-top">
    <div class="page-header-inner ">
        <div class="page-logo" style="width:253px;">
            <h4 style="color:#fff6ec"><span
                    style="font-weight: bold"><img alt="" class="img-circle" src="${ctx}/metronic/assets/pages/img/logo_new.jpg" width="30" height="30"/>&nbsp;医美</span></h4>
            <div class="menu-toggler sidebar-toggler"></div>
        </div>
        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>
        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <img alt="" class="img-circle" src="${ctx}/metronic/assets/layouts/layout/img/avatar3_small.jpg"/>
                        <span class="username username-hide-on-mobile">
                            <%=request.getSession().getAttribute("userName")%>
                        </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-default">
                        <li>
                            <a data-toggle="modal" href="#changePwd"><i class="icon-lock"></i> 修改密码 </a>
                        </li>
                        <li>
                            <a href="${ctx}/login"> <i class="icon-key"></i> 登出 </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="changePwd" class="modal fade" tabindex="10">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">修改密码</h4>
    </div>
    <form action="changePassword" method="post">
        <div class="modal-body">
            <div class="form-group">
                <input name="opwd" class="form-control" type="password" placeholder="原密码" data-tabindex="1"> </div>
            <div class="form-group">
                <input name="npwd" class="form-control" type="password" placeholder="新密码" data-tabindex="2"> </div>
            <div class="form-group">
                <input name="npwd2" class="form-control" type="password" placeholder="重复新密码" data-tabindex="3"> </div>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn btn-default">取消</button>
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </form>
</div>
