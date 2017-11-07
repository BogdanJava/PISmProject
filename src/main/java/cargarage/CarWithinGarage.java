package main.java.cargarage;

import main.java.cars.Car;

public class CarWithinGarage {
    private final Car car;

    public CarWithinGarage(Car car) {
        this.car = car;
    }

    public Car getCar(){
        return car;
    }
}
