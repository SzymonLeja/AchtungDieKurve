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
     *
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Road generate() {
        Random random = new Random();
        return generateInternal(random.nextInt()%656);
    }

    /**
     * Metoda wywolujaca generowanie samochodu o losowych parametrach z zadanym wczesniej ziarnem
     *
     * @param seed zadane ziarno
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Road generate(long seed) {
        return generateInternal((seed%3));
    }

    private Road generateInternal(long seed) {
        Random random = new Random(seed);
        RoadType type = new RoadType(seed);
        double grip = generateGrip(type, random);
        RoadTrack track = new RoadTrack(type.getType(), seed);
        Double cornerDegree = generateDegree(track, random);
        Obstacle obstacle = generateObstacle(track, random);
        return Road.builder()
                .grip(grip)
                .track(track)
                .type(type)
                .cornerDegree(cornerDegree)
                .obstacle(obstacle)
                .build();
    }

    private double generateGrip(RoadType type, Random random) {
        return random.nextDouble() * (type.getMaxGrip() - type.getMinGrip()) + type.getMinGrip();
    }

    private Obstacle generateObstacle(RoadTrack track, Random random) {
        List<Obstacle> obstacles = track.getPossibleObstacle();
        return obstacles.get(random.nextInt(obstacles.size()));
    }

    private double generateDegree(RoadTrack track, Random random) {
        if (!track.getTrack().toString().equals("STRAIGHT")){
            return random.nextDouble() * 100 + 30;
        }
        return 0;
    }
}
