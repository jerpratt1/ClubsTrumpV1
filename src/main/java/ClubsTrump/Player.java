package ClubsTrump;

public class Player {
    private String playerName;
    private int playerScore;
    private int playerCall;





    public Player (String playerName){
        this.playerName = playerName;
        this.playerScore = 0;
        this.playerCall = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }


    public void setPlayerCall(int playerCall) {
        this.playerCall = playerCall;
    }

    public int getPlayerCall() {
        return playerCall;
    }

    public void playerMade(int playerTook){
        if(playerTook == playerCall){
            this.playerScore = playerScore + playerCall + 10;
        } else{
            this.playerScore = playerScore + playerTook;
        }
    }

}
