package com.playtika.tests;

import com.playtika.models.GameSession;
import com.playtika.models.Producer;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class SessionTests {
    @Test
    public void getNameConstructor1Test() {
        GameSession gameSession = new GameSession();
        String name = gameSession.getGameName();
        assertEquals("the object returns another name", "", name);
    }
    @Test
    public void getNameConstructor2Test() {
        GameSession gameSession = new GameSession("name1", 1, 2);
        String name = gameSession.getGameName();
        assertEquals("the object returns another name", "name1", name);
    }
    @Test
    public void setNameTest() {
        GameSession gameSession = new GameSession();
        gameSession.setGameName("game");
        assertEquals("the object doesn't set the name", "game", gameSession.getGameName());
    }
    @Test
    public void getPlayersTest() {
        GameSession gameSession = new GameSession();
        String[] players = { "player1", "player2", "player3"};
        gameSession.setPlayers(players);
        String[] result = gameSession.getPlayers();
        assertArrayEquals("the object doesn't return the correct players", result, gameSession.getPlayers());
    }
    @Test
    public void setPlayersTest() {
        GameSession gameSession = new GameSession();
        String[] players = { "player1", "player2", "player3"};
        gameSession.setPlayers(players);
        String[] result = gameSession.getPlayers();
        assertArrayEquals("the object doesn't return the correct players", result, gameSession.getPlayers());
    }
    @Test
    public void getProducerTest() {
        GameSession gameSession = new GameSession();
        gameSession.setProducer(Producer.PLAYTIKA);
        assertEquals("the object doesn't return the corect Producer", Producer.PLAYTIKA, gameSession.getProducer());
    }
    @Test
    public void setProducerTest() {
        GameSession gameSession = new GameSession();
        gameSession.setProducer(Producer.PLAYTIKA);
        assertEquals("the object doesn't return the corect Producer", Producer.PLAYTIKA, gameSession.getProducer());
    }
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        GameSession gameSession = new GameSession();
        GameSession gameSession1 = (GameSession) gameSession.clone();
        assertEquals("The object are not the same", gameSession, gameSession1);
    }
    @Test
    public void checkPlayerTest() {
        GameSession gameSession = new GameSession();
        String player = "player1";
        String[] players = { "player1", "player2", "player3" };
        gameSession.setPlayers(players);
        assertTrue("checkPlayers isn't working", gameSession.checkPlayer(player));
    }
    @Test
    public void concatenateTest() {
        GameSession gameSession1 = new GameSession();
        GameSession gameSession2 = new GameSession();

        String[] s1 = {"ION" , "VASILE"};
        String[] s2 = {"ION" , "GABI"};
        String[] s3 = {"ION", "VASILE", "GABI"};

        gameSession1.setPlayers(s1);
        gameSession2.setPlayers(s2);

        gameSession1.concatenate(gameSession2);

        assertArrayEquals("Concatenate method isn't working", s3, gameSession1.getPlayers() );
    }

}
