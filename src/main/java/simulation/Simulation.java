package simulation;

import car.Car;
import road.Road;

public class Simulation {
    private Car car;
    private Road road;

    public Simulation(Car car, Road road) {
        this.car = car;
        this.road = road;
    }

    public void Simulate(int i){
        for(int j=0;j<i;j++){
            //jakaś funkcja
        }
    }
}
