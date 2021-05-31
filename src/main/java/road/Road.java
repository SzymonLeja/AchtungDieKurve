package road;

import obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Random;

public class Road {
    private final double grip;
    private final RoadType type;
    private final RoadTrack track;
    private final Double cornerDegree;
    private final Obstacle obstacle;

    public Road(double grip, RoadType type, RoadTrack track, Double cornerDegree, Obstacle obstacle) {
        this.grip = grip;
        this.type = type;
        this.track = track;
        this.cornerDegree = cornerDegree;
        this.obstacle = obstacle;
    }

    @Override
    public String toString() {
        return String.format(
                "Droga:\ntyp= %s,\nprzyczepnosc= %.2f,\nrodzaj zakretu= %s,\nstopien nachylenia: %s,\nprzeszkoda: %s\n ",
                type.getType(),
                grip,
                track.getTrack(),
                cornerDegree == 0 ? "nie ma" : String.format("%.2f", cornerDegree),
                obstacle.toString());
    }

    public double getGrip() {
        return grip;
    }

    public double getCornerDegree() {
        return cornerDegree;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }
}
