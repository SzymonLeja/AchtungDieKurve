package road;

import obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Random;
/**
 * Klasa Road przedstawia wygenerowana droge, jej parametry i przeszkody ktore sie na niej znajduja (lub nie)
 */
public class Road {
    private final double grip;
    private final RoadType type;
    private final RoadTrack track;
    private final Double cornerDegree;
    private final Obstacle obstacle;
    /**
     * Konstruktor klasy
     * @param grip przyczepnosc miedzy powierzchnia drogi, a samochodem
     * @param type typ nawierzchni
     * @param track rodzaj drogi (zakret/prosta)
     * @param cornerDegree stopień nachylenia drogi
     * @param obstacle przeszkoda zawarta na drodze
     */
    public Road(double grip, RoadType type, RoadTrack track, Double cornerDegree, Obstacle obstacle) {
        this.grip = grip;
        this.type = type;
        this.track = track;
        this.cornerDegree = cornerDegree;
        this.obstacle = obstacle;
    }

    @Override
    public String toString() {
        return String.format(
                "Droga:\ntyp= %s,\nprzyczepnosc= %.2f,\nrodzaj zakretu= %s,\nstopien nachylenia: %s,\nprzeszkoda: %s\n ", type.getType(), grip, track.getTrack(), cornerDegree == 0 ? "nie ma" : String.format("%.2f", cornerDegree), obstacle.toString());
    }

    /**
     * Metoda zwracaja przyczepnosc nawierzchni
     * @return zwraca przyczepnosc nawierzchni (1.0 - 0.1)
     */
    public double getGrip() {
        return grip;
    }

    /**
     * Metoda zwracajaca nachylenie jezdni
     * @return zwraca nachylenie jezdni (0-360)
     */
    public double getCornerDegree() {
        return cornerDegree;
    }

    /**
     * Metoda zwracaja przeszkode na drodze
     * @return zwraca przeszkode zawierajaca sie na drodze
     */
    public Obstacle getObstacle() {
        return obstacle;
    }
}
