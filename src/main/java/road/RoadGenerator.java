package road;

import obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Random;

public class RoadGenerator {
    public Road generate() {
        return generateInternal(System.currentTimeMillis());
    }

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
        ArrayList<Obstacle> obstacles = track.getPossibleObstacle();
        return obstacles.get(random.nextInt(obstacles.size()));
    }

    private double generateDegree(RoadTrack track, Random random) {
        if (!track.getTrack().equals("Straight"))
            return random.nextDouble() * 100 + 30;
        return 0;
    }
}
