package cardetails;

import carmodules.modules.Body;

public class OpelBody implements Body {

    public static final int WHEEL_NUMBER = 4+1;

    @Override
    public void constructBody() {
        System.out.println("Opel body constructed.");
    }

    @Override
    public int getWheelsNumber() {
        return WHEEL_NUMBER;
    }
}
