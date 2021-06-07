package road;

import obstacle.Obstacle;
import obstacle.ObstacleTypes;

import java.util.*;

public class RoadTrack {
    private final String track;
    private List<Obstacle> possibleObstacle;

    public RoadTrack( String roadType) {
        this.track = generateTrack();
        setPossibleObstacle(roadType);
    }

    public String getTrack() {
        return track;
    }

    private void setPossibleObstacle(String track) {
        List<Obstacle> asphaltObstacles = (Arrays.asList(
                new Obstacle(ObstacleTypes.ROBOTYDROGOWE, 30),
                new Obstacle(ObstacleTypes.BABUSHKA, 10),
                new Obstacle(ObstacleTypes.PIESZY, 20),
                new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
        ));
        List<Obstacle> gravelObstacles = (Arrays.asList(
                new Obstacle(ObstacleTypes.ROBOTYDROGOWE, 20),
                new Obstacle(ObstacleTypes.BABUSHKA, 5),
                new Obstacle(ObstacleTypes.PIESZY, 10),
                new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
        ));
        List<Obstacle> sandObstacles = (Arrays.asList(
                new Obstacle(ObstacleTypes.BABUSHKA, 10),
                new Obstacle(ObstacleTypes.PIESZY, 20),
                new Obstacle(ObstacleTypes.ZWIERZE, 40),
                new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
        ));
        List<Obstacle> grassObstacles = (Arrays.asList(
                new Obstacle(ObstacleTypes.BABUSHKA, 30),
                new Obstacle(ObstacleTypes.ZWIERZE, 20),
                new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
        ));
        switch (track) {
            case ("ASFALT") -> possibleObstacle = asphaltObstacles;
            case ("ZWIR") -> possibleObstacle = gravelObstacles;
            case ("PIASEK") -> possibleObstacle = sandObstacles;
            case ("TRAWA") -> possibleObstacle = grassObstacles;
            default -> possibleObstacle = new ArrayList<>(Collections.singletonList(new Obstacle(ObstacleTypes.BABUSHKA, 90)));
        }
    }

    public List<Obstacle> getPossibleObstacle() {
        return possibleObstacle;
    }

    private String generateTrack() {
        Random random = new Random(System.currentTimeMillis());
        return RoadDirections.values()[random.nextInt(RoadDirections.values().length)].toString();
    }
}
