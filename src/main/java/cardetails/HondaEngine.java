package cardetails;

import carmodules.modules.Engine;

public class HondaEngine implements Engine {
    @Override
    public void insertEngine() {
        System.out.println("Honda engine set.");
    }
}
