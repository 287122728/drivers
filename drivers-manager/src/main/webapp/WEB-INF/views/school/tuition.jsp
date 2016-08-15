<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/plugins/x-editable/dist/bootstrap3-editable/css/bootstrap-editable.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

    <div class="main">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-laptop"></i> 工作台</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="${ctx}/index">首页</a></li>
                    <li><i class="fa fa-car"></i><a href="${ctx}/index">驾校信息管理</a></li>
                    <li><i class="fa fa-jpy"></i><a href="${ctx}/index">学费信息管理</a></li>
                </ol>
            </div>
        </div>

        <div class="row">
            <table id="table"></table>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <script src="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-table/dist/extensions/editable/bootstrap-table-editable.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/x-editable/dist/bootstrap3-editable/js/bootstrap-editable.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/school/tuition.js" type="text/javascript"></script>
</body>
</html>