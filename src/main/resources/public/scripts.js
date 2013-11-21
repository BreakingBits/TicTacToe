$(document).ready(function() {

    var form1 = $('form#insertName');
    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    $( "#enterPlayer2" ).click(function(e) {
        var p1 = $("#player1").val();
        var p2 = $("#player2").val();
        $.ajax({
            type: form1.attr('method'),
            url: form1.attr('action'),
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

    var form2 = $('form#clickField');
    $( ".gameField" ).click(function(e) {
        var field = $(this).attr("id");
        var idOfField = field.slice(5);
        console.log("id: " + idOfField);

        $.ajax({
            type: form2.attr('method'),
            url: form2.attr('action'),
            data: 'idOfField=' + idOfField
        }).done(function(obj) {
            console.log(obj);
        }).fail(function() {
            console.log("feeeeil!");
        });

        e.preventDefault();
    });



    /*
    $( ".gameField" ).click(function(e) {
        var field = $(this).attr("id");
        var idOfField = field.slice(5);
        console.log("id: " + idOfField);

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'clicked=' + idOfField
        }).done(function(obj) {
            console.log(obj);
        }).fail(function() {
            console.log("feeeeil!");
        });

        e.preventDefault();
    });
    */

    $(document).keypress(function(e){
        if (e.which == 13 && $("#player1").is(":focus")){
            e.preventDefault();
            $("#enterPlayer1").click();
            $('#player2').focus();
        }
    });

});