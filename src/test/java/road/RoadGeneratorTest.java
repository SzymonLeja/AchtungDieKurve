package road;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoadGeneratorTest {

    @Test
    public void roadGeneratorWorksWithoutSeed(){
        RoadGenerator generator = new RoadGenerator();
        Road generatedRoad = generator.generate();
        assertNotNull(generatedRoad, "Car generator");

    }
    @Test
    public void roadGeneratorWorksWithSeed(){
        RoadGenerator generator = new RoadGenerator();
        Road generatedRoad = generator.generate(2323);
        assertEquals(0.3490780756391703,generatedRoad.getGrip() );
    }
}