$(document).foundation()

function getMessages() {
    $("#chat").load("get_messages/");
}

function addMsg() {
    var userName = $("#user_name").val();
    var Msg = $("#user_message").val();

    $.get( "add_message/", { name: userName, message: Msg } )
        .done(function() {
            getMessages();
        });
}

$("#send_msg_button").click(function() {
    addMsg();
});

getMessages();

setInterval(getMessages, 3000);
