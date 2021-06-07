package simulation;

import car.CarGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dlugosc trasy (km)");
        int distance;
        while (true)
        {
            try {
                distance = scan.nextInt();
                break;
            } catch (Exception e)
            {
                System.out.println("Prosze o wartosc liczbowa");
                scan.next();
            }
        }
        CarGenerator carGenerator = new CarGenerator();
        Simulation simulation = new Simulation(carGenerator.generate());
        simulation.Simulate(distance);
    }
}
