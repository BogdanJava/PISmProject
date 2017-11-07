package main.java.cardetails;

import main.java.carmodules.modules.Engine;

public class HondaEngine implements Engine {
    @Override
    public void insertEngine() {
        System.out.println("Honda engine set.");
    }
}
