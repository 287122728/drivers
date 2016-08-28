<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学员信息</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <link href="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

<div class="main">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> 工作台</h3>
            <ol class="breadcrumb">
                <li><i class="fa fa-home"></i><a href="${ctx}/index.html">首页</a></li>
                <li><i class="fa fa-users"></i>学员管理</li>
                <li><i class="fa fa-user"></i>学员信息</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div id="toolbar">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <label>姓名:</label>
                    <input type="text" class="form-control" name="name">
                </div>
                 <div class="form-group">
                     <label>手机号码:</label>
                     <input type="text" class="form-control" name="mobile">
                  </div>
                <div class="form-group">
                    <label>微信号:</label>
                    <input type="text" class="form-control" name="weixinNum">
                </div>
                <div class="form-group">
                    <label>身份证:</label>
                    <input type="text" class="form-control" name="idcardNum">
                </div>
                <div class="form-group">
                    <label>注册时间:</label>
                    <input type="text" class="form-control" name="dataCreateDatetime">
                 </div>
                <button id="ok" type="submit" class="btn btn-default">OK</button>
            </div>
        </div>
        <table id="table"></table>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<script src="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
<script src="${ctx}/js/cadet/cadet.js" type="text/javascript"></script>
</body>
</html>