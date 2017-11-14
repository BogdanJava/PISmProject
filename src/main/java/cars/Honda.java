package cars;

import caractions.ActionManager;
import carmodules.modules.Body;
import carmodules.modules.Engine;
import carmodules.modules.Wheel;

public class Honda extends Car {

    private static final int CAR_CODE = 1;

    public Honda() {
    }

    public Honda(Body body, Engine engine, Wheel wheel, int wheelNumber) {
        super(body, engine, wheel, wheelNumber);
    }

    @Override
    public int getCarCode() {
        return CAR_CODE;
    }

    @Override
    protected void constructBody() {
        System.out.println("Prepare to construct honda body:");
        getBody().constructBody();
    }

    @Override
    protected void setEngine() {
        System.out.println("Prepare to set honda engine:");
        getEngine().insertEngine();
    }

    @Override
    protected void setWheels() {
        System.out.println("Prepare to set honda wheels:");
        for(int i=0; i<getBody().getWheelsNumber(); i++){
            getWheel().setWheel();
        }
    }

    @Override
    public void drive() {
        ActionManager.getActionByName("drive").doAction("Honda");
    }

    @Override
    public void explode() {
        ActionManager.getActionByName("explode").doAction("Honda");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Honda honda = new Honda();
        honda.setEngine(getEngine());
        honda.setWheel(getWheel());
        honda.setBody(getBody());
        honda.setWheelNumber(getWheelNumber());
        return honda;
    }
}
