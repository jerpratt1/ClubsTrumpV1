package ClubsTrump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private UserInterface userInterface = new UserInterface();
    private Player player = new Player("");
    private Map<String, Player> playerRoster = new HashMap<>();
    private List<Player> players = new ArrayList<>();
    private List<Player> dealers = new ArrayList<>();
    private List<Player> callers = new ArrayList<>();
    private RoundSystem roundSystem = new RoundSystem();


    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {

        displayBanner();
        boolean running = true;
        while (running) {
            int choice = -1;
            choice = userInterface.printMenu();

            if (choice == 1) {
                optionOne(choice);
            } else if (choice == 2) {
                optionTwo(choice);
            } else if (choice == 3) {
                userInterface.printPlayers(players);
            } else if (choice == 4) {
                userInterface.printMessage("GAME OVER");
                running = false;
            } else {
                userInterface.printError("Invalid option selected.");
            }
        }
    }

    public void optionOne(int choice) {
        boolean running = true;
        while (running) {
            choice = userInterface.printAddPlayerMenu();
            if (choice == 1) {
                if(players.size() < 7){
                    String playerName = userInterface.printAddPlayerPrompt();
                    userInterface.playerAdded(playerName);
                    Player player = new Player(playerName.toUpperCase());
                    players.add(player);
                } else {
                    userInterface.printError("Roster Full");
                }
            } else if (choice == 2) {
                userInterface.printPlayers(players);
                String playerName = userInterface.printRemovePlayerPrompt();
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getPlayerName().equals(playerName.toUpperCase())) {
                        players.remove(players.get(i));
                        userInterface.printMessage("Player: " + playerName + " removed. \n");
                    } else if (players.isEmpty()) {
                        String error = "No players on roster.";
                        userInterface.printError(error);
                    } else {
                        String error = "Player not in roster.";
                        userInterface.printError(error);
                    }
                }


            } else if (choice == 3) {
                userInterface.printPlayers(players);
            } else if (choice == 4) {
                break;
            }
        }
    }

    public void optionTwo (int choice){
        int count = 0;
        userInterface.printPlayers(players);
        populateDealer(players);
        populateCaller(players);
        int[] rounds = roundSystem.roundOrder(players.size());
        while (count < 10){
            Player dealer = dealers.get(0);
            int currentHand = rounds[count];
            int cardsOut = 0;
            for (int i = 0; i < players.size(); i++) {
                Player caller = callers.get(0);
                int call = 0;
                if (i != players.size()-1){
                    call = userInterface.printDealAndCall(dealer, currentHand, cardsOut, caller);
                } else if (i == players.size()-1){
                    call = userInterface.printDealerCall(dealer, currentHand, cardsOut, caller);
                }
                caller.setPlayerCall(call);
                cardsOut = cardsOut + call;
                nextCaller(callers);
            }

            boolean running = true;
            while (running) {
                choice = userInterface.printRoundInProgress(currentHand, cardsOut);
                if (choice == 1) {
                    userInterface.printCurrentScores(players);
                } else if (choice == 2) {
                    userInterface.printFixErrorPrompt();
                } else if (choice == 3) {
                    break;
                }
            }

            for (int i = 0; i < players.size(); i++) {
                String playerName = callers.get(i).getPlayerName();
                int playerCall = callers.get(i).getPlayerCall();
                int playerTook = userInterface.printRoundEnd(currentHand, playerName, playerCall);
                callers.get(i).playerMade(playerTook);
            }
            nextDealer(dealers);
            nextCaller(callers);
            count++;
            userInterface.printCurrentScores(players);
        }

        userInterface.printEndGame(players);

    }

    public List<Player> nextDealer(List<Player> dealers){
        Player currentDealer = dealers.get(0);
        dealers.remove(currentDealer);
        dealers.add(currentDealer);
        return dealers;
    }

    public List<Player> nextCaller(List<Player> callers){
        Player currentCaller = callers.get(0);
        callers.remove(currentCaller);
        callers.add(currentCaller);
        return callers;
    }

    public List<Player> populateDealer(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            dealers.add(players.get(i));
        }
        return dealers;
    }

    public List<Player> populateCaller(List<Player> players){
        Player firstDealer = players.get(0);
        players.remove(firstDealer);
        players.add(firstDealer);
        for (int i = 0; i < players.size(); i++) {
            callers.add(players.get(i));
        }
        return callers;
    }

    public void displayBanner() {
        userInterface.printMessage("   _____ _       _           _______                         \n" +
                "  / ____| |     | |         |__   __|                        \n" +
                " | |    | |_   _| |__  ___     | |_ __ _   _ _ __ ___  _ __  \n" +
                " | |    | | | | | '_ \\/ __|    | | '__| | | | '_ ` _ \\| '_ \\ \n" +
                " | |____| | |_| | |_) \\__ \\    | | |  | |_| | | | | | | |_) |\n" +
                "  \\_____|_|\\__,_|_.__/|___/    |_|_|   \\__,_|_| |_| |_| .__/ \n" +
                "                                                      | |    \n" +
                "                                                      |_|    ");
        userInterface.printMessage("----------------------------------------------------------------");
        userInterface.printMessage("");
        userInterface.printMessage("----------------------------------------------------------------");
    }


}

