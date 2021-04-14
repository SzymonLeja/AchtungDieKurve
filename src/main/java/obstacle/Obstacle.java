package obstacle;

public class Obstacle {
    private ObstacleType obstacleType;
    private double reqSpeed;

    public Obstacle(ObstacleType obstacleType, double reqSpeed) {
        this.obstacleType = obstacleType;
        this.reqSpeed = reqSpeed;
    }
}
