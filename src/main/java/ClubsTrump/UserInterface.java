package ClubsTrump;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);




    public int printMenu() {

        System.out.println("(1) Player Menu");
        System.out.println("(2) Start Game");
        System.out.println("(3) Display Players");
        System.out.println("(4) Quit");
        System.out.println("");
        System.out.println("Please choose an option");
        String choice = scanner.nextLine();

        return Integer.parseInt(choice);

    }

    public int printAddPlayerMenu() {

        System.out.println("(1) Add Player");
        System.out.println("(2) Remove Player");
        System.out.println("(3) Display Players");
        System.out.println("(4) Return to Main Menu");
        System.out.println("");
        System.out.println("Please choose an option");
        String choice = scanner.nextLine();

        return Integer.parseInt(choice);

    }

    public String printAddPlayerPrompt() {
        System.out.println("Please enter Player Name:");
        String playerName = scanner.nextLine();

        return playerName;
    }

    public String printSelectDealer(){
        System.out.println("Select first Dealer:");
        String dealer = scanner.nextLine();

        return dealer;
    }

    public int printDealAndCall(Player dealer, int currentHand, int cardsOut, Player caller) {
        System.out.println("Current Dealer: " + dealer.getPlayerName());
        System.out.println("Cards to deal: " + currentHand);
        System.out.println("Cards out: " + cardsOut);
        System.out.println("");
        System.out.println("Player to call: " + caller.getPlayerName());
        System.out.println("Call: ");
        String call = scanner.nextLine();

        return Integer.parseInt(call);
    }

    public int printRoundInProgress(int currentHand, int cardsOut){
        int handsToOut = currentHand-cardsOut;
        String pushFight = "Fight";
        if (handsToOut >= 0){
            pushFight = "Push";
        }

        System.out.println("Round in Progress");
        System.out.println("Current Hand: " + currentHand);
        System.out.println("Cards Out: " + cardsOut);
        System.out.println(pushFight);
        System.out.println("");
        System.out.println("(1) Readout Scores");
        System.out.println("(2) Fix Error");
        System.out.println("(3) Round Over");
        String choice = scanner.nextLine();

        return Integer.parseInt(choice);
    }

    public int printRoundEnd(int currentHand, String playerName, int playerCall){
        System.out.println("Round Over:");
        System.out.println("Current Hand: " + currentHand);
        System.out.println("");
        System.out.println(playerName + " called " + playerCall);
        System.out.println("How many did " + playerName + " take?");
        String choice = scanner.nextLine();

        return Integer.parseInt(choice);
    }

    public void printCurrentScores (List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getPlayerName() +": " + players.get(i).getPlayerScore());
        }
    }

    public void printMessage (String message){
        System.out.println(message);
    }


    public void printError(String error){
        System.out.println(error);
    }


    public void printPlayers (List<Player> players){
        if(players.isEmpty()){
            System.out.println("No players on roster.");
            System.out.println("");
        } else {
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).getPlayerName());
            }
            System.out.println("");
        }
    }

    public String printRemovePlayerPrompt() {
        System.out.println("Please enter Player to remove:");
        String playerName = scanner.nextLine();


        return playerName;
    }

    public String printFixErrorPrompt(){
        return "Not Yet Implemented";
    }

    public void printEndGame(List<Player> players){
        System.out.println("---------------------------------");
        System.out.println("------------GAME OVER------------");
        System.out.println("---------------------------------");
        printCurrentScores(players);
    }

    public int printDealerCall(Player dealer, int currentHand, int cardsOut, Player caller) {
        int pushFight = currentHand-cardsOut;
        String cantCall = "";
        if (pushFight >= 0){
            cantCall = String.valueOf(pushFight);
        }


        System.out.println("Current Dealer: " + dealer.getPlayerName());
        System.out.println("Cards to deal: " + currentHand);
        System.out.println("Cards out: " + cardsOut);
        System.out.println("");
        System.out.println("Player to call: " + caller.getPlayerName());
        System.out.println("Dealer can't call: " + cantCall);
        System.out.println("Call: ");
        String call = scanner.nextLine();

        return Integer.parseInt(call);
    }

    public void playerAdded (String playerName){
        System.out.println("");
        System.out.println(playerName + " added.");
        System.out.println("");
    }

















}
