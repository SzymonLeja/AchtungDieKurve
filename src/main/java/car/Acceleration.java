package car;

public interface Acceleration {
    void acceleration(double grip, int distance, double reqSpeed);
    double braking(double grip, double reqSpeed);
}
