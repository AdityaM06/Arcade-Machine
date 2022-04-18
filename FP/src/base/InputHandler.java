package base;

//Imports
import java.util.Scanner;

//Class to handle all types of inputs
public class InputHandler {
    //Initializing the scanner
    static Scanner input = new Scanner(System.in);

    //Get a string input
    public static String getStringInput(String msg){
        //Printing message and getting input
        System.out.print(msg);
        String userInput = input.nextLine();

        //Correcting for minor user errors
        userInput = userInput.toLowerCase();
        userInput = userInput.trim();

        //Returning the input
        return userInput;
    }

    //Get an integer input
    public static int getIntInput(String msg){
        //Printing message and returning user input
        System.out.print(msg);
        return input.nextInt();
    }

    //Get a character input
    public static char getCharInput(String msg){
        //Printing message
        System.out.print(msg);
        //Returning the first character of the user's input
        return input.next().charAt(0);
    }

    //Method to close the input
    public static void closeInput(){input.close();}
}
