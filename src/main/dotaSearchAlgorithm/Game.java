package main.dotaSearchAlgorithm;

import java.util.ArrayList;

public class Game extends Thread {
    private int gameId;

    private String gameMmrRange;

    private ArrayList<Players> playersArrayList = new ArrayList<>();

    public Game(int gameId, String gameMmrRange, ArrayList<Players> playersArrayList) {
        this.gameId = gameId;
        this.gameMmrRange = gameMmrRange;
        this.playersArrayList = playersArrayList;
    }

    public ArrayList<Players> getPlayersArrayList() {
        return playersArrayList;
    }

    public String getGameMmrRange() {
        return gameMmrRange;
    }

    public void setGameMmrRange(String gameMmrRange) {
        this.gameMmrRange = gameMmrRange;
    }

    public void setPlayersArrayList(ArrayList<Players> playersArrayList) {
        this.playersArrayList = playersArrayList;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public void run() {
        System.out.println("Игра " + gameId + " началась");
    }
}
