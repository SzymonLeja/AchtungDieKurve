package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarStatGeneratorTest {
    @Test
    public void carGenerator(){
        CarStatGenerator generator = new CarStatGenerator();
        Car generatedCar = generator.generate();
        System.out.println(generatedCar.toString());
        assertTrue(generatedCar!=null, "Car generator");
    }
}