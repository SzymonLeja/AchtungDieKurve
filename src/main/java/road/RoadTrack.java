package road;

import obstacle.Obstacle;
import obstacle.ObstacleTypes;

import java.util.*;

/**
 * Klasa dobierajaca losowo przeszkode na drodze w zaleznosci od typu drogi
 */
public class RoadTrack {
    private final RoadDirections track;
    private List<Obstacle> possibleObstacle;

    static List<Obstacle> asphaltObstacles = (Arrays.asList(
            new Obstacle(ObstacleTypes.ROBOTYDROGOWE, 30),
            new Obstacle(ObstacleTypes.BABUSHKA, 10),
            new Obstacle(ObstacleTypes.PIESZY, 20),
            new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
    ));
    static List<Obstacle> gravelObstacles = (Arrays.asList(
            new Obstacle(ObstacleTypes.ROBOTYDROGOWE, 20),
            new Obstacle(ObstacleTypes.BABUSHKA, 5),
            new Obstacle(ObstacleTypes.PIESZY, 10),
            new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
    ));
    static List<Obstacle> sandObstacles = (Arrays.asList(
            new Obstacle(ObstacleTypes.BABUSHKA, 10),
            new Obstacle(ObstacleTypes.PIESZY, 20),
            new Obstacle(ObstacleTypes.ZWIERZE, 40),
            new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
    ));
    static List<Obstacle> grassObstacles = (Arrays.asList(
            new Obstacle(ObstacleTypes.BABUSHKA, 30),
            new Obstacle(ObstacleTypes.ZWIERZE, 20),
            new Obstacle(ObstacleTypes.NIC, Double.POSITIVE_INFINITY)
    ));

    /**
     * Konstruktor klasy
     *
     * @param roadType typ drogi do ktorej dobieramy przeszkode
     */
    public RoadTrack(RoadSurfaces roadType) {
        this.track = RoadDirections.getRandomDirection();
        setPossibleObstacle(roadType);
    }

    /**
     * Methoda zwracajaca przeszkode zawarta na drodze
     *
     * @return przeszkoda zawarta na drodze, mozliwa do wystapienia na danym typie drogi, razem z wymagana predkoscia do ominiecia zalezna od typu drogi
     */
    public RoadDirections getTrack() {
        return track;
    }

    private void setPossibleObstacle(RoadSurfaces track) {
        switch (track) {
            case ASFALT -> possibleObstacle = asphaltObstacles;
            case ZWIR -> possibleObstacle = gravelObstacles;
            case PIASEK -> possibleObstacle = sandObstacles;
            case TRAWA -> possibleObstacle = grassObstacles;
            default -> possibleObstacle = new ArrayList<>(Collections.singletonList(new Obstacle(ObstacleTypes.BABUSHKA, 90)));
        }
    }

    /**
     * Metoda zwracaja mozliwe przeszkody na danej drodze
     *
     * @return lista obiektow mozliwych typow przeszkod
     */
    public List<Obstacle> getPossibleObstacle() {
        return possibleObstacle;
    }
}
