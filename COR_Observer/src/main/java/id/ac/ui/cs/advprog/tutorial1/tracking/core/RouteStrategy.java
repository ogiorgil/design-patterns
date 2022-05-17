package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public interface RouteStrategy {
    void calculateRoutes(List<String> allowedRoutes, List<String> traversableRoutes, List<String> invalidRoutes,
                         String notificationFrom, String location);
}
