package obstacle;

public class Obstacle {
    private ObstacleTypes obstacleType;
    private double requiredSpeed;

    public Obstacle(ObstacleTypes obstacleType, double requiredSpeed) {
        this.obstacleType = obstacleType;
        this.requiredSpeed = requiredSpeed;
    }

    public ObstacleTypes getObstacleType() {
        return obstacleType;
    }

    public double getRequiredSpeed(){return requiredSpeed; }

    @Override
    public String toString() {
        return obstacleType.name();
    }
}
