<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Proton - Admin Template</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
    <!-- start: Content -->
    <div class="main">

        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="${ctx}/index">Home</a></li>
                    <li><i class="fa fa-laptop"></i>工作台</li>
                </ol>
            </div>
        </div>

        <div class="row">
            暂时没有
        </div>
    </div>
    <!-- end: Content -->

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
</body>
</html>
