package road;

import java.util.Random;

/**
 * Klasa przechowujaca mozliwe typy nawierzchni
 */
public enum RoadSurfaces {
    /**
     * Asfalt - najlepsze warunki drogowe
     **/
    ASPHALT(0.8, 0.5),
    /**
     * Zwir - srednie warunki drogowe
     **/
    GRAVEL(0.6, 0.3),
    /**
     * Piasek - najgorsze warunki drogowe
     **/
    SAND(0.4, 0.2),
    /**
     * Trawa - slabe warunki drogowe
     **/
    GRASS(0.5, 0.3);

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
    public static RoadSurfaces getRandomSurface(long seed) {
        return values()[new Random(seed).nextInt(Integer.SIZE -1) % (values().length)];
    }
}
