<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>驾校管理-驾校信息</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
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
                    <li><i class="fa fa-laptop"></i>驾校管理</li>
                    <li><i class="fa fa-heart-o"></i>驾校信息</li>
                </ol>
            </div>
        </div>

        <div class="row profile" id="app">

            <div class="col-md-5">

                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="text-center">
                            <img class="img-profile" src="{{logUrl}}">
                        </div>

                        <h3 class="text-center"><strong>{{name}}</strong></h3>
                        <h4 class="text-center"><small><i class="fa fa-map-marker"></i> {{addr}}</small></h4>

                        <hr>

                        <div class="text-center">
                            <li><a href="" class="fa fa-facebook facebook-bg"></a></li>
                            <li><a href="" class="fa fa-twitter twitter-bg"></a></li>
                            <li><a href="" class="fa fa-linkedin linkedin-bg"></a></li>
                        </div>

                        <hr>

                        <div class="row text-center">
                            <div class="col-xs-4">
                                <div><strong>1.256</strong></div>
                                <div><small>Followers</small></div>
                            </div><!--/.col-->
                            <div class="col-xs-4">
                                <div><strong>2.568</strong></div>
                                <div><small>Following</small></div>
                            </div><!--/.col-->
                            <div class="col-xs-4">
                                <div><strong>25.265</strong></div>
                                <div><small>Posts</small></div>
                            </div><!--/.col-->
                        </div><!--/.row-->

                        <hr>

                        <h4><strong>通用信息</strong></h4>

                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-building-o"></i> 公司</div>
                                {{name}}
                            </li>
                            <li>
                                <div><i class="fa fa-thumbs-up"></i> 管理者</div>
                                {{name}}
                            </li>
                        </ul>

                        <hr>

                        <h4><strong>联系方式</strong></h4>

                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-phone"></i> 座机</div>
                                +25 {{phone}}
                            </li>
                            <li>
                                <div><i class="fa fa-tablet"></i> 手机</div>
                                +86 {{mobile}}
                            </li>
                            <li>
                                <div><i class="fa fa-envelope"></i> 电子邮箱</div>
                                {{email}}
                            </li>
                            <li>
                                <div><i class="fa fa-map-marker"></i> 详细地址</div>
                                Blackstreet No. 256<br/>
                                1256 California, USA<br/>
                            </li>
                        </ul>

                        <h4><strong>简介</strong></h4>

                        <div class="profile-details">
                            {{introduction}}
                         </div>
                    </div>

                </div>

            </div><!--/.col-->

            <div class="col-md-7">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2><i class="fa fa-heart-o red"></i><strong>驾校信息更新</strong></h2>
                    </div>
                    <div class="panel-body">
                        <form class="form-vertical hover-stripped" role="form">
                            <input type="text" value="{{id}}" hidden="hidden">
                            <div class="form-group">
                                <label class="control-label">logo</label>
                                <input type="text" class="form-control" v-model="name" value="{{logoUrl}}" >
                            </div>
                            <div class="form-group">
                                <label class="control-label">驾校</label>
                                <input type="text" class="form-control" v-model="name" value="{{name}}" >
                                <%--<a href="#" class="help-block">Request new ?</a>--%>
                            </div>
                            <div class="form-group">
                                <label class="control-label">电话号码</label>
                                <input type="text" class="form-control" v-model="phone" value="{{phone}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">手机号码</label>
                                <input type="text" class="form-control" v-model="mobile"  value="{{mobile}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">电子邮箱</label>
                                <input type="email" class="form-control" v-model="email" value="{{email}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">地址</label>
                                <input type="text" class="form-control" v-model="addr" value="{{addr}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">简介</label>
                                <textarea class="form-control" rows="3" v-model="introduction">{{introduction}}</textarea>
                            </div>

                            <div class="form-group pull-right">
                                <button class="btn btn-primary" type="submit" id="ok">更新</button>
                            </div>

                        </form>
                    </div>
                </div>

            </div><!--/.col-->

        </div><!--/.row profile-->
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <script src="${ctx}/js/school/school.js" ></script>
</body>
</html>