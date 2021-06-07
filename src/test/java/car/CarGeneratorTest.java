package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarGeneratorTest {
    @Test
    public void carGenerator(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate();
        System.out.println(generatedCar.toString());
        assertNotNull(generatedCar, "Car generator");

    }
    @Test
    public void carGenerator2(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(0);
        System.out.println(generatedCar.toString());
        assertNotNull(generatedCar, "Car generator 2");
    }
}