package rockpaperscissors;

//Imports
import base.*;
import java.util.Random;

//Rock paper scissors game class
public class RockPaperScissors extends SimpleGame implements Playable {
    //Constants and Variables
    String userMove, computerMove, didWin;
    static int score = 0;

    //Constructor
    public RockPaperScissors() {
        super(new RockPaperScissorsOutput());
    }

    //Generating computer move
    private void computerMove(){
        //Initializing the random class
        Random num = new Random();

        //Making a list of possible moves
        String[] possibleMoves = {"rock", "paper", "scissors"};

        //Returning a random element from the list
        computerMove = possibleMoves[num.nextInt(possibleMoves.length)];

        //Informing the user that the computer has generated its move
        System.out.println("The computer has made its move");
    }

    //Method to calculate who won the game
    private String whoWon(){
        //Checking if the user tied
        if (userMove.equals(computerMove)){
            return ConsoleColour.YELLOW + "You Tied!" + ConsoleColour.RESET;
        }

        //Comparing the user move to the computer move
        switch (userMove){
            case "rock":
                return (computerMove.equals("paper"))? ConsoleColour.RED + "You Lose!" + ConsoleColour.RESET :
                        ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET;
            case "paper":
                return (computerMove.equals("scissors"))? ConsoleColour.RED + "You Lose!" + ConsoleColour.RESET :
                        ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET;
            case "scissors":
                return (computerMove.equals("rock"))? ConsoleColour.RED + "You Lose!" + ConsoleColour.RESET :
                        ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET;
            default:
                //In case the user doesn't input a valid input
                System.out.println("Invalid entry");
                //Getting the input again and running through this function again
                userMove = InputHandler.getStringInput(super.output.requestInput());
                whoWon();
        }
        return "";
    }

    //Game code
    @Override
    public void play() {
        //Greeting the player
        super.play();

        //Generating computer move and inputting userMove
        computerMove();
        userMove = InputHandler.getStringInput(super.output.requestInput());

        //Printing results
        System.out.println(whoWon());

        //Printing the computer move
        System.out.println("The computer chose " + ConsoleColour.CYAN + computerMove
                + ConsoleColour.RESET);

        //Increasing the score when the user wins
        if (whoWon().equals(ConsoleColour.GREEN + "You Win!" + ConsoleColour.RESET)){
            score += 1;
        }

        //Printing the current score
        System.out.println("Score: " + score);

        //Method to go again
        goAgain();
    }
}
