package simulation;

import car.Car;
import obstacle.ObstacleTypes;
import road.Road;
import road.RoadGenerator;

import java.text.DecimalFormat;
/**
 * Klasa Simulation odpowiada za przeprowadzenie symulacji (generowanie odcinkow drogi, sprawdzanie czy przejazd jest udany, czy kierowca powinien hamowac lub przyspieszac)
 */

public class Simulation {
    private final Car car;

    /**
     * Konstruktor klasy
     * @param car Wygenerowany samochod dla ktorego zostaje przeprowadzona symulacja
     */
    public Simulation(Car car) {
        this.car = car;
    } // do zakretu 780 zakret 20 do przeszkody 200
    /**
     * Metoda przeprowadzajaca symulacje
     * @param totalKilometers Dlugosc calej trasy (ilosc wylosowanych odcinkow)
     */
    public void simulate(int totalKilometers){
        System.out.println(car.toString());
        RoadGenerator roadGenerator = new RoadGenerator();
        boolean crashed = false;
        int kilometersTravelled =0;
        DecimalFormat twoDecimal = new DecimalFormat("#0.00");
        while(kilometersTravelled<=totalKilometers && !crashed){
            Road road = roadGenerator.generate();
            System.out.println(road.toString());
            double cornerDegree = road.getCornerDegree();
            double roadGrip = road.getGrip();

            if(corneringCrash(roadGrip, cornerDegree, car)){
                crashed = true;
            }
            if(obstacleCrash(road,car,roadGrip)){
                crashed = true;
            }
            System.out.println("Koniec " + kilometersTravelled + " kilometru, z predkoscia " + twoDecimal.format(car.getCurrentSpeed())+" km/h.\n");
            kilometersTravelled+=1;
        }
        System.out.println(crashed? "Kierowca nie pokonal trasy! Polegl na " + (kilometersTravelled-1) + " kilometrze z predkoscia " + twoDecimal.format(car.getCurrentSpeed()) + " km/h." :"Kierowca pokonal cala trase! (" + (kilometersTravelled-1) + " kilometrow )");
    }

    /**
     * Metoda sprawdzajaca czy podczas przejazdu przez zakret sie rozbije
     * @param roadGrip przyczepnosc wygenerowanej drogi
     * @param cornerDegree nachylenie wygenerowanej drogi
     * @param car wygenerowany samochod
     * @return True/False - Kierowca sie rozbil lub nie
     */
    private boolean corneringCrash(double roadGrip, double cornerDegree, Car car){
        double cornerLength = 0.78; //kilometers
        double straightLength = 0.8;//KILOMETERS
        DecimalFormat twoDecimal = new DecimalFormat("#0.00");
        if(cornerDegree>0){
            int corneringLength = 180*40;
            double cornerPhysicsForces= 9.81*3.6;
            double requiredCornerSpeed = Math.sqrt(roadGrip*((corneringLength)/(cornerDegree*Math.PI))*cornerPhysicsForces);
            if(car.getCurrentSpeed() > requiredCornerSpeed){
                if(car.braking(roadGrip, requiredCornerSpeed)>cornerLength){
                    System.out.println("Wypadles z zakretu! ( Wymagana predkosc: " + requiredCornerSpeed +", twoja predkosc: " + twoDecimal.format(car.getCurrentSpeed()) +" )");
                    return true;
                }
                else {
                    car.setCurrentSpeed(requiredCornerSpeed);
                    return false;
                }
            } else {
                car.acceleration(roadGrip, cornerLength, requiredCornerSpeed);
                return false;
            }
        } else {
            car.acceleration(roadGrip, straightLength);
            return false;
        }
    }
    /**
     * Metoda sprawdzajaca czy podczas wymijania przeszkody po zakrecie kierowca sie rozbije
     * @param road wylosowana droga wraz z przeszkodami
     * @param car wygenerowany samochod
     * @param roadGrip przyczepnosc wygenerowanej drogi
     * @return True/False - Kierowca sie rozbil lub nie
     */
    private boolean obstacleCrash(Road road, Car car, double roadGrip){
        if(road.getObstacle().getObstacleType() != ObstacleTypes.NULL){
            double obstacleRequiredSpeed = road.getObstacle().getRequiredSpeed();
            if(car.getCurrentSpeed() > obstacleRequiredSpeed){
                int distanceBeforeObstacle = 200; //meters
                if(car.braking(roadGrip, obstacleRequiredSpeed)>distanceBeforeObstacle){
                    System.out.println("Uderzyles przeszkode! ( " + road.getObstacle().getObstacleType() + " )");
                    return true;
                }
                else {
                    car.setCurrentSpeed(obstacleRequiredSpeed);
                    return false;
                }
            } else {
                car.acceleration(roadGrip, 0.2, obstacleRequiredSpeed);
                return false;
            }
        }
        return false;
    }
}
