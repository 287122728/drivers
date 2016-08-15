<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>驾校管理系统-用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <!--webfonts-->
    <link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/css/login.css">
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/plugins/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
    <h1>驾校管理系统</h1>
    <div class="login-form">
        <div class="close"></div>
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <div class="clear"></div>
        <div class="avtar">
            <img src="${ctx}/images/avtar.png" />
        </div>

        <form action="${ctx}/login" method="post">
            <input type="text" name="username" class="text" value="admin" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'admin';}" >
            <div class="key">
                <input type="password" name="password" value="admin" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'admin';}">
            </div>
            <%--<input id="_spring_security_remember_me" name="_spring_security_remember_me" type="checkbox" value="true"/>--%>
            <div class="signin">
                <input type="submit" value="Login" >
            </div>
        </form>
    </div>
    <div class="copy-rights">
        <p>Copyright &copy; 2016.Company name All rights reserved. <a href="http://www.keruyun.com/" target="_blank" title="客如云">客如云</a> </p>
    </div>

    <script src="${ctx}/plugins/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script>$(document).ready(function(c) {
        $('.close').on('click', function(c){
            $('.login-form').fadeOut('slow', function(c){
                $('.login-form').remove();
            });
        });
    });
</body>
</html>
