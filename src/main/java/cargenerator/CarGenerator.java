package cargenerator;

import cardetails.*;
import cars.Car;
import cars.Honda;
import cars.Opel;

public class CarGenerator {

    private static CarGenerator carGenerator;

    private CarGenerator(){
    }

    public static CarGenerator getInstance(){
        if(carGenerator == null){
            carGenerator = new CarGenerator();
        }
        return carGenerator;
    }

    public Car getCar(CarModel model){
        switch (model){
            case OPEL: return new Opel(new OpelBody(), new OpenEngine(), new OpelWheel(), 5);
            case HONDA: return new Honda(new HondaBody(), new HondaEngine(), new HondaWheel(), 4);
            default: return null;
        }
    }
}
