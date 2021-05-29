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
                new Obstacle(ObstacleEnum.RoadWork, 40),
                new Obstacle(ObstacleEnum.Babushka, 20),
                new Obstacle(ObstacleEnum.Pedestrian, 30),
                new Obstacle(ObstacleEnum.none, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> gravelObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.RoadWork, 40),
                new Obstacle(ObstacleEnum.Babushka, 20),
                new Obstacle(ObstacleEnum.Pedestrian, 30),
                new Obstacle(ObstacleEnum.none, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> sandObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.Babushka, 10),
                new Obstacle(ObstacleEnum.Pedestrian, 20),
                new Obstacle(ObstacleEnum.Animal, 50),
                new Obstacle(ObstacleEnum.none, Double.POSITIVE_INFINITY)
        ));
        ArrayList<Obstacle> grassObstacles = new ArrayList<>(Arrays.asList(
                new Obstacle(ObstacleEnum.Babushka, 30),
                new Obstacle(ObstacleEnum.Animal, 50),
                new Obstacle(ObstacleEnum.none, Double.POSITIVE_INFINITY)
        ));
        switch (track) {
            case ("Asphalt") -> possibleObstacle = asphaltObstacles;
            case ("Gravel") -> possibleObstacle = gravelObstacles;
            case ("Sand") -> possibleObstacle = sandObstacles;
            case ("Grass") -> possibleObstacle = grassObstacles;
            default -> possibleObstacle = new ArrayList<>(Collections.singletonList(new Obstacle(ObstacleEnum.Babushka, 90)));
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
