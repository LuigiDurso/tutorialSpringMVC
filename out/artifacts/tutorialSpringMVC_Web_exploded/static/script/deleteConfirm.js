$(document).ready(function()
{
    $(".deleteBtn").click(function()
    {
        var url=$(this).attr("value");
        $("#myModal").modal();
        $("#confirmDelete").click(function ()
        {
            window.location=url;

        })
    });
});