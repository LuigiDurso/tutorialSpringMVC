$(document).ready(function()
{
    $("#myFilter").on("keyup", function()
    {
        var value = $(this).val().toLowerCase();
        $("#employeesTable tr").filter(function()
        {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});