package road;

import obstacle.Obstacle;

public class Road {
    private final double grip;
    private final RoadTrack track;
    private final Double cornerDegree;
    private final Obstacle obstacle;

    public Road(double grip, RoadTrack track, double cornerDegree, Obstacle obstacle) {
        this.grip = grip;
        this.track = track;
        this.cornerDegree = cornerDegree;
        this.obstacle = obstacle;
    }

    @Override
    public String toString() {
        return String.format(
                "Droga {type= %s, grip= %.2f, track: %s, cornerDegree: %s, obstacle: %s }",
                track.getType().getType(),
                grip,
                track.getTrack(),
                cornerDegree==0? "none": String.format("%.2f",cornerDegree),
                obstacle.toString());
    }

    public double getGrip() {
        return grip;
    }

    public RoadTrack getTrack() {
        return track;
    }

    public Double getCornerDegree() {
        return cornerDegree;
    }
}
