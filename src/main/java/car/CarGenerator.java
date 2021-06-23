package car;

import java.util.Random;
/**
 * Klasa generujaca samochod o losowych parametrach
 */
public class CarGenerator {
    /**
     * Metoda wywolujaca generowanie samochodu o losowych parametrach bez zadanego wczesniej ziarna
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Car generate() {
        return generateInternal(System.currentTimeMillis());
    }
    /**
     * Metoda wywolujaca generowanie samochodu o losowych parametrach z zadanym wczesniej ziarnem
     * @param seed zadane ziarno
     * @return Samochod wygenerowany na podstawie ziarna
     */
    public Car generate(long seed) {
        return generateInternal(seed);
    }

    private Car generateInternal(long seed) {
        Random random = new Random(seed);
        return new Car(random.nextInt(400) + 40, random.nextDouble() * 900 + 800, random.nextDouble()*15+5);
    }
}
