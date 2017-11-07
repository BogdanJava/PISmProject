package main.java.cargarage;

import main.java.cars.Car;

public class GarageManager {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarWithinGarage moveCarIntoGarage(){
        return new CarWithinGarage(car);
    }

    public void moveCarOutFromGarage(CarWithinGarage carWithinGarage){
        this.car = carWithinGarage.getCar();
    }
}
