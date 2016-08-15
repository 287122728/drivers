$(document).ready(function () {
    setInterval('showUnreadNews()',500000);
});

function showUnreadNews()
{
    $(document).ready(function() {
        $.ajax({
            type: "GET",
            url: "/schools",
            dataType: "json",
            success: function(msg) {
               console.log("成功！！！");
            }
        });
    });
}
