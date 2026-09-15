import java.util.*;

class UndergroundSystem {

    // Stores customer -> check-in station and time
    HashMap<Integer, CheckIn> checkIns;

    // Stores route -> total travel time
    HashMap<String, Integer> totalTime;

    // Stores route -> number of trips
    HashMap<String, Integer> tripCount;

    public UndergroundSystem() {
        checkIns = new HashMap<Integer, CheckIn>();
        totalTime = new HashMap<String, Integer>();
        tripCount = new HashMap<String, Integer>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;

        int travelTime = t - checkIn.time;

        if (totalTime.containsKey(route)) {
            totalTime.put(route,
                    totalTime.get(route) + travelTime);

            tripCount.put(route,
                    tripCount.get(route) + 1);
        } else {
            totalTime.put(route, travelTime);
            tripCount.put(route, 1);
        }

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation,
                                 String endStation) {

        String route = startStation + "->" + endStation;

        return (double) totalTime.get(route)
                / tripCount.get(route);
    }

    // Class to store check-in information
    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
