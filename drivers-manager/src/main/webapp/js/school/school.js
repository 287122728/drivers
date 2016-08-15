$(document).ready(function () {
    var vm = new Vue({
        el: '#app',
        data: {
        },
        methods:{
            reverseMessage: function () {
                var schoolService = new SchoolService(vm);
                schoolService.updateSchool();
            }
        }
    });
    var schoolService = new SchoolService(vm);
    schoolService.getShcool();


    $('#ok').click(function () {
        schoolService.updateSchool();
    });
});

function SchoolService(vm) {
    var obj = new Object();
    obj.getShcool = function () {
        $.ajax({
            url: '/schools',
            dataType: 'json',
            method: 'GET',
            data: {},
            success: function(result){
                vm.$data = result;
            }
        });
    };
    obj.updateSchool = function () {
        console.log("id:" + vm.id);
        console.log("data:" +  vm.$data);
        $.ajax({
            url: '/schools/1',
            dataType: 'json',
            method: 'PUT',
            data: vm.$data,
            success: function(result){
                // vm.$data = result;
            }
        });
    };
    return obj;
}


