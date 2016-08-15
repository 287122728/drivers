<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- start: JavaScript-->
<!--[if !IE]>-->

<script src="${ctx}/assets/js/jquery-2.1.1.min.js"></script>

<!--<![endif]-->

<!--[if IE]>

<script src="${ctx}/assets/js/jquery-1.11.1.min.js"></script>

<![endif]-->

<!--[if !IE]>-->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-2.1.1.min.js'>"+"<"+"/script>");
</script>

<!--<![endif]-->

<!--[if IE]>

<script type="text/javascript">
window.jQuery || document.write("<script src='${ctx}/assets/js/jquery-1.11.1.min.js'>"+"<"+"/script>");
</script>

<![endif]-->
<script src="${ctx}/assets/js/jquery-migrate-1.2.1.min.js"></script>
<%--<script src="${ctx}/assets/js/bootstrap.min.js"></script>--%>
<script src="${ctx}/plugins/bootstrap/dist/js/bootstrap.min.js"></script>



<!-- page scripts -->
<script src="${ctx}/assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
<script src="${ctx}/assets/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
<script src="${ctx}/assets/plugins/moment/moment.min.js"></script>
<script src="${ctx}/assets/plugins/fullcalendar/js/fullcalendar.min.js"></script>
<!--[if lte IE 8]>
<script language="javascript" type="text/javascript" src="${ctx}/assets/plugins/excanvas/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/assets/plugins/flot/jquery.flot.min.js"></script>
<script src="${ctx}/assets/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${ctx}/assets/plugins/flot/jquery.flot.stack.min.js"></script>
<script src="${ctx}/assets/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${ctx}/assets/plugins/flot/jquery.flot.time.min.js"></script>
<script src="${ctx}/assets/plugins/flot/jquery.flot.spline.min.js"></script>
<script src="${ctx}/assets/plugins/xcharts/js/xcharts.min.js"></script>
<script src="${ctx}/assets/plugins/autosize/jquery.autosize.min.js"></script>
<script src="${ctx}/assets/plugins/placeholder/jquery.placeholder.min.js"></script>
<script src="${ctx}/assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/assets/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
<script src="${ctx}/assets/plugins/raphael/raphael.min.js"></script>
<script src="${ctx}/assets/plugins/morris/js/morris.min.js"></script>
<script src="${ctx}/assets/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${ctx}/assets/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="${ctx}/assets/plugins/jvectormap/js/gdp-data.js"></script>
<script src="${ctx}/assets/plugins/gauge/gauge.min.js"></script>


<!-- theme scripts -->
<script src="${ctx}/assets/js/SmoothScroll.js"></script>
<script src="${ctx}/assets/js/jquery.mmenu.min.js"></script>
<script src="${ctx}/assets/js/core.min.js"></script>
<script src="${ctx}/assets/plugins/d3/d3.min.js"></script>
<script src="${ctx}/js/common/common.js"></script>
<!-- inline scripts related to this page -->
<%--<script src="${ctx}/assets/js/pages/index.js"></script>--%>

<!-- end: JavaScript-->

<script src="${ctx}/plugins/vue/dist/vue.min.js"></script>
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

//    var win = window.bkeruyun || window;
//    data = win.convertMenuData(data);
//    win.createMenu(data,'');
//    win.currentLink();
//    win.showNav($(".nav > li,.dropdown-submenu"),".dropdown-menu","open");
</script>