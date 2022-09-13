package com.playtika.models;

import java.util.Arrays;

public class GameSession {

    private String gameName;
    private int startTime;
    private int endTime;
    private Producer producer;
    private String[] players;

    public GameSession() {
        gameName = "";
        startTime = 0;
        endTime = 1;
        producer = Producer.PLAYTIKA;
    }

    public GameSession(String gameName, int startTime, int duration) {
        this.gameName = gameName;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.producer = Producer.PLAYTIKA;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String[] getPlayers() {
        if (this.players != null) {
            return Arrays.copyOf(this.players, this.players.length);
        } else return null;
    }

    public void setPlayers(String[] players) {
        if (players != null) {
            this.players = new String[players.length];
            System.arraycopy(players,0, this.players, 0, players.length);
        }
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public Object clone() {

        GameSession copy = new GameSession();
        copy.gameName = this.gameName;
        copy.startTime = this.startTime;
        copy.endTime = this.endTime;
        copy.producer = this.producer;
        copy.setPlayers(this.players);

        return copy;

    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else {
            GameSession gameSession = (GameSession) object;

            return  gameSession.gameName.equals(this.gameName) &&
                    gameSession.startTime == this.startTime &&
                    gameSession.endTime == this.endTime &&
                    gameSession.producer.equals(this.producer) &&
                    Arrays.equals(gameSession.players, this.players);

        }
    }

    public boolean checkPlayer(String player) {
        if (this.players != null) {
            for (String s : this.players) {
                if (s.equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void concatenate(GameSession gameSession) {

        if (this.gameName.equals(gameSession.gameName)) {
            this.startTime = this.startTime < gameSession.startTime ? this.startTime : gameSession.startTime;
            this.endTime = this.endTime > gameSession.endTime ? this.endTime : gameSession.endTime;
            this.producer =  gameSession.getProducer();
            // differentElements - number of players from the gameSession array which will be stored in the new array
            // differentElements is calculated to know the capacity of the new array
            int differentElements = 0;
            // total_length - the capacity of the new array
            int total_length = 0;
            if (gameSession.players != null) {
                for (String s : gameSession.players) {
                    if ( !this.checkPlayer(s) ) {
                        differentElements++;
                    }
                }
                total_length = differentElements;
            }

            if (this.players != null) {
                total_length += this.players.length;
            }
            // Auxiliary array to put all the players
            String[] players_copy = new String[total_length];

            int final_index = 0;
            // copy all the players from the first array
            if (this.players != null) {
                System.arraycopy(this.players, 0, players_copy, 0, this.players.length);
                final_index = this.players.length;
            }

            if (gameSession.players != null) {
                for (int i = 0; i < gameSession.players.length; i++) {
                    // this 'if' will remove duplicates
                    if (!this.checkPlayer(gameSession.players[i])) {
                        players_copy[final_index] = gameSession.players[i];
                        final_index++;
                    }
                }
            }
            this.setPlayers(players_copy);
        }
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "gameName='" + gameName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", producer=" + producer +
                ", players=" + Arrays.toString(players) +
                '}';
    }
}
