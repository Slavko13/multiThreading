package main.dotaSearchAlgorithm;

import java.util.ArrayList;

public class GameFactory {

    public Game createGame(int i, String mmrRange, ArrayList<Players> players) {
        Game game = new Game(i, mmrRange, players);
        game.start();
        return game;
    }

}
