package main.dotaSearchAlgorithm;

public class PlayersFactory {
    public Players createNewPlayer(MMRType type) {
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
