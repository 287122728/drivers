$(document).ready(function () {
    var tuitionService = new TuitionService();
    $('#table').bootstrapTable({
        url: '/schooltuitions',
        // clickToSelect: true,
        undefinedText: '-',
        columns: [{
            field: 'id',
            title: '序号',
            width: '5%',
            align: 'center',
            visible: true,
        },{
            field: 'name',
            title: '驾校',
            width: '10%',
            align: 'center'
        },{
            field: 'tuition',
            title: '学费',
            width: '10%',
            align: 'center',
            editable: true,
            editableEmptytext: '请输入学费'
        },{
            field: 'tuitionExplain',
            title: '学费说明',
            width: '30%',
            align: 'center',
            editable: true,
            editableEmptytext: '请输入学费说明'
        },{
            field: 'dataCreator',
            title: '数据创建者',
            width: '10%',
            align: 'center'
        },{
            field: 'dataCreateDatetime',
            title: '数据创建日期时间',
            width: '10%',
            align: 'center'
        }],
        onEditableSave: function (field, row, oldValue, $el) {
            if(row.tuition != oldValue || row.tuitionExplain != oldValue){
                tuitionService.updateLinkUrl(row.id,row.tuition);
            }
        }
    });
});

function TuitionService(){
    var obj   = new Object();
    obj.updateLinkUrl = function (id,linkUrl) {
        $.ajax({
            url: '/schooltuitions/' + id,
            dataType: 'json',
            method: 'PUT',
            data:{'linkUrl':linkUrl},
            success: function(data){
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    return obj;
}