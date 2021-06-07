package road;

import java.util.Random;

public class RoadType {
    private final String type;
    private final double maxGrip;
    private final double minGrip;

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

    public String getType() {
        return type;
    }

    private String generateType() {
        Random random = new Random(System.currentTimeMillis());
        return RoadSurfaces.values()[random.nextInt(RoadSurfaces.values().length)].toString();
    }

    public double getMaxGrip() {
        return maxGrip;
    }

    public double getMinGrip() {
        return minGrip;
    }
}
