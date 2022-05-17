package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface RoadUser {
    void handleNotification(String notificationFrom, String location);
    String getName();
    int getSpeed();
    List<String> getTraversableRoutes();
    void setRouteStrategy(RouteStrategy routeStrategy);
}
