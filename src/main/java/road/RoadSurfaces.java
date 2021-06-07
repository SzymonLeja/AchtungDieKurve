package road;

import java.util.Random;

public enum RoadSurfaces {
    ASFALT,
    ZWIR,
    PIASEK,
    TRAWA;

    public static String getRandomSurface() {
        return values()[new Random().nextInt(values().length)].toString();
    }
}
