package car;

public class Car {
    private int horsePower;
    private double mass;
    private double traction;

    public Car(int horsePower, double mass, double traction) {
        this.horsePower = horsePower;
        this.mass = mass;
        this.traction = traction;
    }

    @Override
    public String toString() {
        return String.format(
                "Statystyki auta { Konie mechaniczne: %d, masa auta: %.2f, przyczepnosc: %.2f }",
                horsePower,
                mass,
                traction);
    }
}
