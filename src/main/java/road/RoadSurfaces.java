package road;

import java.util.Random;

/**
 * Klasa przechowujaca mozliwe typy nawierzchni
 */
public enum RoadSurfaces {
    /**
     * Asfalt - najlepsze warunki drogowe
     **/
    ASFALT(0.8, 0.5),
    /**
     * Zwir - srednie warunki drogowe
     **/
    ZWIR(0.6, 0.3),
    /**
     * Piasek - najgorsze warunki drogowe
     **/
    PIASEK(0.4, 0.2),
    /**
     * Trawa - slabe warunki drogowe
     **/
    TRAWA(0.5, 0.3);

    public final double maxGrip;
    public final double minGrip;

    /**
     * Konstruktor enuma, przypisuje maksymalną oraz minimalną przyczepność danej nawierzchni
     *
     * @param maxGrip maksymalna przyczepność
     * @param minGrip minimalna przyczepność
     */
    RoadSurfaces(double maxGrip, double minGrip) {
        this.maxGrip = maxGrip;
        this.minGrip = minGrip;
    }

    /**
     * Metoda generujaca losowa nawierzchnie drogi
     *
     * @return losowa nawierzchnia drogi
     */
    public static RoadSurfaces getRandomSurface() {
        return values()[new Random().nextInt(values().length)];
    }
}
