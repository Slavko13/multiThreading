package main.dotaSearchAlgorithm;

import java.util.Random;

import static main.dotaSearchAlgorithm.PlayersMMRType.ANCIENT;
import static main.dotaSearchAlgorithm.PlayersMMRType.DIVINE;

public class PlayersFactory {
    public Players createNewPlayer(PlayersMMRType type) {
        Players toReturn = null;
        switch (type) {
            case ANCIENT:
                toReturn = new Players("ANCIENT");
                break;
            case DIVINE:
                toReturn = new Players("DIVINE");
                break;
            case LEGEND:
                toReturn = new Players("LEGEND");
                break;
            case CRUSADER:
                toReturn = new Players("CRUSADER");
                break;
            case IMMORTAL:
                toReturn = new Players("IMMORTAL");
                break;
            default:
                throw new IllegalArgumentException("Wrong players mmr type:" + type);

        }
        return  toReturn;

    }
}
