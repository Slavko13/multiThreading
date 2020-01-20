package main.dotaSearchAlgorithm;

public class Players extends Thread {
    private int playerId;
    private String mmr;

    public Players(String mmr) {
        this.mmr = mmr;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }


    public String getMmr() {
        return mmr;
    }

    public void setMmr(String mmr) {
        this.mmr = mmr;
    }

    @Override
    public void run() {
//        System.out.println("New player is here " + Thread.currentThread().getName());
    }

}
