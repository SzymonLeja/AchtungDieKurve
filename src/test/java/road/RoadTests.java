package road;
import car.CarGenerator;
import car.Car;
import org.junit.jupiter.api.Test;
import simulation.Simulation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class RoadTests {
    @Test
    public void roadCheckCornerDegree(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(163);
        assertEquals(0.0, road.getCornerDegree());
    }
    @Test
    public void roadCheckGrip(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(2);
        assertEquals(0.5193440808059717, road.getGrip());
    }
    @Test
    public void roadCheckGetObstacle(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(5);
        assertEquals("BABUSHKA", road.getObstacle().toString());
    }

}
