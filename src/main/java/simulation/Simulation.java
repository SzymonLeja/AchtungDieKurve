package simulation;

import car.Car;

import road.Road;
import road.RoadCrash;
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
        RoadCrash roadcrash = new RoadCrash(car);
        boolean crashed = false;
        int kilometersTravelled =0;
        DecimalFormat twoDecimal = new DecimalFormat("#0.00");
        while(kilometersTravelled<=totalKilometers && !crashed){
            Road road = roadGenerator.generate();
            System.out.println(road.toString());
            crashed = roadcrash.crash(road);
            System.out.println("Koniec " + kilometersTravelled + " kilometru, z predkoscia " + twoDecimal.format(car.getCurrentSpeed())+" km/h.\n");
            kilometersTravelled+=1;
        }
        System.out.println(crashed? "Kierowca nie pokonal trasy! Polegl na " + (kilometersTravelled-1) + " kilometrze z predkoscia " + twoDecimal.format(car.getCurrentSpeed()) + " km/h." :"Kierowca pokonal cala trase! (" + (kilometersTravelled-1) + " kilometrow )");
    }
}
