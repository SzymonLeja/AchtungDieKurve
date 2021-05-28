package road;

import obstacle.Obstacle;

import java.util.ArrayList;

public class RoadTrack {
    private String track;
    private ArrayList<Obstacle> possibleObstacle;

    public RoadTrack( String track, ArrayList<Obstacle> possibleObstacle) {
        this.track = track;
        this.possibleObstacle = possibleObstacle;
    }

    public String getTrack() {
        return track;
    }

    public ArrayList<Obstacle> getPossibleObstacle() {
        return possibleObstacle;
    }
}
