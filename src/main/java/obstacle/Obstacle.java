package obstacle;

public class Obstacle {
    private ObstacleEnum obstacleType;
    private double reqSpeed;

    public Obstacle(ObstacleEnum obstacleType, double reqSpeed) {
        this.obstacleType = obstacleType;
        this.reqSpeed = reqSpeed;
    }

    public ObstacleEnum getObstacleType() {
        return obstacleType;
    }

    public double getReqSpeed(){return reqSpeed; }

    @Override
    public String toString() {
        return obstacleType.name();
    }
}
