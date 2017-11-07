package main.java.cars;

import main.java.caractions.ActionManager;
import main.java.carmodules.modules.Body;
import main.java.carmodules.modules.Engine;
import main.java.carmodules.modules.Wheel;

public class Opel extends Car {

    private static final int CAR_CODE = 2;

    public Opel() {
    }

    public Opel(Body body, Engine engine, Wheel wheel, int wheelNumber) {
        super(body, engine, wheel, wheelNumber);
    }

    @Override
    public int getCarCode() {
        return CAR_CODE;
    }

    @Override
    protected void constructBody() {
        System.out.println("Prepare to construct opel body:");
        getBody().constructBody();
    }

    @Override
    protected void setEngine() {
        System.out.println("Prepare to set opel engine:");
        getEngine().insertEngine();
    }

    @Override
    protected void setWheels() {
        System.out.println("Prepare to set opel wheels:");
        for(int i=0; i<getBody().getWheelsNumber(); i++){
            getWheel().setWheel();
        }
    }

    @Override
    public void drive() {
        ActionManager.getActionByName("drive").doAction("Opel");
    }

    @Override
    public void explode() {
        ActionManager.getActionByName("explode").doAction("Opel");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Opel opel = new Opel();
        opel.setEngine(getEngine());
        opel.setWheel(getWheel());
        opel.setBody(getBody());
        opel.setWheelNumber(getWheelNumber());
        return opel;
    }
}
