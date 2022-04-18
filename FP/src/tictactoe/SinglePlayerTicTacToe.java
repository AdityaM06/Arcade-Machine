package tictactoe;

//Imports
import base.*;
import java.util.Random;

//Class for single player Tic Tac Toe game
public class SinglePlayerTicTacToe extends SimpleGame implements Playable {

    //Initializing
    char[][] gameBoard = new char[4][4];
    Random num = new Random();

    //Constants and variables
    final char emptySpace = '-';
    char playerSymbol;
    int userRow, userColumn, computerRow, computerColumn;
    static int score = 0;

    //Constructor
    public SinglePlayerTicTacToe() {
        super(new SinglePlayerTicTacToeOutput());

        //Setting up the game board
        for(int i = 0; i < 4; i++) {
            //Column Number
            gameBoard[0][i] = (char) (i + '0');
            for(int j = 0; j < 4; j++) {
                //Row Number
                gameBoard[j][0] = (char) (j + '0');
                //Setting each blank spot as -
                gameBoard[i][j] = emptySpace;
            }
        }
        //Setting the top corner to a space
        gameBoard[0][0] = ' ';
    }

    //Method to draw the gameboard
    public void drawBoard(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(gameBoard[i][j]);
            }
            //Making sure each row is on a different line
            System.out.println();
        }
    }

    //Method to check if a player won
    public boolean checkWin(){
        //Check each row
        for(int i = 1; i < 4; i++) {
            if(gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][2] == gameBoard[i][3] && gameBoard[i][1] != emptySpace) {
                if (gameBoard[i][1] == playerSymbol){
                    score++;
                    System.out.println(ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET);
                } else {
                    System.out.println(ConsoleColour.RED + "You Lost!" + ConsoleColour.RESET);
                }
                return true;
            }
        }

        //Check each column
        for(int j = 1; j < 4; j++) {
            if (gameBoard[1][j] == gameBoard[2][j] && gameBoard[2][j] == gameBoard[3][j] && gameBoard[1][j] != emptySpace) {
                if (gameBoard[1][j] == playerSymbol) {
                    if (gameBoard[j][1] == playerSymbol) {
                        score++;
                        System.out.println(ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET);
                    } else {
                        System.out.println(ConsoleColour.RED + "You Lost!" + ConsoleColour.RESET);
                    }
                    return true;
                }
            }
        }

        //Check the diagonals
        if(gameBoard[1][1] == gameBoard[2][2] && gameBoard[3][3] == gameBoard[2][2] && gameBoard[1][1] != emptySpace) {
            if (gameBoard[1][1] == playerSymbol) {
                score++;
                System.out.println(ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET);
            } else {
                System.out.println(ConsoleColour.RED + "You Lost!" + ConsoleColour.RESET);
            }
            return true;
        }
        if(gameBoard[3][1] == gameBoard[2][2] && gameBoard[2][2] ==  gameBoard[1][3] && gameBoard[3][1] != emptySpace) {
            if (gameBoard[3][1] == playerSymbol){
                score++;
                System.out.println(ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET);
            } else {
                System.out.println(ConsoleColour.RED + "You Lost!" + ConsoleColour.RESET);
            }
            return true;
        }

        //Returning false if no win was detected
        return false;
    }

    //Method to check if the board is full
    public boolean boardFull(){
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                //Checks for a '-' in the gameboard
                if(gameBoard[i][j] == emptySpace) {
                    return false;
                }
            }
        }
        //Printing tie
        System.out.println(ConsoleColour.YELLOW + "Tie!" + ConsoleColour.RESET);
        return true;
    }

    //Method to generate a computer move
    public void computerMove(){
        //Generating random places for the computer to move
        computerRow = num.nextInt(3) + 1;
        computerColumn = num.nextInt(3) + 1;

        //Making sure that spot isn't taken
        while (gameBoard[computerRow][computerColumn] != '-') {
            //Generating new random numbers
            computerRow = num.nextInt(3) + 1;
            computerColumn = num.nextInt(3) + 1;
        }

        //Updating the board
        gameBoard[computerRow][computerColumn] = 'O';
    }

    //Main game code
    @Override
    public void play(){
        super.play();

        //Inputting the user character
        playerSymbol = InputHandler.getCharInput("Please enter the character you would like to use on " +
                "the game board: ");
        while (playerSymbol == '-'){
            playerSymbol = InputHandler.getCharInput("Please do not use '-', enter a new character: ");
        }

        //Drawing the initial board
        drawBoard();

        //Game loop
        while (true){
            //Inputting the players move
            userColumn = InputHandler.getIntInput("Please enter which column number you want to play on: ");
            userRow = InputHandler.getIntInput("Please enter which row number you want to play on: ");

            //Making sure the player move is valid
            while (userRow < 1 || userRow > 3 || userColumn < 1 || userColumn > 3 ||
                    gameBoard[userRow][userColumn] != emptySpace){

                //Printing error message
                System.out.println(ConsoleColour.RED + "Those are invalid inputs, please enter row and column " +
                        "numbers between 1-3 and make sure that area isn't already taken: " + ConsoleColour.RESET);

                //Inputting user row and column again
                userColumn = InputHandler.getIntInput("Please enter which column number you want to play on: ");
                userRow = InputHandler.getIntInput("Please enter which row number you want to play on: ");
            }

            //Making the computer move and updating the board
            gameBoard[userRow][userColumn] = playerSymbol;
            computerMove();

            //Drawing the game board
            drawBoard();

            //Checks for a win or if the gameboard is full
            if (boardFull() || checkWin()){
                break;
            }

        }
        //Printing the score
        System.out.println("Score: " + score);

        //Method to go again
        goAgain();
    }
}
