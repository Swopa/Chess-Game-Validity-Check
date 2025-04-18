This is a program which plays out a sequence of chess moves provided by pgn file and validates that game is legal and no illegal moves were performed.

To tackle this problem program translates moves into 2d array operations and includes validity check for every type of piece. It supports checking move direction and validity, if king is under check, long and short castling, no null captures, no team captures and translation
ensures that nothing will go outside the bounds. Minor problem for now is that I don't have en passant logic, but truth be told i only found out about this rule recently while working on this project so i'm planning to work on it if time gives me the ability to. Program also 
includes pgn parser and file reader which reads pgn files by destination and parses it as needed for the usage. Gives it more readable format for program to work as intended. 

Using the program is quite easy. You just replace filePath with wanted pgn file path inside the quotation marks.
```
String filePath = "src\\Tbilisi2015.pgn";
```

after this just press run. 

it takes in pgn file which contains texts of this form:

[Event "Tbilisi FIDE GP 2015"]
[Site "Tbilisi GEO"]
[Date "2015.02.25"]
[Round "9.6"]
[White "Jakovenko,D"]
[Black "Svidler,P"]
[Result "1/2-1/2"]
[WhiteTitle "GM"]
[BlackTitle "GM"]
[WhiteElo "2733"]
[BlackElo "2739"]
[ECO "D86"]
[Opening "Gruenfeld"]
[Variation "exchange, classical variation"]
[WhiteFideId "4122356"]
[BlackFideId "4102142"]
[EventDate "2015.02.15"]

1. d4 Nf6 2. c4 g6 3. Nc3 d5 4. cxd5 Nxd5 5. e4 Nxc3 6. bxc3 Bg7 7. Bc4 c5 8.
Ne2 Nc6 9. Be3 O-O 10. O-O b6 11. dxc5 Qc7 12. Nd4 Ne5 13. Nb5 Qb8 14. Be2 bxc5
15. f4 Ng4 16. Bxc5 a6 17. Na3 Qc7 18. Bd4 e5 19. fxe5 Nxe5 20. Qc1 Bg4 21. Bxg4
Nxg4 22. Qf4 Qxf4 23. Rxf4 Ne5 24. Rb1 Rad8 25. Nc2 Nc4 26. Rb4 Rc8 27. Ra4
Bxd4+ 28. Nxd4 Ne5 29. Rxa6 Rxc3 30. Rf1 Rc4 31. Nf3 Rxe4 1/2-1/2

It parses this texts game by game and then it parses the moves and plays each game individually.

It also visualises and writes each move individually like this:


RW  . BW QW RB  . KW  . 
PW  .  . NW  . PW PW  . 
 . PW  .  .  . NW  . PW 
 .  .  . PW  .  .  .  . 
 .  . PB PW  .  .  .  . 
 . BB  .  .  .  .  .  . 
PB  . PB NB  . PB PB PB 
RB  . BB QB  .  . KB  . 
Move: Qxe1
Looking for move to (0, 4) = e1 with disambiguation []
Checking white moves for Q to e1
Moving Q from d1 to e1
RW  . BW  . QW  . KW  . 
PW  .  . NW  . PW PW  . 
 . PW  .  .  . NW  . PW 
 .  .  . PW  .  .  .  . 
 .  . PB PW  .  .  .  . 
 . BB  .  .  .  .  .  . 
PB  . PB NB  . PB PB PB 
RB  . BB QB  .  . KB  . 


If it detects any illegal moves it writes "Illegal move detected:"
If it completes game it just says "Game xx end"

It runs every game and checks their validity and after it checks all it finishes.
