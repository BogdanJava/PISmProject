package main.java.cardetails;

import main.java.carmodules.modules.Engine;

public class OpenEngine implements Engine {
    @Override
    public void insertEngine() {
        System.out.println("Opel engine set.");
    }
}
