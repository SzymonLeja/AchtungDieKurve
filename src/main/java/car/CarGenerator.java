package car;

import java.util.Random;

public class CarStatGenerator {
    public Car generate() {
        return generateInternal(System.currentTimeMillis());
    }

    public Car generate(long seed) {
        return generateInternal(seed);
    }

    private Car generateInternal(long seed) {
        Random random = new Random(seed);
        return new Car(random.nextInt(400) + 40, random.nextDouble() * 900 + 800, random.nextDouble()*15+5);
    }
}
