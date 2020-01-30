package main.dotaSearchAlgorithm;

import java.util.*;

public class Dota2SearchAlgorithm {
    static int gameID = 0;
    static int playerID = 0;

    private static List<Game> gameList = Collections.synchronizedList(new ArrayList<>());
    private static Queue playersDivineQueue = new Queue(1, "DIVINE");
    private static Queue playersLegendQueue = new Queue(2, "LEGEND");
    private static Queue playersCrusaderQueue = new Queue(3, "CRUSADER");
    private static Queue playersAncientQueue = new Queue(4, "ANCIENT");
    private static Queue playersImmortalQueue = new Queue(5, "IMMORTAL");

    public static void main(String[] args) {
        GameFactory gameFactory = new GameFactory();
        Scanner scanner = new Scanner(System.in);
        playersAncientQueue.start();
        playersLegendQueue.start();
        playersCrusaderQueue.start();
        playersImmortalQueue.start();
        playersDivineQueue.start();


        while (true) {
//            playerID = playerID + 1;
//            if (playersDivineQueue.size() == 10) {
//                gameID = gameID + 1;
//                Game game = gameFactory.createGame(gameID, "DIVINE", playersDivineQueue.deleteTenPPLForGame());
//                gameList.add(game);
//                String fromScanner = scanner.nextLine();
//                whatDoUWantToDo(fromScanner);
//            }
            String fromScanner = scanner.nextLine();
            whatDoUWantToDo(fromScanner);
        }


    }


    public static void whatDoUWantToDo(String fromScanner) {
        PlayersFactory playersFactory = new PlayersFactory();
        switch (fromScanner) {
            case "newPlayers":
                Random random = new Random();

                for (int i = 0; random.nextInt(10) > i; i++) {
                    addToQueue(showRandomPlayer(playersFactory, playerID));
                }

                break;
            case "gameList":
                gameList.get(0).getPlayersArrayList().forEach(x-> System.out.println(x.getMmr()));
                break;
            default:
                System.out.println("Вы ввели неверную команду");
        }
    }

    public static void addToQueue(Players player) {
        switch (player.getMmr()) {
            case "DIVINE":
                playersDivineQueue.addPlayerToQueue(player);
                break;
            case "IMMORTAL":
                playersImmortalQueue.addPlayerToQueue(player);
                break;
            case "CRUSADER":
                playersCrusaderQueue.addPlayerToQueue(player);
                break;
            case"LEGEND":
                playersLegendQueue.addPlayerToQueue(player);
                break;
            case "ANCIENT":
                playersAncientQueue.addPlayerToQueue(player);
        }
    }

    public static Players showRandomPlayer(PlayersFactory factory, int playerId){
        Players randomPlayer = getRandomPlayer(factory);
        randomPlayer.setPlayerId(playerId);
        randomPlayer.start();
        return randomPlayer;
    }

    public static Players getRandomPlayer(PlayersFactory factory){
        Random random = new Random();
        MMRType type = MMRType.values()[random.nextInt(MMRType.values().length)];

        return(factory.createNewPlayer(type));
    }


}
