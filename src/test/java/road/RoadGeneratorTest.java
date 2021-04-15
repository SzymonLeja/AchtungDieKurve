package road;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class RoadGeneratorTest {
    @Test
    public void RoadGeneratorTest(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road generatedRoad = roadGenerator.generate();
        System.out.println(generatedRoad.toString());
        assertNotNull(generatedRoad);
    }

    @Test
    public void RoadGeneratorTest2(){
        RoadGenerator roadGenerator = new RoadGenerator();
        Road generatedRoad = roadGenerator.generate(1);
        System.out.println(generatedRoad.toString());
        assertNotNull(generatedRoad);
    }
}