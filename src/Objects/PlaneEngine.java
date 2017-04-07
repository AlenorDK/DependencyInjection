package objects;

import annotation.Autowired;

/**
 * Created by Alenor on 14.03.2017.
 */
public interface PlaneEngine {

    String getModel();
    PlaneEngineProperties getPlaneEngineProperties();
    void setPlaneEngineProperties(PlaneEngineProperties planeEngineProperties);

}
