package road;

import java.util.Random;

/**
 * Klasa przechowujace mozliwe kierunki nachylenia drogi
 */
public enum RoadDirections {
    /**
     * Droga przebiega prosto, brak zakretu
     */
    PROSTO,
    /**
     * Zakret przebiega w lewa strone
     */
    LEWO,
    /**
     * Zakret przebiega w prawa strone
     */
    PRAWO;

    /**
     * Metoda generujaca losowy kierunek nachylenia drogi
     * @return losowy kierunek nachylenia drogi
     */
    public static RoadDirections getRandomDirection(){
        return values()[new Random().nextInt(values().length)];
    }
}
