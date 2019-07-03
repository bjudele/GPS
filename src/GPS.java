import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class GPS {

  private GeoLocationPoint currentLocation;
  private GeoMap geoMap;
  private Map<String, List<City>> pathToEachCity;

  public GPS(GeoMap geoMap) {

    this.geoMap = geoMap;
    pathToEachCity = new HashMap<>();
    for (City each : geoMap.getCities()) {
      pathToEachCity.put(each.getCityName(), new ArrayList<>(Arrays.asList(each)));
    }
  }

  public List<Road> getDirection(String from, String to) {
    City source = geoMap.getCity(from);
    City target = geoMap.getCity(to);

    List<City> visitedCities = new LinkedList<>();

    Map<City, Double> citiesAndDistances = geoMap.initialNeighboursAndDistances(source);

    Queue<City> unvisitedCities = new PriorityQueue<City>();
    unvisitedCities.add(source);

    while (unvisitedCities.isEmpty() == false) {
      City currentCity = unvisitedCities.poll();
      Double distanceToCurrentCity = citiesAndDistances.get(currentCity);

      Map<City, Double> currentCityNeighbours = geoMap.getNeighboursAndDistancesOf(currentCity);

      for (Map.Entry<City, Double> entry : currentCityNeighbours.entrySet()) {
        City neighbourCity = entry.getKey();
        if (visitedCities.contains(neighbourCity)) {
          continue;
        }
        unvisitedCities.add(neighbourCity);
        Double neighbourDistance = entry.getValue();
        Double oldDistanceToNeighbour = citiesAndDistances.get(neighbourCity);
        if (Double.compare(distanceToCurrentCity + neighbourDistance, oldDistanceToNeighbour) < 0) {

          citiesAndDistances.put(neighbourCity, distanceToCurrentCity + neighbourDistance);

          List<City> pathToCurrentCity = new ArrayList<>(pathToEachCity.get(currentCity.getCityName()));

          pathToCurrentCity.add(neighbourCity);
          pathToEachCity.put(neighbourCity.getCityName(), pathToCurrentCity);
        }
      }
      visitedCities.add(currentCity);

    }
    System.out.println(citiesAndDistances);
    GeoLocationPoint D = new GeoLocationPoint(2, 7);
    System.out.println(pathToEachCity.get("D"));
    return null;
  }


  public List<Road> getRoadsConnectedWith(String cityName) {
    return null;
  }

  public GeoLocationPoint getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(GeoLocationPoint currentLocation) {
    this.currentLocation = currentLocation;
  }

  public GeoMap getMap() {
    return geoMap;
  }

  public void setMap(GeoMap map) {
    this.geoMap = map;
  }
}
