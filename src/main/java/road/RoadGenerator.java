package road;

import obstacle.Obstacle;
import obstacle.ObstacleEnum;

import java.util.ArrayList;
import java.util.Random;

public class RoadGenerator {
    public Road generate(){
        return generateInternal(System.currentTimeMillis());
    }

    public Road generate(long seed) {
        return generateInternal(seed);
    }

    private Road generateInternal(long seed)
    {
        ArrayList<Obstacle> obstacles = new ArrayList<>();
        ArrayList<RoadTrack> roadTracks = new ArrayList<>();
        ArrayList<RoadType> roadTypes = new ArrayList<>();
        Random random = new Random(seed);

        for (ObstacleEnum obstacle: ObstacleEnum.values())
        {
            obstacles.add(new Obstacle(obstacle, 5));
        }
        for (RoadTypeEnum type: RoadTypeEnum.values())
        {
            roadTypes.add(new RoadType(type, 20, 10));
        }
        for (RoadTrackEnum track: RoadTrackEnum.values())
        {
            for (RoadType type: roadTypes)
            {
                ArrayList<Obstacle> possibleObstacles = new ArrayList<>();
                for (Obstacle obstacle: obstacles)
                {
                    if (obstacle.getObstacleType().getWhere().contains(type.getType())){
                        possibleObstacles.add(obstacle);
                    }
                }
                roadTracks.add(new RoadTrack(type, track.toString(), possibleObstacles));
            }
        }

        RoadTrack randomTrack = roadTracks.get(random.nextInt(roadTracks.size()));
        RoadType randomType = roadTypes.get(random.nextInt(roadTypes.size()));
        return new Road(
                random.nextDouble()*(randomType.getMaxGrip()-randomType.getMinGrip())+randomType.getMinGrip(),
                randomTrack,
                randomTrack.getTrack().equals(RoadTrackEnum.Straight.toString())? 0 : random.nextDouble()*110,
                randomTrack.getPossibleObstacle().get(random.nextInt(randomTrack.getPossibleObstacle().size()))
        );
    }
}
