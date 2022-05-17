package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class DragoHunterRouteStrategy implements RouteStrategy {
    String prevDragoLocation = "None";
    /**
     * Takes in 3 lists, may or may not edit traversableRoutes and invalidRoutes
     * @param allowedRoutes List<String>
     * @param traversableRoutes List<String>
     * @param invalidRoutes List<String>
     * @param notificationFrom what monitor sends the notification.
     * @param location new location from the monitor.
     */
    @Override
    public void calculateRoutes(List<String> allowedRoutes, List<String> traversableRoutes, List<String> invalidRoutes,
                                String notificationFrom, String location) {
        // use switch case in case there are additions of notifiers we need to watch out for
        switch (notificationFrom) {
            case "Drago Monitor":
                if (!prevDragoLocation.equals("None")) {
                    traversableRoutes.remove(prevDragoLocation);
                    invalidRoutes.add(prevDragoLocation);
                }

                if (!location.equals("None")) {
                    traversableRoutes.add(location);
                    invalidRoutes.remove(location);
                }
                prevDragoLocation = location;
                break;
        }
    }

}
