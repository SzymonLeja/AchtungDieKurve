package road;

import java.util.Random;

/**
 * Klasa przechowujace mozliwe kierunki nachylenia drogi
 */
public enum RoadDirections {
    /**
     * Droga przebiega prosto, brak zakretu
     */
    STRAIGHT,
    /**
     * Zakret przebiega w lewa strone
     */
    LEFT,
    /**
     * Zakret przebiega w prawa strone
     */
    RIGHT;

    /**
     * Metoda generujaca losowy kierunek nachylenia drogi
     * @return losowy kierunek nachylenia drogi
     */
    public static RoadDirections getRandomDirection(long seed){
        return values()[new Random(seed).nextInt(values().length)];
    }
}
