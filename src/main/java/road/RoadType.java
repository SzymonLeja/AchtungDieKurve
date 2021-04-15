package road;

public class RoadType {
    private RoadTypeEnum type;
    private double maxGrip;
    private double minGrip;

    public RoadType(RoadTypeEnum type, double maxGrip, double minGrip) {
        this.type = type;
        this.maxGrip = maxGrip;
        this.minGrip = minGrip;
    }

    public RoadTypeEnum getType() {
        return type;
    }

    public double getMaxGrip() {
        return maxGrip;
    }

    public double getMinGrip() {
        return minGrip;
    }
}
