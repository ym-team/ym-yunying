<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<div class="page-sidebar-wrapper">
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu  page-header-fixed page-sidebar-menu-hover-submenu " id="page-sidebar-menu"
            data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
            <li class="sidebar-toggler-wrapper hide">
                <div class="sidebar-toggler"></div>
            </li>
            <li id="menu1" class="nav-item">
                <a href="${ctx}/" class="nav-link nav-toggle">
                    <i class="icon-home"></i>
                    <span class="title">主页</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li class="heading">
                <h3 class="uppercase">系统管理</h3>
            </li>
            <li id="menu2" class="nav-item">
                <a href="${ctx}/user/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">用户管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li id="menu3" class="nav-item">
                <a href="${ctx}/role/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">角色管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li class="heading">
                <h3 class="uppercase">医院管理</h3>
            </li>
            <li id="menu4" class="nav-item">
                <a href="${ctx}/hospital/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">医院管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li id="menu5" class="nav-item">
                <a href="${ctx}/doctor/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">医生管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li class="heading">
                <h3 class="uppercase">店铺管理</h3>
            </li>
            <li id="menu6" class="nav-item">
                <a href="${ctx}/shop/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">店铺管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li id="menu7" class="nav-item">
                <a href="${ctx}/salesMan/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">业务员管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li class="heading">
                <h3 class="uppercase">数据统计</h3>
            </li>
            <li id="menu8" class="nav-item">
                <a href="${ctx}/doctor/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">日报表</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            <li id="menu9" class="nav-item">
                <a href="${ctx}/doctor/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">月报表</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            
            
            
            <li class="heading">
                <h3 class="uppercase">提成管理</h3>
            </li>
            <li id="menu10" class="nav-item">
                <a href="${ctx}/cfgCooperationRate/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">合作方提成</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            
              <li id="menu11" class="nav-item">
                <a href="${ctx}/hospital/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">业务员提成</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            
            
            
            
            
                        <li class="heading">
                <h3 class="uppercase">医院管理</h3>
            </li>
            <li id="menu12" class="nav-item">
                <a href="${ctx}/hospital/list" class="nav-link nav-toggle">
                    <i class="icon-layers"></i>
                    <span class="title">医院管理</span>
                    <span class="selected"></span>
                    <span class="arrow open"></span>
                </a>
            </li>
            
            
        </ul>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $(".page-sidebar-menu .nav-item").bind("click", function () {
            $(".page-sidebar-menu .nav-item").removeClass("active");
            Cookies.set("currentMenuId", $(this).attr("id"));
        });
        if (typeof Cookies !== "undefined" && Cookies.get("currentMenuId")) {
            $("#" + Cookies.get("currentMenuId")).addClass("active");
        } else {
            $("#menu1").addClass("active");
        }
    });
</script>