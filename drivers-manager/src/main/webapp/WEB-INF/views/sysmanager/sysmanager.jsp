<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>系统管理员</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <link href="${ctx}/plugins/jQuery-Plugin-For-Image-Zoom-On-Hover-picZoomer/css/jquery-picZoomer.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

    <div class="main">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="${ctx}/index">Home</a></li>
                    <li><i class="fa fa-laptop"></i>系统管理员</li>
                    <li><i class="fa fa-laptop"></i>管理员信息</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div id="pic_one" style="display:none;">
                <img  />
            </div>
            <table id="table"></table>
        </div>
    </div>


    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <script src="${ctx}/js/content_zoom.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/sysmanager/sysmanager.js" type="text/javascript"></script>
</body>
</html>