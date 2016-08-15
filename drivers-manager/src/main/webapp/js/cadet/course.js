$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/cadetcourses/_search/cadetcourses',
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
            field: 'course',
            title: '目前课程',
            width: '15%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.course == 1){
                    return "科目1";
                }else if(row.course == 2){
                    return "科目2";
                }else if(row.course == 3){
                    return "科目3";
                }else if(row.course == 3){
                    return "科目4";
                }else {
                    return "未知";
                }
            }
        },{
            field: 'dataUpdateDatetime',
            title: '变更时间',
            width: '15%',
            align: 'center'
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});