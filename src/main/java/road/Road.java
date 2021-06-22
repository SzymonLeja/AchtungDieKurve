package road;

import obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Random;
/**
 * Klasa Road przedstawia wygenerowana droge, jej parametry i przeszkody ktore sie na niej znajduja (lub nie)
 */
public class Road implements RoadInterface {
    private double grip;
    private RoadType type;
    private RoadTrack track;
    private Double cornerDegree;
    private Obstacle obstacle;

    /**
     * Budowniczy klasy Road
     */
    public static final class Builder {
        private double grip;
        private RoadType type;
        private RoadTrack track;
        private Double cornerDegree;
        private Obstacle obstacle;

        /**
         * Metoda która przypisuje przyczepność
         * @param grip przyczepnosc miedzy powierzchnia drogi, a samochodem
         */
        public Builder grip(double grip){
            this.grip = grip;
            return this;
        }

        /**
         * Metoda która przypisuje typ nawierzchni
         * @param type typ nawierzchni
         */
        public Builder type(RoadType type){
            this.type = type;
            return this;
        }

        /**
         * Metoda która przypisuje rodzaj drogi
         * @param track rodzaj drogi (zakret/prosta)
         */
        public Builder track(RoadTrack track){
            this.track = track;
            return this;
        }

        /**
         * Metoda która przypisuje stopień nachylenia
         * @param cornerDegree stopień nachylenia drogi
         */
        public Builder cornerDegree(Double cornerDegree){
            this.cornerDegree = cornerDegree;
            return this;
        }

        /**
         * Metoda która przypisuje przeszkodę
         * @param obstacle przeszkoda zawarta na drodze
         */
        public Builder obstacle(Obstacle obstacle){
            this.obstacle = obstacle;
            return this;
        }
        /**
         * Metoda budująca klasę Road
         */
        public Road build() {
            Road road = new Road();
            road.grip = this.grip;
            road.type = this.type;
            road.track = this.track;
            road.cornerDegree = this.cornerDegree;
            road.obstacle = this.obstacle;
            return road;
        }
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
    @Override
    public double getGrip() {
        return grip;
    }

    /**
     * Metoda zwracajaca nachylenie jezdni
     * @return zwraca nachylenie jezdni (0-360)
     */
    @Override
    public double getCornerDegree() {
        return cornerDegree;
    }

    /**
     * Metoda zwracaja przeszkode na drodze
     * @return zwraca przeszkode zawierajaca sie na drodze
     */
    @Override
    public Obstacle getObstacle() {
        return obstacle;
    }

    public static Builder builder() {
        return new Builder();
    }
}
