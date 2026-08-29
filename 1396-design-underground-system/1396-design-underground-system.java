import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // customerId -> [stationName, checkInTime]
    private Map<Integer, CheckInInfo> checkIns;

    // "startStation#endStation" -> [totalTime, tripCount]
    private Map<String, RouteInfo> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);

        int travelTime = t - info.time;

        String route = info.station + "#" + stationName;

        RouteInfo routeInfo = routes.getOrDefault(
            route,
            new RouteInfo(0, 0)
        );

        routeInfo.totalTime += travelTime;
        routeInfo.tripCount++;

        routes.put(route, routeInfo);

        // Customer has completed the trip
        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        RouteInfo routeInfo = routes.get(route);

        return (double) routeInfo.totalTime / routeInfo.tripCount;
    }

    // Stores check-in information
    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores route statistics
    private static class RouteInfo {
        long totalTime;
        int tripCount;

        RouteInfo(long totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}