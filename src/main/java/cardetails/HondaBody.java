package cardetails;

import carmodules.modules.Body;

public class HondaBody implements Body{
    public static final int WHEEL_NUMBER = 4;

    @Override
    public void constructBody() {
        System.out.println("Honda body constructed.");
    }

    @Override
    public int getWheelsNumber() {
        return WHEEL_NUMBER;
    }
}
