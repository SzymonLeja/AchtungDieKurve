package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarStatGeneratorTest {
    @Test
    public void carGenerator(){
        CarStatGenerator generator = new CarStatGenerator();
        Car generatedCar = generator.generate();
        System.out.println(generatedCar.toString());
        assertNotNull(generatedCar, "Car generator");

    }
    @Test
    public void carGenerator2(){
        CarStatGenerator generator = new CarStatGenerator();
        Car generatedCar = generator.generate(0);
        System.out.println(generatedCar.toString());
        assertNotNull(generatedCar, "Car generator 2");
    }
}