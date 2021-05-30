package simulation;

import car.Car;
import obstacle.ObstacleEnum;
import road.Road;
import road.RoadGenerator;

public class Simulation {
    private final Car car;

    public Simulation(Car car) {
        this.car = car;
    } // do zakretu 780 zakret 20 do przeszkody 200

    public void Simulate(int i){
        RoadGenerator roadGenerator = new RoadGenerator();
        boolean crashed = false;
        int j =0;
        for(j=0;j<=i;j++){
            Road road = roadGenerator.generate();
            System.out.println(road.toString());
            double cornerDegree = road.getCornerDegree();
            double roadGrip = road.getGrip();
            // zakret
            if(cornerDegree>0){
                double requiredCornerSpeed = Math.sqrt(roadGrip*((180*20)/(cornerDegree*Math.PI))*9.81*3.6);
                if(car.getCurrentSpeed() > requiredCornerSpeed){
                    if(car.braking(roadGrip, requiredCornerSpeed)>780){
                        System.out.println("Wypadles z zakretu!");
                        crashed = true;
                        break;
                    }
                } else {
                    car.acceleration(roadGrip, 780, requiredCornerSpeed);
                }
            } else {
                car.acceleration(roadGrip, 800);
            }
            //koniecc zakretu
            if(road.getObstacle().getObstacleType() != ObstacleEnum.none){
                double obstacleReqSpeed = road.getObstacle().getReqSpeed();
                if(car.getCurrentSpeed() > obstacleReqSpeed){
                    if(car.braking(roadGrip, obstacleReqSpeed)>200){
                        System.out.println("Uderzyles przeszkode!");
                        crashed = true;
                        break;
                    }
                } else {
                    car.acceleration(roadGrip, 200, obstacleReqSpeed);
                }
            }
            System.out.println("Koniec " + j + " kilometru, z prędkością " + car.getCurrentSpeed());
        }
        System.out.println(crashed? ("Kierowca nie pokonał trasy! Poległ na " + j + " kilometrze" ):"Kierowca pokonał całą trase!");
    }
}
