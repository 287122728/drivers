$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/suggestions/_search/suggestions',
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
            field: 'name',
            title: '姓名',
            width: '10%',
            align: 'center'
        },{
            field: 'mobile',
            title: '手机号码',
            width: '10%',
            align: 'center'
        },{
            field: 'content',
            title: '内容',
            width: '10%',
            align: 'center'
        },{
            field: 'businessStatus',
            title: '状态',
            width: '15%',
            align: 'center'
        },{
            field: 'dataCreateDatetime',
            title: '投诉时间',
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