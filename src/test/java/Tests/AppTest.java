package Tests;

import ClubsTrump.Application;
import ClubsTrump.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    private List<Player> players;
    private List<Player> dealers;
    private List<Player> callers;
    private Application application = new Application();

    @Before
    public void setUp() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        players = new ArrayList<>();
        dealers = new ArrayList<>();
        callers = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    @Test
    public void test_populate_dealers (){
        dealers = application.populateDealer(players);
        Assert.assertEquals(dealers.get(0), players.get(0));
        Assert.assertEquals(dealers.size(),players.size());
    }

    @Test
    public void test_next_dealer (){
        dealers = application.populateDealer(players);
        dealers = application.nextDealer(dealers);
        Assert.assertEquals(dealers.get(0), players.get(1));
    }

    @Test
    public void test_populate_callers (){
        callers = application.populateCaller(players);
        Assert.assertEquals(callers.get(0), players.get(0));
        Assert.assertEquals(callers.size(),players.size());
    }

    @Test
    public void test_next_caller (){
        callers = application.populateCaller(players);
        callers = application.nextCaller(callers);
        Assert.assertEquals(callers.get(0), players.get(1));
    }







//    public List<Player> populateDealer(List<Player> players){
//        for (int i = 0; i < players.size(); i++) {
//            dealers.add(players.get(i));
//        }
//        return dealers;
//    }
//    public List<Player> nextDealer(List<Player> dealers){
//        Player currentDealer = dealers.get(0);
//        dealers.remove(currentDealer);
//        dealers.add(currentDealer);
//        return dealers;
//    }
//
//    public List<Player> nextCaller(List<Player> callers){
//        Player currentCaller = callers.get(0);
//        callers.remove(currentCaller);
//        callers.add(currentCaller);
//        return callers;
//    }
//
//
//    public List<Player> populateCaller(List<Player> players){
//        Player firstDealer = players.get(0);
//        players.remove(firstDealer);
//        players.add(firstDealer);
//        for (int i = 0; i < players.size(); i++) {
//            callers.add(players.get(i));
//        }
//        return callers;
//    }


}
