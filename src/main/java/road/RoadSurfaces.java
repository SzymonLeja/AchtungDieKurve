package road;

import java.util.Random;

/**
 * Klasa przechowujaca mozliwe typy nawierzchni
 */
public enum RoadSurfaces {
    /**
    Asfalt - najlepsze warunki drogowe
     **/
    ASFALT,
    /**
    Zwir - srednie warunki drogowe
     **/
    ZWIR,
    /**
    Piasek - najgorsze warunki drogowe
     **/
    PIASEK,
    /**
    Trawa - slabe warunki drogowe
     **/
    TRAWA;

    /**
     * Metoda generujaca losowa nawierzchnie drogi
     * @return losowa nawierzchnia drogi
     */
    public static String getRandomSurface(){
        return values()[new Random().nextInt(values().length)].toString();
    }
}
