$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/drivers/_search/drivers',
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
            field: 'phone1',
            title: '主手机号码',
            width: '5%',
            align: 'center'
        },{
            field: 'phone2',
            title: '备用手机号码',
            width: '10%',
            align: 'center'
        },{
            field: 'model',
            title: '车型',
            width: '10%',
            align: 'center'
        },{
            field: 'registerDatetime',
            title: '注册时间',
            width: '10%',
            align: 'center'
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});