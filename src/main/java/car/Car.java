package car;

public class Car implements Acceleration{
    private int horsePower;
    private double mass;
    private double currentSpeed;

    public Car(int horsePower, double mass) {
        this.horsePower = horsePower;
        this.mass = mass;
        currentSpeed = 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Statystyki auta { Konie mechaniczne: %d, masa auta: %.2f, predkosc: %.2f }",
                horsePower,
                mass,
                currentSpeed);
    }

    @Override
    public void acceleration() {

    }
}
