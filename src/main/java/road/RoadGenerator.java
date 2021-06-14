package road;

import obstacle.Obstacle;

import java.util.List;
import java.util.Random;
/**
 * Klasa generujaca droge o losowych parametrach
 */
public class RoadGenerator {
    /**
     * Metoda wywolujaca generowanie drogi o losowych parametrach bez zadanego wczesniej ziarna
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Road generate() {
        return generateInternal(System.currentTimeMillis()%5);
    }
    /**
     * Metoda wywolujaca generowanie samochodu o losowych parametrach z zadanym wczesniej ziarnem
     * @param seed zadane ziarno
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Road generate(long seed) {
        return generateInternal(seed);
    }

    private Road generateInternal(long seed) {
        Random random = new Random(seed);
        RoadType type = new RoadType();
        double grip = generateGrip(type, random);
        RoadTrack track = new RoadTrack(type.getType());
        Double cornerDegree = generateDegree(track, random);
        Obstacle obstacle = generateObstacle(track, random);
        return new Road(grip, type, track, cornerDegree, obstacle);
    }

    private double generateGrip(RoadType type, Random random) {
        return random.nextDouble() * (type.getMaxGrip() - type.getMinGrip()) + type.getMinGrip();
    }
    private Obstacle generateObstacle(RoadTrack track, Random random) {
        List<Obstacle> obstacles = track.getPossibleObstacle();
        return obstacles.get(random.nextInt(obstacles.size()));
    }

    private double generateDegree(RoadTrack track, Random random) {
        if (!track.getTrack().equals("PROSTO"))
            return random.nextDouble() * 100 + 30;
        return 0;
    }
}
