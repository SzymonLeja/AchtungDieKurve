package road;

import java.util.Random;

/**
 * Klasa losujaca typ drogi i ustawiajaca przedzialy jej przyczepnosci
 */
public class RoadType {
    private final String type;
    private final double maxGrip;
    private final double minGrip;

    /**
     * Konstruktor klasy, wybiera losowo powierzchnie drogi
     */
    public RoadType() {
        type = RoadSurfaces.getRandomSurface();
        switch (type) {
            case ("ASFALT") -> {
                maxGrip = 0.8;
                minGrip = 0.5;
            }
            case ("ZWIR") -> {
                maxGrip = 0.6;
                minGrip = 0.3;
            }
            case ("PIASEK") -> {
                maxGrip = 0.4;
                minGrip = 0.2;
            }
            case ("TRAWA") -> {
                maxGrip = 0.5;
                minGrip = 0.3;
            }
            default -> {
                maxGrip = Double.POSITIVE_INFINITY;
                minGrip = 0;
            }
        }
    }

    /**
     * Metoda zwracajaca typ nawierzchni
     * @return typ nawierzchni
     */
    public String getType() {
        return type;
    }
    /**
     * Metoda zwracajaca maskymalna przyczepnosc nawierzchni
     * @return maksymalna przyczepnosc nawierzchni
     */
    public double getMaxGrip() {
        return maxGrip;
    }
    /**
     * Metoda zwracajaca minimalna przyczepnosc nawierzchni
     * @return minimalna przyczepnosc nawierzchni
     */
    public double getMinGrip() {
        return minGrip;
    }
}
