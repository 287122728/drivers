$(document).ready(function () {

    $('#table').bootstrapTable({
        url: '/sysmanager/_search/sysmanagers',
        search: true,
        searchText: '',

        undefinedText: '-',
        idField: 'id',
        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showPaginationSwitch: true,
        sidePagination: "server",
        pagination: true,
        pageList:"[10, 20, 50, 100]",
        columns: [{
            field: 'id',
            title: '序号',
            width: '5%',
            align: 'center'
        }, {
            field: 'avatar',
            title: '头像',
            width: '10%',
            align: 'center',
            formatter: function(value, row, index){
                return [
                    "<div>",
                    "<div class='small_pic'>",
                    "<a class='delete-click' href='#pic_one'>",
                    "<img src='" + row.avatarUrl +"'  style='width:30px;height:30px;'alt='用户头像'/> ",
                    "</a>",
                    "</div>",
                    "</div>"
                ].join('');
            },
            events:operateEvents,
        }, {
            field: 'username',
            title: '用户名',
            width: '10%',
            align: 'center'
        }, {
            field: 'password',
            title: '手机号码',
            width: '10%',
            align: 'center'
        }, {
            field: 'name',
            title: '真实姓名',
            width: '30%',
            align: 'center'
        }, {
            field: 'age',
            title: '年龄',
            width: '10%',
            align: 'center'
        }, {
            field: 'operate',
            title: '操作',
            width: '10%',
            align: 'center',
            // events: operateEvents,
            formatter: function(value, row, index) {
                return [
                    "<button type='button' class='reply-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-eye-open'></span>",
                    "<span class='hidden-xs hidden-sm'>回复</span>",
                    "</button>"
                ].join('');
            }
        }]
    });
});

window.operateEvents = {
    'click .delete-click': function (e, value, row, index) {
        $("#pic_one img").attr("src",row.avatarUrl);
        $('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
    }
};
