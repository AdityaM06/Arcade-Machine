package base;

//Class that holds common methods between all the games
public class SimpleGame {
    //Constants and Variables
    public GameOutput output;

    //Constructor
    public SimpleGame(GameOutput output){
        //Setting the output class
        this.output = output;

    }

    //Method to print the greeting and rules
    public void play(){
        //Printing the greeting
        System.out.println("\n\n" + output.greetPlayer());
        //Printing the rules
        System.out.println(output.showRules() + "\n");
    }

    //Method to go again
    public void goAgain(){
        //Creating a new game
        Game game = new Game();

        //Asking the user if they want to go again
        String goAgain = InputHandler.getStringInput("Do you want to go again (Yes or No): ");

        //Switch statement to check what the user inputted
        switch (goAgain){
            case "yes":
                //Starting the same game again
                System.out.println("Going again");
                game.playGame(MainMenu.userInput);
            case "no":
                //Going back to the main menu
                MainMenu mainMenu = new MainMenu();
                System.out.println("Going back to the main menu");

                //Printing the list of games and playing the game the user selecters
                mainMenu.listOfGames();
                game.playGame(mainMenu.getUserInput());
            default:
                //Goes through this method again
                System.out.println("Invalid answer");
                goAgain();
        }
    }
}
