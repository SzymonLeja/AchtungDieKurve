package car;

public interface Acceleration {
    void acceleration(double grip, double distance, double reqSpeed);
    double braking(double grip, double reqSpeed);
}
