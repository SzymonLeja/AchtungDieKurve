package obstacle;

import road.RoadTypeEnum;

import java.util.ArrayList;
import java.util.Arrays;

public enum ObstacleEnum {
    Animal(new ArrayList<>(Arrays.asList(RoadTypeEnum.values())), "Zwierze"),
    RoadWork(new ArrayList<>(Arrays.asList(RoadTypeEnum.Asphalt, RoadTypeEnum.Gravel, RoadTypeEnum.Sand)), "Roboty drogowe"),
    Pedestrian(new ArrayList<>(Arrays.asList(RoadTypeEnum.Asphalt, RoadTypeEnum.Gravel, RoadTypeEnum.Sand)), "Pieszy"),
    Babushka(new ArrayList<>(Arrays.asList(RoadTypeEnum.Asphalt, RoadTypeEnum.Sand)), "Babushka"),
    none(new ArrayList<>(Arrays.asList(RoadTypeEnum.values())), "Nic");

    private final ArrayList<RoadTypeEnum> where;
    private final String name;

    ObstacleEnum(ArrayList<RoadTypeEnum> where, String name) {
        this.where = where;
        this.name = name;
    }

    public ArrayList<RoadTypeEnum> getWhere() {
        return where;
    }

    @Override
    public String toString() {
        return name;
    }
}
