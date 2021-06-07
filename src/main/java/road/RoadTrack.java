package road;

import obstacle.Obstacle;
import obstacle.ObstacleEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RoadTrack {
    private final String track;
    private ArrayList<Obstacle> possibleObstacle;

    public RoadTrack( String roadType) {
        this.track = generateTrack();
        setPossibleObstacle(roadType);
    }

    public String getTrack() {
        return track;
    }

    private void setPossibleObstacle(String track) {
        ArrayList<Obstacle> asphaltObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.ROBOTYDROGOWE, 30),
                new Obstacle(ObstacleEnum.BABUSHKA, 10),
                new Obstacle(ObstacleEnum.PIESZY, 20),
                new Obstacle(ObstacleEnum.NIC, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> gravelObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.ROBOTYDROGOWE, 20),
                new Obstacle(ObstacleEnum.BABUSHKA, 5),
                new Obstacle(ObstacleEnum.PIESZY, 10),
                new Obstacle(ObstacleEnum.NIC, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> sandObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.BABUSHKA, 10),
                new Obstacle(ObstacleEnum.PIESZY, 20),
                new Obstacle(ObstacleEnum.ZWIERZE, 40),
                new Obstacle(ObstacleEnum.NIC, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> grassObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.BABUSHKA, 30),
                new Obstacle(ObstacleEnum.ZWIERZE, 20),
                new Obstacle(ObstacleEnum.NIC, Double.POSITIVE_INFINITY)
        ));
        switch (track) {
            case ("ASFALT") -> possibleObstacle = asphaltObstacles;
            case ("ZWIR") -> possibleObstacle = gravelObstacles;
            case ("PIASEK") -> possibleObstacle = sandObstacles;
            case ("TRAWA") -> possibleObstacle = grassObstacles;
            default -> possibleObstacle = new ArrayList<>(Collections.singletonList(new Obstacle(ObstacleEnum.BABUSHKA, 90)));
        }
    }

    public ArrayList<Obstacle> getPossibleObstacle() {
        return possibleObstacle;
    }

    private String generateTrack() {
        Random random = new Random(System.currentTimeMillis());
        return RoadTrackEnum.values()[random.nextInt(RoadTrackEnum.values().length)].toString();
    }
}
