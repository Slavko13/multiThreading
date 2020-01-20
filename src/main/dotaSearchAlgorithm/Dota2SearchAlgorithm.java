package main.dotaSearchAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Dota2SearchAlgorithm {
    private static List<Game> gameList = Collections.synchronizedList(new ArrayList<>());
    private static Queue playersDivineQueue = new Queue(1, "DIVINE");
    private static Queue playersLegendQueue = new Queue(1, "LEGEND");
    private static Queue playersCrusaderQueue = new Queue(1, "CRUSADER");
    private static Queue playersAncientQueue = new Queue(1, "ANCIENT");
    private static Queue playersImmortalQueue = new Queue(1, "IMMORTAL");

    public static void main(String[] args) {
        PlayersFactory playersFactory = new PlayersFactory();
        GameFactory gameFactory = new GameFactory();

        for(int i = 0; i < 14; i++) {
            playersDivineQueue.addPlayerToQueue(showRandomPlayer(playersFactory, i));
            if(playersDivineQueue.size() == 10) {
              Game game = gameFactory.createGame(i, "DIVINE", playersDivineQueue.deleteTenPPLForGame());
              gameList.add(game);
            }
        }

        System.out.println(playersDivineQueue.size());
        System.out.println(gameList.get(0).getPlayersArrayList().size());

    }

    public static Players showRandomPlayer(PlayersFactory factory, int playerId){
        Players randomPlayer = getRandomPlayer(factory);
        randomPlayer.setPlayerId(playerId);
        randomPlayer.start();
        return randomPlayer;


    }

    public static Players getRandomPlayer(PlayersFactory factory){
        Random random = new Random();
        PlayersMMRType type = PlayersMMRType.values()[random.nextInt(PlayersMMRType.values().length)];

        return(factory.createNewPlayer(type));
    }


}
