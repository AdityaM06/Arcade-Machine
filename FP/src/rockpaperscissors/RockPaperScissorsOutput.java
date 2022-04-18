package rockpaperscissors;

import base.GameOutput;

//Rock paper scissors outputs class
public class RockPaperScissorsOutput implements GameOutput {
    //Method to greet the user
    @Override
    public String greetPlayer() {
        return "Welcome to Rock Paper Scissors, where you'll play against the computer!";
    }

    //Method to show the rules
    @Override
    public String showRules() {
        return "You'll simply enter either Rock, Paper or Scissors and the computer will generate a completely random " +
                "move\nThe computer will then calculate who won, or if there was a tie";
    }

    //Method to show a message when inputting
    @Override
    public String requestInput() {
        return "Please enter either Rock Paper or Scissors: ";
    }

}