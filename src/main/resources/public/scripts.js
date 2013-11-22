$(document).ready(function() {


    //Input players
    var formAndInsertName = $('form#insertName');
    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    //Input player 2 and ajax submit
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
    $( ".gameCell" ).click(function(e) {
        var cell = $(this).attr("id");
        var idOfCell = cell.slice(5);
        console.log("id: " + idOfCell);

        $.ajax({
            type: formAndClickField.attr('method'),
            url: formAndClickField.attr('action'),
            data: 'idOfCell=' + idOfCell
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

    //Reset button, clears grid
    $('#resetGame').on('click', function(e) {

         $.ajax({
            type: "POST",
            url: "/resetGame",
           
        }).done(function() {
           console.log("cleared");
        }).fail(function() {
            console.log("failed");
        });    
    })

});