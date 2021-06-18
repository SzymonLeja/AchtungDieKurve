package simulation;

import car.CarGenerator;
import java.util.Scanner;

/**
 * <p>Program symulujacy przejazd samochodu o losowych parametrach przez losowe odcinki drogi, o lacznej dlugosci zadanej przez uzytkownika.</p>
 *
 * @author Szymon Leja
 * @author Dmitry Goltrstein
 * @author Piotr Rachwalik
 * @version 1.0
 * @since 30-05-2021
 * Klasa Main odpowiada za wygenerowanie samochodu, przyjecie od uzytkownika łacznej dlugosci przejazdu i stworzenia symulacji przejazdu.
 */

public class Main {
    /**
     * Główna metoda programu
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int distance=0;
        while (distance<=0)
        {
            System.out.println("Podaj dlugosc trasy (km)");
            try {
                distance = scan.nextInt();
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
