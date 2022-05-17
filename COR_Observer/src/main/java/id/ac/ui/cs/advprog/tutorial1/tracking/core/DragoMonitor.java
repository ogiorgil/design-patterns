package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;

public class DragoMonitor implements EventMonitor {
    private ArrayList<RoadUser> observers;

    public DragoMonitor() {
        observers = new ArrayList<>();
    }

    @Override
    public void addRoadUser(RoadUser roadUser) {
        // TODO Auto-generated method stub
        observers.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newDragoLocation) {
        // TODO Auto-generated method stub
        for (RoadUser r: observers) {
            r.handleNotification(getName(), newDragoLocation);
        }
    }

    @Override
    public String getName() {
        return "Drago Monitor";
    }
    
}
