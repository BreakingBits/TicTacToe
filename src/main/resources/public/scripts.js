$(document).ready(function() {

    var activePlayer;
    var turn = 0;
    var symbol;

     $('#X').toggleClass('activePlayer');
    //Input players
   
    $( "#enterPlayer1" ).click(function() {
        $("#inputPlayer1").hide();
        $("#inputPlayer2").show();
    });

    //Input player 2 and ajax submit
    $( "#enterPlayer2" ).click(function(e) {
        var player1 = $("#player1").val();
        var player2 = $("#player2").val();


        $.ajax({
            type: "POST",
            url: "/insertName",
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


    //make move
    $( ".gameCell" ).click(function() {

        if(turn % 2 == 0)
        {
            activePlayer = 1
            symbol = "X";
            
        }
        else
        {
            activePlayer = 2;
            symbol = "O";
           
        }
        turn++;

        var cell = $(this).attr("id");
        var idOfCell = cell.slice(5);
        var cellId = '#' + cell;
        console.log("id: " + idOfCell);

        
        $.ajax({
            type: "POST",
            url: "/clickField",
            data: 'idOfCell=' + idOfCell + '&player=' + activePlayer
        }).done(function(obj) {
            console.log(obj);        
             //Vantar tékkið serverside eins og er
             if ($('#' + cell).contents().length == 0) 
             {
              $(cellId).append("<span class='token'>" + symbol + "</symbol>"); 
                $('#X').toggleClass('activePlayer');
             $('#O').toggleClass('activePlayer');
      
             }
             
        }).fail(function() {
            console.log("feeeeil!");
        });

       
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

        $('.token').remove();    
    })

});