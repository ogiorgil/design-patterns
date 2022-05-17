package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.ArrayList;
import java.util.List;

public class DragoHunter implements RoadUser {
    private String name;
    private int speed;
    private List<String> allowedRoutes;
    private List<String> traversableRoutes;
    private List<String> invalidRoutes;
    private RouteStrategy routeStrategy;
    /*
        speed: the speed of the courier
        allowedRoutes: name of all possible routes this courier can visit
    */
    public DragoHunter(String name, int speed, List<String> allowedRoutes) {
        this.name = name; 
        this.speed = speed;
        this.allowedRoutes = allowedRoutes;
        this.traversableRoutes = new ArrayList<>();
        this.invalidRoutes = new ArrayList<>(allowedRoutes);
        this.routeStrategy = new DragoHunterRouteStrategy();
    }

    @Override
    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    @Override
    public void handleNotification(String notificationFrom, String location) {
        routeStrategy.calculateRoutes(allowedRoutes, traversableRoutes, invalidRoutes,
                notificationFrom, location);
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<String> getTraversableRoutes() {
        return new ArrayList<>(traversableRoutes);
    }

    @Override
    public String getName() {
        return name;
    }
    
}
