package obstacle;

/**
 * Klasa przedstawiajaca przeszkode, jej typ i wymagan predkosc do jej ominiecia
 */
public class Obstacle {
    private ObstacleTypes obstacleType;
    private double requiredSpeed;

    /**
     * Konstruktor klasy
     * @param obstacleType typ przeszkody
     * @param requiredSpeed wymagana predkosc do ominiecia przeszkody
     */
    public Obstacle(ObstacleTypes obstacleType, double requiredSpeed) {
        this.obstacleType = obstacleType;
        this.requiredSpeed = requiredSpeed;
    }

    /**
     * Metoda zwracaja typ przeszkody
     * @return zwraca typ przeszkody
     */
    public ObstacleTypes getObstacleType() {
        return obstacleType;
    }

    /**
     * Metoda zwracaja wymagana predkosc do ominiecia przeszkody
     * @return zwraca wymagana predkosc do ominiecia przeszkody
     */
    public double getRequiredSpeed(){return requiredSpeed; }

    @Override
    public String toString() {
        return obstacleType.name();
    }
}
