package simulation;

import car.Car;
import obstacle.ObstacleTypes;
import road.Road;
import road.RoadGenerator;

import java.text.DecimalFormat;

public class Simulation {
    private final Car car;

    public Simulation(Car car) {
        this.car = car;
    } // do zakretu 780 zakret 20 do przeszkody 200

    public void Simulate(int totalKilometers){
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
            System.out.println("Koniec " + kilometersTravelled + " kilometru, z prędkością " + twoDecimal.format(car.getCurrentSpeed())+" km/h.\n");
            kilometersTravelled+=1;
        }
        System.out.println(crashed? "Kierowca nie pokonał trasy! Poległ na " + (kilometersTravelled-1) + " kilometrze z predkoscia " + twoDecimal.format(car.getCurrentSpeed()) + " km/h." :"Kierowca pokonał całą trase! (" + (kilometersTravelled-1) + " kilometrow )");
    }

    private boolean corneringCrash(double roadGrip, double cornerDegree, Car car){
        if(cornerDegree>0){
            double requiredCornerSpeed = Math.sqrt(roadGrip*((180*20)/(cornerDegree*Math.PI))*9.81*3.6);
            if(car.getCurrentSpeed() > requiredCornerSpeed){
                if(car.braking(roadGrip, requiredCornerSpeed)>0.78){
                    System.out.println("Wypadles z zakretu! ( Wymagana predkosc: " + requiredCornerSpeed +", twoja predkosc: " + car.getCurrentSpeed() +" )");
                    return true;
                }
                else {
                    car.setCurrentSpeed(requiredCornerSpeed);
                    return false;
                }
            } else {
                car.acceleration(roadGrip, 0.78, requiredCornerSpeed);
                return false;
            }
        } else {
            car.acceleration(roadGrip, 0.8);
            return false;
        }
    }
    private boolean obstacleCrash(Road road, Car car, double roadGrip){
        if(road.getObstacle().getObstacleType() != ObstacleTypes.NIC){
            double obstacleRequiredSpeed = road.getObstacle().getRequiredSpeed();
            if(car.getCurrentSpeed() > obstacleRequiredSpeed){
                if(car.braking(roadGrip, obstacleRequiredSpeed)>200){
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
