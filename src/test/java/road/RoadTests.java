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
        Road road = roadGenerator.generate(-12);
//        CarGenerator carGenerator = new CarGenerator();
//        Car car = carGenerator.generate(1624481297232L);
//        Simulation simulation = new Simulation(car);
//        simulation.simulate(1);
        assertEquals(0.0, road.getCornerDegree());
    }
    @Test
    public void roadCheckGrip(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(434);
        assertEquals(0.5193440808059717, road.getGrip());
    }
    @Test
    public void roadCheckGetObstacle(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(4343);
        System.out.println(road.getObstacle());
        assertEquals("BABUSHKA", road.getObstacle().toString());
    }

}
