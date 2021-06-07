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
        return String.format("\nStatystyki auta:\nKonie mechaniczne: %d,\nmasa auta: %.2f,\npredkosc poczatkowa: %.2f\n ", horsePower, mass, currentSpeed);
    }

    @Override
    public void acceleration(double grip, double distance, double requiredSpeed) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = (horsePower + grip * constantResistance)/mass; // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + 2 * accelerationValue* distance);
        currentSpeed = Math.min(endVelocity, requiredSpeed);
    }
    public void acceleration(double grip, double distance) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = (horsePower + grip * constantResistance)/mass; // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + 2 * accelerationValue* distance);
        currentSpeed = endVelocity;
    }

    @Override
    public double braking(double grip, double requiredSpeed){
        int brakingPower = 55;
        return Math.abs(-(Math.pow(currentSpeed-requiredSpeed,2))/(2*brakingPower)) +(0.25*(grip*mass));
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
