package main.dotaSearchAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {
    private List<Game> games = new ArrayList<>();

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGameToList(Game game) {
        games.add(game);
    }

    public Game createGame(int i, String mmrRange, ArrayList<Players> players) {
        Game game = new Game(i, mmrRange, players);
        addGameToList(game);
        game.start();
        return game;
    }

}
