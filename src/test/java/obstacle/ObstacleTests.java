package obstacle;

import org.junit.jupiter.api.Test;
import obstacle.Obstacle;
import road.Road;

import road.RoadGenerator;
import road.RoadTrack;
import road.RoadType;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstacleTests {
    @Test
    public void roadCheckRequiredSpeed(){
        Random random = new Random(555);
        RoadType type = new RoadType(555);
        RoadTrack track = new RoadTrack(type.getType(), 555);
        List<Obstacle> obstacles = track.getPossibleObstacle();
        Obstacle testedObstacle = obstacles.get(random.nextInt(obstacles.size()));
        assertEquals(30.0, testedObstacle.getRequiredSpeed());
    }
    @Test
    public void roadCheckObstacleType(){
        Random random = new Random(555);
        RoadType type = new RoadType(555);
        RoadTrack track = new RoadTrack(type.getType(), 555);
        List<Obstacle> obstacles = track.getPossibleObstacle();
        Obstacle testedObstacle = obstacles.get(random.nextInt(obstacles.size()));
        assertEquals("BABUSHKA", testedObstacle.getObstacleType().toString());
    }
}
