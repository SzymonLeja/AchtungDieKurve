package road;

import car.Car;
import obstacle.ObstacleTypes;
import road.Road;

import java.text.DecimalFormat;
import java.util.logging.Logger;

public class RoadCrash {
    private final Car car;
    public RoadCrash(Car car){
        this.car = car;
    }
    public boolean crash(Road road){
        if(corneringCrash(road.getGrip(),road.getCornerDegree(),car) || obstacleCrash(road,car,road.getGrip())){
            return true;
        }
        return false;

    }
    /**
     * Metoda sprawdzajaca czy podczas przejazdu przez zakret sie rozbije
     * @param roadGrip przyczepnosc wygenerowanej drogi
     * @param cornerDegree nachylenie wygenerowanej drogi
     * @param car wygenerowany samochod
     * @return True/False - Kierowca sie rozbil lub nie
     */
    private boolean corneringCrash(double roadGrip, double cornerDegree, Car car){
        Logger logger = Logger.getLogger("carCrash");
        double cornerLength = 0.78; //kilometers
        double straightLength = 0.8;//KILOMETERS
        DecimalFormat twoDecimal = new DecimalFormat("#0.00");
        if(cornerDegree>0){
            int corneringLength = 180*40;
            double cornerPhysicsForces= 9.81*3.6;
            double requiredCornerSpeed = Math.sqrt(roadGrip*((corneringLength)/(cornerDegree*Math.PI))*cornerPhysicsForces);
            if(car.getCurrentSpeed() > requiredCornerSpeed){
                if(car.braking(roadGrip, requiredCornerSpeed)>cornerLength){
                    logger.warning("Wypadles z zakretu! ( Wymagana predkosc: " + requiredCornerSpeed +", twoja predkosc: " + twoDecimal.format(car.getCurrentSpeed()) +" )");
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
        Logger logger = Logger.getLogger("carCrash");

        if(road.getObstacle().getObstacleType() != ObstacleTypes.NULL){
            double obstacleRequiredSpeed = road.getObstacle().getRequiredSpeed();
            if(car.getCurrentSpeed() > obstacleRequiredSpeed){
                int distanceBeforeObstacle = 200; //meters
                if(car.braking(roadGrip, obstacleRequiredSpeed)>distanceBeforeObstacle){
                    logger.warning("Uderzyles przeszkode! ( " + road.getObstacle().getObstacleType() + " )");
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
