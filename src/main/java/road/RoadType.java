package road;

public class RoadType {
    private String type;
    private double maxGrip;
    private double minGrip;

    public RoadType(String type, double maxGrip, double minGrip) {
        this.type = type;
        this.maxGrip = maxGrip;
        this.minGrip = minGrip;
    }
}
