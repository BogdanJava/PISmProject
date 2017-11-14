package cardetails;

import carmodules.modules.Engine;

public class OpenEngine implements Engine {
    @Override
    public void insertEngine() {
        System.out.println("Opel engine set.");
    }
}
