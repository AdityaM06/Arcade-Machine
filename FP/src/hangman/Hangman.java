package hangman;

//Imports
import base.*;
import java.util.Random;

public class Hangman extends SimpleGame implements Playable {
    //Initializing
    Random num = new Random();
    String[] wordsToGuess = {"computers", "cpu", "gigabyte", "java", "python", "coding", "eclipse", "laptop",
            "desktop", "algorithm", "application", "program", "binary", "data", "encryption", "hardware",
    "software", "malware", "memory", "network", "windows", "mac"};

    //Constants and variables
    int count;
    String word, dashes, guess;
    static int score = 0;

    //Constructor
    public Hangman() {
        super(new HangmanOutput());

        //Generating a new word to guess and the corresponding dashes
        word = wordsToGuess[(int) (Math.random() * wordsToGuess.length)];
        dashes = new String(new char[word.length()]).replace("\0", "-");
    }

    //Method to print hangman images
    public void hangmanImage() {
        //Printing the amount of attempts they have
        System.out.println("Attempts left: " +  (7 - count));

        if (count == 7) {
            System.out.println(ConsoleColour.RED + "GAME OVER!" + ConsoleColour.RESET);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(ConsoleColour.RED + "GAME OVER! The word was " + ConsoleColour.CYAN + word +
                    ConsoleColour.RESET);
        }
        if (count == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (count == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
    }

    //Method to register the users guess and update the dashes
    public void registerGuess() {
        //Temporary variable
        String newDash = "";

        //Loop to iterate through every character in the word
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                //Updating the dashes if the user got a guess correctly
                newDash += guess.charAt(0);
            } else if (dashes.charAt(i) != '-') {
                //Updating the dashes to keep previously guessed letters in the dashes
                newDash += word.charAt(i);
            } else {
                //Putting - for letters that aren't guessed
                newDash += "-";
            }
        }


        if (dashes.equals(newDash)) {
            //If the user didn't guess the letter correct
            count++;
            hangmanImage();
        } else {
            //Updating the dashes
            dashes = newDash;
        }
        if (dashes.equals(word)) {
            //If the user guessed the word
            System.out.println(ConsoleColour.GREEN + "You Win! The word was: " +
                    ConsoleColour.CYAN + word + ConsoleColour.RESET);

            //Increasing the score
            score++;
        }
    }

    //Game code
    @Override
    public void play() {
        super.play();

        //Printing the word theme
        System.out.println("The theme is Computers, here is the dashes that represent the word");

        //Getting a guess
        while (count < 7 && dashes.contains("-")){
            //Printing the dashes and getting an input
            System.out.println(dashes);
            guess = InputHandler.getStringInput(super.output.requestInput());
            //Registering the user guess
            registerGuess();
        }

        //Printing the score then asking the user if they want to go again
        System.out.println("Your score: " + score);
        goAgain();
    }
}
