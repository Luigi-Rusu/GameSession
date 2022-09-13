package com.playtika.main;

import com.playtika.models.GameSession;

public class Main {
    public static void main(String[] args) {

        GameSession gameSession1 = new GameSession("game1",1,4);
        GameSession gameSession2 = new GameSession("game1",5,9);

        String[] s1 = {"ION" , "VASILE"};
        String[] s2 = {"ION" , "GABI"};

        gameSession1.setPlayers(s1);
        gameSession2.setPlayers(s2);

        gameSession1.concatenate(gameSession2);

        System.out.println(gameSession1);
    }
}
