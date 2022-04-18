//Imports
import base.Game;
import base.MainMenu;

//Main class used to start the game
public class Main {

    public static void main(String[] args) {
        //Initializing classes
        Game game = new Game();
        MainMenu mainMenu = new MainMenu();

        //Greeting the player and inputting then playing the game they input1
        mainMenu.greetPlayer();
        game.playGame(mainMenu.getUserInput());
    }
}
