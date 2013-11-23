$(document).ready(function() {

    var activePlayer;
    var turn = 0;
    var symbol;
    var player1;
    var player2;

     
    //Input players
    $('#players').hide();
    $('#resetGame').hide();
    $('#rightBar').hide();


    $( "#enterPlayer1" ).click(function() {

        if($("#player1").val() != "")
        {
            $("#inputPlayer1").hide();
            $("#inputPlayer2").show();
            $('#message').hide();
        }
        else
        {
           $('#message').html('Vinsamlegast sláðu inn nafn').attr('class', 'alert alert-danger');  
        }
    });

    $("#player1").on("keypress", function(e) {

        if(e.which == 13)
        {
            if($("#player1").val() != "")
            {
            $("#inputPlayer1").hide();
            $("#inputPlayer2").show();
            $('#message').hide();
            }
        else
        {
           $('#message').html('Vinsamlegast sláðu inn nafn').attr('class', 'alert alert-danger');  
        }
    }
    });

    //Input player 2 and ajax submit
    $( "#enterPlayer2" ).click(function() {

        if($("#player2").val() != "")
        {
            player1 = $("#player1").val();
            player2 = $("#player2").val();
            startGame();  
            $('#message').hide();
        } 
         else
        {
           $('#message').html('Vinsamlegast sláðu inn nafn').attr('class', 'alert alert-danger');  
        }                 
    });

     $("#player2").on("keypress", function(e) {

        if($("#player2").val() != "" && e.which == 13)
        {
            player1 = $("#player1").val();
            player2 = $("#player2").val();
            startGame();  
        } 
         else
        {
           $('#message').html('Vinsamlegast sláðu inn nafn').attr('class', 'alert alert-danger');  
        }
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

        var cell = $(this).attr("id");
        var idOfCell = cell.slice(5);
        var cellId = '#' + cell;
        console.log("id: " + idOfCell);
        
        $.ajax({
            type: "POST",
            url: "/clickField",
            data: 'idOfCell=' + idOfCell + '&player=' + activePlayer
        }).done(function(obj) {
            
            var result = JSON.parse(obj);
            if(result.legal == 1)
            {
              $(cellId).append("<span class='token'>" + symbol + "</symbol>"); 
              $(cellId).addClass('played');           
              $('#X').html(result.playerName);          
              turn++;  
            }
            if(result.gameStatus == 1)
            {
                alert(player1 + " Vann leikinn, in yo face sucka!");
                resetGame();
                getWins();
            }
            if(result.gameStatus == 2)
            {
                alert(player2 + " Vann leikinn, in yo face sucka!");
                resetGame();
                getWins();
            }
              if(result.gameStatus == 3)
            {
                alert("Jafntefli, skammist ykkar!");
                resetGame();
                getWins();
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
        resetGame();
         location.reload();  
    })

    function resetGame()
    {      
         $.ajax({
            type: "POST",
            url: "/resetGame",           
        }).done(function() {
           console.log("cleared");          
           $('.gameCell').removeClass('played');          
        }).fail(function() {
            console.log("failed");
        });

        $('.token').remove();

        
    }

      function getWins()
        {      
             $.ajax({
                type: "GET",
                url: "/getWins",
               
            }).done(function(obj) {
              var result = JSON.parse(obj);


               $('#score1').html(result.player1wins);
               $('#score2').html(result.player2wins);
               $('#ties').html(result.ties);

              
            }).fail(function() {
                console.log("failed");
            });            
        }

    function startGame()
    {
        $.ajax({
            type: "POST",
            url: "/insertName",
            data: 'player1=' + player1 + '&player2=' + player2
        }).done(function(data) {
            var playerObject = JSON.parse(data);
            $('#X').append(playerObject.player1);
            $('#p1_score').append(playerObject.player1);
            $('#p2_score').append(playerObject.player2);
            $('#board').show();
            $("#inputPlayer2").hide();
            $('#players').show();
            $('#resetGame').show();
            $('#rightBar').show();

        }).fail(function() {
            $('#message').html('Vinsamlegast sláið inn bæði nöfnin').attr('class', 'alert alert-danger');
        });  
    }

});