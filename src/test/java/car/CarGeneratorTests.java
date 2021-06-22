package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarGeneratorTests {
    @Test
    public void carGeneratorCheckIfGeneratedIsNotNull(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate();
        System.out.println(generatedCar.toString());
        assertNotNull(generatedCar, "Car generator");
    }
    @Test
    public void carGeneratorCheckIfGeneratedProperlyWithGivenSeed(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(2137);
        assertEquals(14.405508155059351,generatedCar.getCurrentSpeed());
    }
}