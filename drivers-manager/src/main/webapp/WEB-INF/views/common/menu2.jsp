<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Proton - Admin Template</title>

    <!-- Import google fonts - Heading first/ text second -->
    <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:400,700|Droid+Sans:400,700' />
    <!--[if lt IE 9]>
    <link href="http://fonts.useso.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.useso.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
    <link href="http://fonts.useso.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.useso.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="${ctx}/assets/ico/favicon.ico" type="image/x-icon" />

    <!-- Css files -->
    <link href="${ctx}/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/assets/css/jquery.mmenu.css" rel="stylesheet">
    <link href="${ctx}/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/assets/css/climacons-font.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/xcharts/css/xcharts.min.css" rel=" stylesheet">
    <link href="${ctx}/assets/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/morris/css/morris.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <link href="${ctx}/assets/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/assets/css/add-ons.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container-fluid content">
        <div class="row">
            <!-- start: Main Menu -->
            <div class="sidebar">
                <div class="sidebar-collapse">
                    <div class="sidebar-header t-center">
                        <span><img class="text-logo" src="${ctx}/assets/img/logo1.png"><i class="fa fa-space-shuttle fa-3x blue"></i></span>
                    </div>

                    <div class="sidebar-menu">
                        <ul class="nav nav-sidebar head-new-nav">

                        </ul>
                    </div>
                </div>
            </div>

            <!-- end: Main Menu -->
        </div>
    </div>

<script>
    var data = [];
    data.push({"id":"6","sort":1,"parentId":"0","role":"crm","platform":2,"url":"/crm/customer/view","name":"顾客"});
    data.push({"id":"7","sort":3,"parentId":"0","role":"marketing","platform":2,"url":"#","name":"营销"});
    data.push({"id":"8","sort":1,"parentId":"7","platform":2,"url":"/marketing/marketPlan/list","name":"营销方案"});
    data.push({"id":"9","sort":2,"parentId":"7","platform":2,"url":"/marketing/coupon/list","name":"优惠券模板"});
    data.push({"id":"10","sort":3,"parentId":"7","platform":2,"url":"/marketing/coupInstance/list","name":"优惠券"});
    data.push({"id":"11","sort":2,"parentId":"0","role":"booking","platform":1,"url":"#","name":"订单"});
    data.push({"id":"12","sort":1,"parentId":"11","platform":1,"url":"/booking/list","name":"预订订单"});
    data.push({"id":"13","sort":2,"parentId":"11","platform":1,"url":"/queue/page","name":"排队订单"});
    data.push({"id":"14","sort":4,"parentId":"0","role":"report","platform":1,"url":"#","name":"报表"});
    data.push({"id":"15","sort":1,"parentId":"14","platform":1,"url":"#","name":"预订报表"});
    data.push({"id":"16","sort":1,"parentId":"15","platform":1,"url":"/report/bookingchart/charts","name":"预订量报表"});
    data.push({"id":"17","sort":2,"parentId":"15","platform":1,"url":"/report/bookingReport/innerPerson","name":"代理人预订占比分析"});
    data.push({"id":"18","sort":3,"parentId":"15","platform":1,"url":"/report/bookingReport/reason?reasonType=-3","name":"预订拒绝理由占比分析"});
    data.push({"id":"19","sort":4,"parentId":"15","platform":1,"url":"/report/bookingReport/reason?reasonType=9","name":"预订取消理由占比分析"});
    data.push({"id":"20","sort":5,"parentId":"15","platform":1,"url":"/report/bookingFrequency/view","name":"预订频次报表"});
    data.push({"id":"21","sort":2,"parentId":"14","platform":1,"url":"#","name":"排队报表"});
    data.push({"id":"22","sort":1,"parentId":"21","platform":1,"url":"/report/queueReport/list","name":"排队量报表"});
    data.push({"id":"23","sort":2,"parentId":"21","platform":1,"url":"/report/queue/queueLoss","name":"排队流失率报表"});
    data.push({"id":"24","sort":3,"parentId":"21","platform":1,"url":"/report/queue/avgWaitTime","name":"平均等待时长"});
    data.push({"id":"25","sort":3,"parentId":"14","platform":1,"url":"#","name":"营业报表"});
    data.push({"id":"26","sort":2,"parentId":"25","platform":1,"url":"/report/cashHandover","name":"交接班报表"});
    data.push({"id":"27","sort":1,"parentId":"25","platform":1,"url":"/report/bill","name":"账单明细报表"});
    data.push({"id":"28","sort":4,"parentId":"25","platform":1,"url":"/report/cashrecordStat/","name":"门店收款统计报表"});
    data.push({"id":"29","sort":4,"parentId":"14","platform":1,"url":"#","name":"销售报表"});
    data.push({"id":"31","sort":1,"parentId":"29","platform":1,"url":"/report/dish/toDish","name":"菜品排行报表"});
    data.push({"id":"32","sort":2,"parentId":"29","platform":1,"url":"/report/foodback/view","name":"退菜占比分析"});
    data.push({"id":"33","sort":3,"parentId":"29","platform":1,"url":"/report/periodSale","name":"时间段销售分析报表"});

    data.push({"id":"34","sort":5,"parentId":"0","role":"set","platform":1,"url":"#","name":"设置"});
    data.push({"id":"45","sort":100,"parentId":"34","platform":5,"url":"#","name":"微信设置"});
    data.push({"id":"35","sort":100,"parentId":"34","platform":1,"url":"/printer/list","name":"打印机设置"});
    data.push({"id":"36","sort":100,"parentId":"34","platform":1,"url":"/commercial/commercialConfig/get","name":"门店设置"});
    data.push({"id":"37","sort":100,"parentId":"34","platform":1,"url":"#","name":"桌台设置"});
    data.push({"id":"38","sort":100,"parentId":"37","platform":1,"url":"/commercial/commercialArea/list","name":"桌台区域"});
    data.push({"id":"39","sort":100,"parentId":"37","platform":1,"url":"/commercial/tables/list","name":"桌台"});
    data.push({"id":"40","sort":100,"parentId":"37","platform":1,"url":"/commercial/physicallayout/physicalLayoutList","name":"物理布局图"});
    data.push({"id":"41","sort":100,"parentId":"34","platform":1,"url":"/commercial/queueConfig/get","name":"排队设置"});
    data.push({"id":"42","sort":100,"parentId":"34","platform":1,"url":"/commercial/bookingConfig/get","name":"预订设置"});
    data.push({"id":"43","sort":100,"parentId":"34","platform":1,"url":"/commercial/orderConfig/get","name":"堂食设置"});
    data.push({"id":"44","sort":100,"parentId":"34","platform":1,"url":"/smsReHistory/list","name":"短信充值"});
    data.push({"id":"455","sort":100,"parentId":"45","platform":5,"url":"/shop/homeShowSales","name":"门店首页设置"});
    data.push({"id":"46","sort":100,"parentId":"45","platform":5,"url":"/reply/text/view","name":"自定义消息回复"});
    data.push({"id":"47","sort":100,"parentId":"45","platform":5,"url":"/material/list?type=imageText","name":"素材库"});
    data.push({"id":"449","parentId":"45","platform":5,"url":"/code/qrcode","name":"快捷支付二维码"});
    data.push({"i,d":"454","sort":100,"parentId":"45","platform":5,"url":"/code/focusQrCodeUrl","name":"关注公众号二维码"});
    data.push({"id":"450","sort":100,"parentId":"34","platform":1,"url":"#","name":"权限设置"});
    data.push({"id":"451","sort":100,"parentId":"450","platform":1,"url":"/auth/role/list","name":"角色设置"});
    data.push({"id":"452","sort":100,"parentId":"450","platform":1,"url":"/auth/userBrand/list","name":"账号管理"});
    data.push({"id":"453","sort":100,"parentId":"34","platform":2,"url":"/crm/customergroup/listView","name":"顾客分组"});
    data.push({"id":"48","sort":7,"parentId":"0","role":"faq","platform":1,"url":"#","name":"帮助"});
    data.push({"id":"49","sort":1,"parentId":"48","platform":1,"url":"/faq/video/list","name":"视频中心"});
    data.push({"id":"50","sort":2,"parentId":"48","platform":1,"url":"/faq/question/list","name":"问题解答"});

    var win = window.bkeruyun || window;
    data = win.convertMenuData(data);
    win.createMenu(data,'');
    win.currentLink();
    win.showNav($(".nav > li,.dropdown-submenu"),".dropdown-menu","open");
</script>
</body>

</html>