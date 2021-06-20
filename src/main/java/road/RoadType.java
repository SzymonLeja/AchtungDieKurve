package road;

/**
 * Klasa losujaca typ drogi i ustawiajaca przedzialy jej przyczepnosci
 */
public class RoadType {
    private final RoadSurfaces type;
    private final double maxGrip;
    private final double minGrip;

    /**
     * Konstruktor klasy, wybiera losowo powierzchnie drogi
     */
    public RoadType() {
        type = RoadSurfaces.getRandomSurface();
        maxGrip = type.maxGrip;
        minGrip = type.minGrip;
    }

    /**
     * Metoda zwracajaca typ nawierzchni
     *
     * @return typ nawierzchni
     */
    public RoadSurfaces getType() {
        return type;
    }

    /**
     * Metoda zwracajaca maskymalna przyczepnosc nawierzchni
     *
     * @return maksymalna przyczepnosc nawierzchni
     */
    public double getMaxGrip() {
        return maxGrip;
    }

    /**
     * Metoda zwracajaca minimalna przyczepnosc nawierzchni
     *
     * @return minimalna przyczepnosc nawierzchni
     */
    public double getMinGrip() {
        return minGrip;
    }
}
