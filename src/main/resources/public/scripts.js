$(document).ready(function() {

    var form = $('form#insertName');

    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    $( "#enterPlayer2" ).click(function(e) {
        var p1 = $("#player1").val();
        var p2 = $("#player2").val();
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'p1=' + p1 + '&p2=' + p2
        }).done(function(obj) {
            $('#X').append(': ' + p1);
            $('#O').append(': ' + p2);
            $('#board').show();
            $("#inputPlayer2").hide();
        }).fail(function() {
            $('#message').html('Vinsamlegast sláið inn bæði nöfnin').attr('class', 'alert alert-danger');
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