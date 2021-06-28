package simulation;

import car.CarGenerator;
import java.util.Scanner;
import java.util.logging.Logger;

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
        Logger logger = Logger.getLogger("logger");

        int distance=0;
        while (distance<=0)
        {
            logger.info("Podaj dlugosc trasy (km)");
            try {
                distance = scan.nextInt();
            } catch (Exception e)
            {
                logger.warning("Prosze podac wartosc liczbowa");
                scan.next();
            }
        }
        CarGenerator carGenerator = new CarGenerator();
        Simulation simulation = new Simulation(carGenerator.generate());
        simulation.simulate(distance);
    }
}
