package main.dotaSearchAlgorithm;


public class QueueFactory {
    public Queue createNewQueue(MMRType type) {
        Queue toReturn = null;
        switch (type) {
            case ANCIENT:
                toReturn = new Queue("ANCIENT");
                break;
            case DIVINE:
                toReturn = new Queue("DIVINE");
                break;
            case LEGEND:
                toReturn = new Queue("LEGEND");
                break;
            case CRUSADER:
                toReturn = new Queue("CRUSADER");
                break;
            case IMMORTAL:
                toReturn = new Queue("IMMORTAL");
                break;
            default:
                throw new IllegalArgumentException("Wrong Queue mmr type:" + type);

        }
        return  toReturn;

    }
}
