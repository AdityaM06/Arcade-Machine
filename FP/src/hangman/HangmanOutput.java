package hangman;

import base.GameOutput;

//Class to handle hangman outputs
public class HangmanOutput implements GameOutput{
    //Method to greet the player
    @Override
    public String greetPlayer() {
        return "Welcome to hangman!";
    }

    //Method to show the rules
    @Override
    public String showRules() {
        return "In this game, you'll guess letters to a word until you guess the word, or lose all of your attempts";
    }

    //Method to print the input message
    @Override
    public String requestInput() {
        return "Please enter a letter: ";
    }

}
