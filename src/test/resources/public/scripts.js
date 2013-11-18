$(document).ready(function() {

    var form = $('form#initPlayers');

    

    form.submit(function(e) {
        var a = $("#a").val();
        var b = $("#b").val();
        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: 'a=' + a + '&b=' + b
        }).done(function(sum) {
            $('#results').html(a + ' + ' + b + ' = ' + sum).attr('class', 'alert alert-success');
        }).fail(function() {
            $('#results').html('Villa kom upp við að leggja saman "' + a + ' + ' + b + '"').attr('class', 'alert alert-danger');
        });
        e.preventDefault();
    });
});