$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/cadetpays/_search/cadetpays',
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
            field: 'username',
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
                   return "未缴费";
               }else if(row.payStatus == 2){
                   return "已缴费未报道";
               }else if(row.payStatus == 3){
                   return "已缴费已报道";
               }else {
                   return "未知";
               }
            }
        },{
            field: 'payAmount',
            title: '缴费金额',
            width: '15%',
            align: 'center'
        },{
            field: 'dataUpdateDatetime',
            title: '缴费时间',
            width: '15%',
            align: 'center'
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});