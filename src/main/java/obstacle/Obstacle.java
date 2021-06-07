package obstacle;

public class Obstacle {
    private ObstacleEnum obstacleType;
    private double requiredSpeed;

    public Obstacle(ObstacleEnum obstacleType, double requiredSpeed) {
        this.obstacleType = obstacleType;
        this.requiredSpeed = requiredSpeed;
    }

    public ObstacleEnum getObstacleType() {
        return obstacleType;
    }

    public double getRequiredSpeed(){return requiredSpeed; }

    @Override
    public String toString() {
        return obstacleType.name();
    }
}
