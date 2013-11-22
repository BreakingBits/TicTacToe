$(document).ready(function() {

    var formAndInsertName = $('form#insertName');
    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    $( "#enterPlayer2" ).click(function(e) {
        var player1 = $("#player1").val();
        var player2 = $("#player2").val();
        $.ajax({
            type: formAndInsertName.attr('method'),
            url: formAndInsertName.attr('action'),
            data: 'player1=' + player1 + '&player2=' + player2
        }).done(function(data) {
            var playerObject = JSON.parse(data);
            $('#X').append(': ' + playerObject.player1);
            $('#O').append(': ' + playerObject.player2);
            $('#board').show();
            $("#inputPlayer2").hide();
        }).fail(function() {
            $('#message').html('Vinsamlegast sláið inn bæði nöfnin').attr('class', 'alert alert-danger');
        });
        e.preventDefault();
    });

    var formAndClickField = $('form#clickField');
    $( ".gameField" ).click(function(e) {
        var field = $(this).attr("id");
        var idOfField = field.slice(5);
        console.log("id: " + idOfField);

        $.ajax({
            type: formAndClickField.attr('method'),
            url: formAndClickField.attr('action'),
            data: 'idOfField=' + idOfField
        }).done(function(obj) {
            console.log(obj);
        }).fail(function() {
            console.log("feeeeil!");
        });

        e.preventDefault();
    });

    $(document).keypress(function(e){
        if (e.which == 13 && $("#player1").is(":focus")){
            e.preventDefault();
            $("#enterPlayer1").click();
            $('#player2').focus();
        }
    });

});