package road;

import org.junit.jupiter.api.Test;
import car.Car;
import car.CarGenerator;
import obstacle.ObstacleTypes;
import road.Road;
import road.RoadGenerator;
import road.RoadCrash;
import simulation.Simulation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoadCrashTests {
    @Test
    public void roadCrashTestCorneringCrash() {
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(350);
        CarGenerator carGenerator = new CarGenerator();
        Car car = carGenerator.generate(1624481297232L);
        RoadCrash testCrash = new RoadCrash(car);
        assertEquals(true,testCrash.crash(road));
    }
    @Test
    public void roadCrashTestObstacleCrash() {
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(361);
        CarGenerator carGenerator = new CarGenerator();
        Car car = carGenerator.generate(1624481297232L);
        RoadCrash testCrash = new RoadCrash(car);
        assertEquals(true, testCrash.crash(road));
    }
    @Test
    public void roadCrashTestNoCorneringCrash() {
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(3621);
        CarGenerator carGenerator = new CarGenerator();
        Car car = carGenerator.generate(1624481297232L);
        RoadCrash testCrash = new RoadCrash(car);

        assertEquals(false, testCrash.crash(road));
    }
    @Test
    public void roadCrashTestNoObstacleCrash() {
        RoadGenerator roadGenerator = new RoadGenerator();
        Road road = roadGenerator.generate(-543531);
        CarGenerator carGenerator = new CarGenerator();
        Car car = carGenerator.generate(1624481297232L);
        RoadCrash testCrash = new RoadCrash(car);
        assertEquals(false, testCrash.crash(road));
    }
}
