package logic;

import cargarage.CarWithinGarage;
import cargarage.Garage;
import cargarage.GarageManager;
import cargenerator.CarGenerator;
import cargenerator.CarModel;
import cars.Car;

import java.util.ArrayList;

public class CarConstructor {

    private static final String SEPARATOR = "___________________________________";

    public static void main(String[] args){
        CarGenerator carGenerator = CarGenerator.getInstance();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(carGenerator.getCar(CarModel.HONDA));
        cars.add(carGenerator.getCar(CarModel.OPEL));

        Garage garage = new Garage();
        GarageManager garageManager = new GarageManager();

        garageManager.setCar(cars.get(0)); // honda now is into garage
        garage.setCarWithinGarage(garageManager.moveCarIntoGarage());

        doActionWithCars(cars);
        cars = new ArrayList<>(); // all cars are exploded

        //restoring honda
        GarageManager garageManager2 = new GarageManager();
        garageManager2.moveCarOutFromGarage(garage.getCarWithinGarage());
        cars.add(garageManager.getCar());
        doActionWithCars(cars);
    }

    private static void doActionWithCars(ArrayList<Car> cars){
        System.out.println(SEPARATOR);
        for(Car car : cars){
            car.constructionProcess();
            car.drive();
            car.explode();
            System.out.println(SEPARATOR);
        }
    }
}
