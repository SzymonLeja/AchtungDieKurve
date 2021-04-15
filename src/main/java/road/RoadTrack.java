package road;

import obstacle.Obstacle;

import java.util.ArrayList;

public class RoadTrack {
    private String track;
    private ArrayList<Obstacle> possibleObstacle;
    private RoadType type;

    public RoadTrack(RoadType type, String track, ArrayList<Obstacle> possibleObstacle) {
        this.type = type;
        this.track = track;
        this.possibleObstacle = possibleObstacle;
    }

    public String getTrack() {
        return track;
    }

    public RoadType getType() {
        return type;
    }

    public ArrayList<Obstacle> getPossibleObstacle() {
        return possibleObstacle;
    }
}
