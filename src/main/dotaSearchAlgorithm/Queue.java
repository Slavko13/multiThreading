package main.dotaSearchAlgorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Queue extends Thread{
    private int queueId;
    private String mmrRange;
//    private new PriorityQueue<Players> playersPriorityQueue;


    public Queue(String mmrRange) {
        this.mmrRange = mmrRange;
    }

    private ArrayList<Players> playersPriorityQueue = new ArrayList<>();

    public ArrayList<Players> getPlayersPriorityQueue() {
        return playersPriorityQueue;
    }

    public void setPlayersPriorityQueue(ArrayList<Players> playersPriorityQueue) {
        this.playersPriorityQueue = playersPriorityQueue;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public String getMmrRange() {
        return mmrRange;
    }

    public void setMmrRange(String mmrRange) {
        this.mmrRange = mmrRange;
    }


    public Queue(int queueId, String mmrRange) {
        this.queueId = queueId;
        this.mmrRange = mmrRange;
    }

    public void addPlayerToQueue(Players players) {
        playersPriorityQueue.add(players);
        System.out.println(getMmrRange());
        System.out.println(playersPriorityQueue.size());
    }

    public Players takeFromQueue(){
        return playersPriorityQueue.remove(0);
    }

    public int size() {
        return playersPriorityQueue.size();
    }
    public ArrayList<Players> deleteTenPPLForGame() {
        ArrayList<Players> afterDeleteList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            afterDeleteList.add(playersPriorityQueue.remove(0));
        }

        return afterDeleteList;
    }




    @Override
    public void run() {
        GameFactory factory = new GameFactory();
        System.out.println("Очередь " + getMmrRange() + " готова ");

        

        factory.createGame(2, getMmrRange(), deleteTenPPLForGame());


    }
}
