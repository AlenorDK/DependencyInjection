import objects.*;

/**
 * Created by Alenor on 10.03.2017.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        context.loadProperties();
        try {
            Car car = (Car) context.getBean("objects.Car");
            Engine engine = car.getEngine();
            System.out.println(engine.getEngineModel());

            Plane plain = (Plane) context.getBean("objects.Plane");
            PlaneEngine plainEngine = plain.getPlaneEngine();
            PlaneEngineProperties prop = plainEngine.getPlaneEngineProperties();
            prop.setFuelCapacity(123);
            System.out.println(plainEngine.getModel() + " with fuel capacity " + prop.getFuelCapacity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
