$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/cadets/_search/cadets',
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
            return params;
        },
        // search: true,
        searchText: '',
        clickToSelect: true,
        undefinedText: '-',
        idField: 'id',
        showColumns: true,
        showRefresh: true,
        // showToggle: true,
        minimumCountColumns: 3,
        // showPaginationSwitch: true,
        sidePagination: "server",
        pagination: true,
        pageList:"[5,10, 20, 50]",
        columns: [{
            field: 'state',
            checkbox: true,
            width: '5%'
        },{
            field: 'id',
            title: '序号',
            width: '5%',
            align: 'center'
        },{
            field: 'username',
            title: '用户名',
            width: '10%',
            align: 'center'
        },{
            field: 'name',
            title: '姓名',
            width: '10%',
            align: 'center'
        },{
            field: 'age',
            title: '年龄',
            width: '5%',
            align: 'center'
        },{
            field: 'phone',
            title: '电话号码',
            width: '10%',
            align: 'center'
        },{
            field: 'weixinNum',
            title: '微信号',
            width: '10%',
            align: 'center'
        },{
            field: 'idcardNum',
            title: '身份证号码',
            width: '15%',
            align: 'center'
        },{
            field: 'payStatus',
            title: '缴费状态',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
               if(row.payStatus == 1){
                   return "<a href='/cadetpay/1'>未缴费</a>";
               }else if(row.payStatus == 2){
                   return "<a href='/cadetpay/1'>已缴费未报道</a>";
               }else if(row.payStatus == 3){
                   return "<a href='/cadetpay/1'>已缴费已报道</a>";
               }else {
                   return "未知";
               }
            }
        },{
            field: 'course',
            title: '课程情况',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.course == 1){
                    return "科目一";
                }else if(row.course == 2){
                    return "科目二";
                }else if(row.course == 3){
                    return "科目三";
                }else if(row.course == 4){
                    return "科目四";
                }else {
                    return "未知";
                }
            }
        },{
            field: 'dataUpdater',
            title: '数据更新者',
            width: '10%',
            align: 'center'
        },{
            field: 'dataCreateDatetime',
            title: '注册时间',
            width: '10%',
            align: 'center'
        },{
            field: 'dataStatus',
            title: '数据有效状态',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.dataStatus == 0){
                    return "无效";
                }else if(row.dataStatus == 1){
                    return "有效";
                }else {
                    return "未知";
                }
            }
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});