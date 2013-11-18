$(document).ready(function() {

    var form = $('form#insertName');

    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    form.submit(function(e) {
        var p1 = $("#player1").val();
        var p2 = $("#player2").val();
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'p1=' + p1 + '&p2=' + p2
        }).done(function(obj) {
            $('#X').append(': ' + obj.p1);
            $('#O').append(': ' + obj.p2);
            $('#results').html('Djöfull gekk þetta vel! ' + obj.p1 + ' ooooog ' + obj.p2).attr('class', 'alert alert-success');
        }).fail(function() {
            $('#results').html('You fucked up son!').attr('class', 'alert alert-danger');
        });
        e.preventDefault();
    });
});