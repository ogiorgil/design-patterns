package id.ac.ui.cs.advprog.tutorial1.tracking.core;

import java.util.List;

public class SweetCourierRouteStrategy implements RouteStrategy {
    private String sweetLocation = "None";
    private String prevDragoLocation = "None";

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
                if (sweetLocation.equals("None")) {
                    if (!prevDragoLocation.equals("None")) {
                        invalidRoutes.remove(prevDragoLocation);
                        traversableRoutes.add(prevDragoLocation);
                    }
                    if (!location.equals("None")) {
                        traversableRoutes.remove(location);
                        invalidRoutes.add(location);
                    }
                }
                prevDragoLocation = location;
                break;
            case "Sweets Monitor":
                if (location.equals("None")) {
                    traversableRoutes.clear();
                    traversableRoutes.addAll(allowedRoutes);
                    traversableRoutes.remove(prevDragoLocation);

                    invalidRoutes.clear();
                    if (!prevDragoLocation.equals("None")) {
                        invalidRoutes.add(prevDragoLocation);
                    }
                } else {
                    traversableRoutes.clear();
                    traversableRoutes.add(location);

                    invalidRoutes.clear();
                    invalidRoutes.addAll(allowedRoutes);
                    invalidRoutes.remove(location);
                }
                sweetLocation = location;
                break;
        }

    }
}
