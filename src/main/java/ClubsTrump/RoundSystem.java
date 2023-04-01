package ClubsTrump;

import java.util.List;

public class RoundSystem {


    public int[] roundOrder(int playerCount){
        int[] roundOrder = new int[10];
        if (playerCount == 4 || playerCount == 5){
            roundOrder = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        }
        else if (playerCount == 6){
            roundOrder = new int[] {6, 7, 8, 7, 6, 5, 4, 3, 2, 1};
        }
        else if (playerCount == 7){
            roundOrder = new int[] {4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        }

        return roundOrder;
    }




}
