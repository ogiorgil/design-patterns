package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;

public class SweetsMonitor implements EventMonitor {
    private ArrayList<RoadUser> observers;

    public SweetsMonitor() {
        observers = new ArrayList<>();
    }

    @Override
    public void addRoadUser(RoadUser roadUser) {
        // TODO Auto-generated method stub
        observers.add(roadUser);
    }

    @Override
    public void notifyRoadUsers(String newSweetsLocation) {
        // TODO Auto-generated method stub
        for (RoadUser r: observers) {
            r.handleNotification(getName(), newSweetsLocation);
        }
    }

    @Override
    public String getName() {
        return "Sweets Monitor";
    }
    
}
