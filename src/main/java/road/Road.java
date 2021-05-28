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

    public Road( RoadType type, RoadTrack track) {
        this.type = type;
        grip = generateGrip(this.type);
        this.track = track;
        cornerDegree = generateDegree(this.track);
        obstacle = generateObstacle(this.track);
    }

    @Override
    public String toString() {
        return String.format(
                "Droga {type= %s, grip= %.2f, track= %s, cornerDegree: %s, obstacle: %s }",
                type.getType(),
                grip,
                track.getTrack(),
                cornerDegree==0? "none": String.format("%.2f",cornerDegree),
                obstacle.toString());
    }

    public double getGrip() {
        return grip;
    }

    private double generateDegree(RoadTrack track){
        Random random = new Random(System.currentTimeMillis());
        if(!track.getTrack().equals("Straight"))
            return random.nextDouble()*100+30;
        return 0;
    }

    private double generateGrip(RoadType type){
        Random random = new Random(System.currentTimeMillis());
        return random.nextDouble()*(type.getMaxGrip()-type.getMinGrip())+ type.getMinGrip();
    }

    private Obstacle generateObstacle(RoadTrack track){
        Random random = new Random(System.currentTimeMillis());
        ArrayList<Obstacle> obstacles = track.getPossibleObstacle();
        return obstacles.get(random.nextInt(obstacles.size()));
    }
}
