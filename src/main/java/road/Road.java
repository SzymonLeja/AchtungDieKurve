package road;

public class Road {
    private RoadType type;
    private double grip;
    private RoadTrack track;
    private double cornerDegree;

    public Road(RoadType type, double grip, RoadTrack track, double cornerDegree) {
        this.type = type;
        this.grip = grip;
        this.track = track;
        this.cornerDegree = cornerDegree;
    }
}
