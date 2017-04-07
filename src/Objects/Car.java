package objects;

import annotation.Autowired;

/**
 * Created by Alenor on 10.03.2017.
 */
public class Car {

    @Autowired
    private Engine engine;

    public String getEngineModel() {
        return engine.getEngineModel();
    }

    public Engine getEngine() {
        return engine;
    }
}
