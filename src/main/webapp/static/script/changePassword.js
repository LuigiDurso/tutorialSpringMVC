
$(document).ready(function()
{
    $(".validatedForm").validate({
        rules: {
            confirmPassword: {

                equalTo: "#newPassword"
            }
        },
        messages: {

            confirmPassword: {
                equalTo: "This field must be equals to new Password!"
            }
        },

        errorClass: "has-error"
    });
});