package car;

public class Car implements Acceleration{
    private final int horsePower;
    private final double mass;
    private double currentSpeed;

    public Car(int horsePower, double mass, double currentSpeed) {
        this.horsePower = horsePower;
        this.mass = mass;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public String toString() {
        return String.format(
                "\nStatystyki auta:\nKonie mechaniczne: %d,\nmasa auta: %.2f,\npredkosc poczatkowa: %.2f\n ",
                horsePower,
                mass,
                currentSpeed);
    }

    @Override
    public void acceleration(double grip, int distance, double reqSpeed) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = (horsePower + grip * constantResistance)/mass; // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + 2 * accelerationValue* distance);
        currentSpeed = Math.min(endVelocity, reqSpeed);
    }
    public void acceleration(double grip, int distance) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = (horsePower + grip * constantResistance)/mass; // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + 2 * accelerationValue* distance);
        currentSpeed = endVelocity;
    }

    @Override
    public double braking(double grip, double reqSpeed){
        int brakingPower = 55;
        return Math.abs(-(Math.pow(currentSpeed-reqSpeed,2))/(2*brakingPower)) +(0.25*(grip*mass));
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
