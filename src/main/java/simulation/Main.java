package simulation;

import car.CarStatGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj dlugosc trasy (km)");
        int distance;
        boolean inputNotNull = false;
        while (!inputNotNull)
        {
            try {
                distance = scan.nextInt();
            } catch (Exception e)
            {
                System.out.println("Prosze o wartosc liczbowa");
                continue;
            }
            inputNotNull = true;
        }
        distance = scan.nextInt();
        CarStatGenerator carGenerator = new CarStatGenerator();
        Simulation simulation;
        simulation = new Simulation(carGenerator.generate());
        simulation.Simulate(distance);
    }
}
