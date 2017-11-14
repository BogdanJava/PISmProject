import caractions.ActionManager;
import caractions.CarAction;
import cardetails.HondaBody;
import cardetails.OpelBody;
import cargarage.Garage;
import cargarage.GarageManager;
import cargenerator.CarGenerator;
import cargenerator.CarModel;
import cars.Car;
import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.Constructor;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class Tester {

    @Test
    public void testFactory(){
        CarGenerator carGenerator = CarGenerator.getInstance();
        Car car1 = carGenerator.getCar(CarModel.OPEL);
        Assert.assertNotNull(car1);
        Car car2 = carGenerator.getCar(CarModel.HONDA);
        Assert.assertNotNull(car2);
        Car car3 = carGenerator.getCar(CarModel.MAZDA); // MAZDA constant presents, but there's no
        // appropriate class created yet.
        Assert.assertNotNull(car3); //uncomment to get assertion fail
    }

    @Test
    public void testSingleton() {
        CarGenerator cg1 = CarGenerator.getInstance();
        CarGenerator cg2 = CarGenerator.getInstance();
        Assert.assertEquals(cg1, cg2);

        try {
            Class constructorClass = CarGenerator.class;
            Constructor<CarGenerator> constructor = constructorClass.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object object3 = constructorClass.newInstance();
            Assert.assertTrue(object3 instanceof CarGenerator);
            CarGenerator cg3 = (CarGenerator) object3;
            Assert.assertEquals(cg1, cg3); // uncomment to get assertion fail
        } catch (InstantiationException | IllegalAccessException |
                NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void commandTest(){
        CarAction action1 = ActionManager.getActionByName("drive");
        Assert.assertNotNull(action1);
        String action1result = action1.doAction("Honda");

        CarAction action2 = ActionManager.getActionByName("explode");
        Assert.assertNotNull(action2);
        String action2result = action2.doAction("Mazda");

        Assert.assertNotSame(action1result, action2result);

        CarAction action3 = ActionManager.getActionByName("noSuchAction"); // there's no
                                                                                      //such action stored
        //Assert.assertNotNull(action3); //uncomment to get assertion fail
    }

    @Test
    public void testMemento() throws CloneNotSupportedException {
        CarGenerator carGenerator = CarGenerator.getInstance();
        GarageManager gm1 = new GarageManager();
        Garage g1 = new Garage();

        Car honda1 = carGenerator.getCar(CarModel.HONDA);

        gm1.setCar(honda1);
        g1.setCarWithinGarage(gm1.moveCarIntoGarage());
        gm1.setCar(null); //removing from garage Manager

        //restoring null carr(getting from garage)
        gm1.moveCarOutFromGarage(g1.getCarWithinGarage());

        Assert.assertEquals(honda1, g1.getCarWithinGarage().getCar());

        Car fromGarage = g1.getCarWithinGarage().getCar();
        Car honda2 = (Car) fromGarage.clone();

        //honda2.setBody(new OpelBody()); //uncomment to get AssertionException
        Assert.assertTrue(honda1.equals(honda2));
        //changed body of honda2, now it's not same state as in garage
    }
}

