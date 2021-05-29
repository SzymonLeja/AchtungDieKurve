package road;

import car.Car;
import car.CarStatGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadGeneratorTest {

    @Test
    public void roadGenerator(){
        RoadGenerator generator = new RoadGenerator();
        Road generatedRoad = generator.generate();
        System.out.println(generatedRoad.toString());
        assertNotNull(generatedRoad, "Car generator");

    }
    @Test
    public void roadGenerator2(){
        RoadGenerator generator = new RoadGenerator();
        Road generatedRoad = generator.generate(0);
        System.out.println(generatedRoad.toString());
        assertNotNull(generatedRoad, "Car generator 2");
    }
}