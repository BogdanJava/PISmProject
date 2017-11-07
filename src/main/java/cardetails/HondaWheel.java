package main.java.cardetails;

import main.java.carmodules.modules.Wheel;

public class HondaWheel implements Wheel{

    @Override
    public void setWheel() {
        System.out.println("Honda wheel set.");
    }
}
