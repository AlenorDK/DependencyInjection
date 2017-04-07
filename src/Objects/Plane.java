package objects;

import annotation.Autowired;

/**
 * Created by Alenor on 14.03.2017.
 */
public class Plane {

    @Autowired
    private PlaneEngine planeEngine;

    public PlaneEngine getPlaneEngine() {
        return planeEngine;
    }
}
