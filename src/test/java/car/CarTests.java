package car;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CarTests {
    @Test
    public void carCheckIfGettingSpeedWorks(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(94483984);
        assertEquals(9.244532708522053, generatedCar.getCurrentSpeed());
    }
    @Test
    public void carCheckIfSettingSpeedWorks(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate();
        generatedCar.setCurrentSpeed(999.999);
        assertEquals(999.999, generatedCar.getCurrentSpeed());
    }
    @Test
    public void carCheckIfAcceleratesProperlyWithoutRequiredSpeed(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(997);
        generatedCar.acceleration(0.8,1.2);
        assertEquals(5.869390540567731, generatedCar.getCurrentSpeed());
    }
    @Test
    public void carCheckIfAcceleratesProperlyWithRequiredSpeed(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(997);
        generatedCar.acceleration(0.8,1000, 999);
        assertEquals(13.200278718401004, generatedCar.getCurrentSpeed());
    }
    @Test
    public void carCheckIfBrakesProperly(){
        CarGenerator generator = new CarGenerator();
        Car generatedCar = generator.generate(69);
        assertEquals(232.29932634347497, generatedCar.braking(0.8,30));
    }
}
