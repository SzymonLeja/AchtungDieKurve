package car;
/**
 * Klasa Car przedstawia wygenerowany samochod, jego parametry i dzialanie
 */
public class Car {
    private final int horsePower;
    private final double mass;
    private double currentSpeed;
    /**
     * Konstruktor klasy
     * @param horsePower moc samochodu (Konie mechaniczne)
     * @param mass masa samochodu
     * @param currentSpeed aktualna predkosc samochodu
     */
    public Car(int horsePower, double mass, double currentSpeed) {
        this.horsePower = horsePower;
        this.mass = mass;
        this.currentSpeed = currentSpeed;
    }

    @Override
    public String toString() {
        return String.format("\nStatystyki auta:\nKonie mechaniczne: %d,\nmasa auta: %.2f,\npredkosc poczatkowa: %.2f\n ", horsePower, mass, currentSpeed);
    }
    /**
     * Metoda ktora pozwala na przyspieszenie samochodu (zmiane predkosci) az do maksymalnej predkosci
     * @param grip przyczepnosc na wygenerowanej drodze
     * @param distance odcinek na ktorym samochod moze przyspieszyc
     * @param requiredSpeed maksymalna predkosc jaka samochod moze osiagnac
     */
    public void acceleration(double grip, double distance, double requiredSpeed) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = (horsePower + grip * constantResistance)/mass; // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + 2 * accelerationValue* distance);
        currentSpeed = Math.min(endVelocity, requiredSpeed);
    }
    /**
     * Metoda ktora pozwala na przyspieszenie samochodu (zmiane predkosci) bez ograniczenia predkosci
     * @param grip przyczepnosc na wygenerowanej drodze
     * @param distance odcinek na ktorym samochod moze przyspieszyc
     */
    public void acceleration(double grip, double distance) {
        double constantResistance = 42.11; // dragForce + rollingResistance\
        double accelerationValue = 2*((horsePower + grip * constantResistance)/mass); // m/s^2
        double endVelocity = Math.sqrt(currentSpeed*currentSpeed + accelerationValue* distance);
        currentSpeed = endVelocity;
    }
    /**
     * Metoda ktora zwraca droge hamowania potrzebna do wyhamowania do zadanej predkosci
     * @param grip przyczepnosc na wygenerowanej drodze
     * @param requiredSpeed maksymalna predkosc jaka samochod moze osiagnac
     * @return Droga hamowania do zadanej predkosci
     */
    public double braking(double grip, double requiredSpeed){
        int brakingPower = 2*55;
        double tractionForce = (0.25*(grip*mass));
        return Math.abs(-(Math.pow(currentSpeed-requiredSpeed,2))/(brakingPower)) +tractionForce;
    }

    /**
     * Metoda ktora zwraca aktualna predkosc samochodu
     * @return aktualna predkosc samochodu
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    /**
     * Metoda ktora ustawia aktualna predkosc samochodu na zadana predkosc
     * @param currentSpeed aktualna predkosc samochodu
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
