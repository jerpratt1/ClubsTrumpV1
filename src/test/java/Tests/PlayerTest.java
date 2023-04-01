package Tests;

import ClubsTrump.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Jeremy");
        player.setPlayerCall(4);
    }

    @Test
    public void test_player_made() {
        player.playerMade(4);
        Assert.assertEquals(14, player.getPlayerScore());
    }

    @Test
    public void test_player_fell() {
        player.playerMade(0);
        Assert.assertEquals(0, player.getPlayerScore());

    }
}
