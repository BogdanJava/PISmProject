package main.java.cardetails;

import main.java.carmodules.modules.Wheel;

public class OpelWheel implements Wheel {
    @Override
    public void setWheel() {
        System.out.println("Opel wheel set.");
    }
}
