package road;

import obstacle.Obstacle;

public interface RoadInterface {
    Obstacle getObstacle();
    double getCornerDegree();
    double getGrip();
}
