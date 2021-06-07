package simulation;

import car.CarStatGenerator;
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
        CarStatGenerator carGenerator = new CarStatGenerator();
        Simulation simulation = new Simulation(carGenerator.generate());;
        simulation.Simulate(distance);
    }
}
