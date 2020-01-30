package main.dotaSearchAlgorithm;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

        System.out.println("Игра " + gameId + " началась");
    }
}
