<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid content">
    <div class="row">
        <!-- start: Main Menu -->
        <div class="sidebar ">

            <div class="sidebar-collapse">
                <div class="sidebar-header t-center">
                    <span><img class="text-logo" src="${ctx}/assets/img/logo1.png"><i class="fa fa-space-shuttle fa-3x blue"></i></span>
                </div>
                <div class="sidebar-menu">
                    <ul class="nav nav-sidebar">
                        <li><a href="index.html"><i class="fa fa-laptop"></i><span class="text"> 工作台</span></a></li>
                        <li>
                            <a href="#"><i class="fa fa-car"></i><span class="text"> 驾校管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="school"><i class="fa fa-car"></i><span class="text"> 驾校信息管理</span></a></li>
                                <li><a href="schooltuition"><i class="fa fa-jpy"></i><span class="text"> 学费管理</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-car"></i><span class="text"> 驾驶员管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="/drivers"><i class="fa fa-car"></i><span class="text"> 驾驶员信息管理</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-users"></i><span class="text"> 学员管理</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="cadet"><i class="fa fa-user"></i><span class="text"> 学员信息管理</span></a></li>
                                <li><a href="cadetpay"><i class="fa fa-envelope"></i><span class="text"> 学员缴费信息管理</span></a></li>
                                <li><a href="cadet_pay_tog"><i class="fa fa-envelope"></i><span class="text"> 学员缴费信息报表</span></a></li>
                                <li><a href="cadetcourse"><i class="fa fa-envelope"></i><span class="text"> 学员课程管理</span></a></li>
                            </ul>
                        </li>
                        <li><a href="suggestion"><i class="fa fa-phone-square"></i><span class="text"> 投诉建议管理</span></a></li>
                        <li>
                            <a href="#"><i class="fa fa-male"></i><span class="text"> 系统管理员</span> <span class="fa fa-angle-down pull-right"></span></a>
                            <ul class="nav sub">
                                <li><a href="sysmanager"><i class="fa fa-male"></i><span class="text"> 管理员信息</span></a></li>
                                <li><a href="sysmanagerregister"><i class="fa fa-envelope"></i><span class="text"> 注册</span></a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="sidebar-footer">

                <div class="sidebar-brand">
                    Proton
                </div>

                <ul class="sidebar-terms">
                    <li><a href="index.html#">Terms</a></li>
                    <li><a href="index.html#">Privacy</a></li>
                    <li><a href="index.html#">Help</a></li>
                    <li><a href="index.html#">About</a></li>
                </ul>

                <div class="copyright text-center">
                    <small>Proton <i class="fa fa-coffee"></i> from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small>
                </div>
            </div>

        </div>
        <!-- end: Main Menu -->
    </div>
</div>