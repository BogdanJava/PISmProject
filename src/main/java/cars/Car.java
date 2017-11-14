package cars;

import carmodules.modules.Body;
import carmodules.modules.Engine;
import carmodules.modules.Wheel;

public abstract class Car {

    private int wheelNumber;

    private Body body;
    private Engine engine;
    private Wheel wheel;

    public Car() {
    }

    public Car(Body body, Engine engine, Wheel wheel, int wheelNumber) {
        this.body = body;
        this.engine = engine;
        this.wheel = wheel;
        this.wheelNumber = wheelNumber;
    }

    public abstract int getCarCode();

    public int getWheelNumber() {
        return wheelNumber;
    }

    public void setWheelNumber(int wheelNumber) {
        this.wheelNumber = wheelNumber;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    protected abstract void constructBody();
    protected abstract void setEngine();
    protected abstract void setWheels();

    public int constructionProcess(){
        System.out.println("Starting construction process.");

        this.constructBody();
        this.setEngine();
        this.setWheels();
        System.out.println(this.getClass().getName() + " constructed.");

        System.out.println("End construction process.");
        return getCarCode();
    }

    public abstract void drive();
    public abstract void explode();

    @Override
    public boolean equals(Object obj) {
        Car car = (Car) obj;

        System.out.println(body.getClass());
        return body.getClass().equals(car.getBody().getClass()) &&
                engine.getClass().equals(car.getEngine().getClass()) &&
                wheel.getClass().equals(car.getWheel().getClass());
    }

    @Override
    public abstract Object clone() throws CloneNotSupportedException;
}
