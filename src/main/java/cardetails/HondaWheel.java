package cardetails;

import carmodules.modules.Wheel;

public class HondaWheel implements Wheel{

    @Override
    public void setWheel() {
        System.out.println("Honda wheel set.");
    }
}
