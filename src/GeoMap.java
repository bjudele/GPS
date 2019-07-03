import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeoMap {

  private Set<City> cities = new HashSet<>();
  private Set<Road> roads = new HashSet<>();

  public City getCity(String cityName) {
    for (City each : cities) {
      if (each.getCityName().compareTo(cityName) == 0) {
        return each;
      }
    }
    return null;
  }

  public Set<City> getCities() {
    return cities;
  }


  public Map<City, Double> initialNeighboursAndDistances(City source) {
    Map<City, Double> result = new HashMap<>();
    for (City each : this.cities) {
      result.put(each, Double.MAX_VALUE);
    }
    result.put(source, 0d);
    return result;
  }

  public Map<City, Double> getNeighboursAndDistancesOf(City city) {
    Map<City, Double> result = new HashMap<>();
    for (Road each : roads) {
      if (each.connects(city)) {
        GeoLocationPoint a = each.getA();
        GeoLocationPoint b = each.getB();

        City cityA = this.getCityAt(a);
        City cityB = this.getCityAt(b);

        if (city.equals(cityA)) {
          result.put(cityB, each.getLength());
        } else {
          result.put(cityA, each.getLength());
        }
      }
    }
    return result;
  }


  private City getCityAt(GeoLocationPoint locationPoint) {
    for (City each : cities) {
      if (each.getGeoLocationPoint().equals(locationPoint)) {
        return each;
      }
    }
    return null;
  }

  public void setCities(Set<City> cities) {
    this.cities = cities;
  }

  public Set<Road> getRoads() {
    return roads;
  }

  public void setRoads(Set<Road> roads) {
    this.roads = roads;
  }

  public void add(Road... roads) {
    for (int index = 0; index < roads.length; index++) {
      this.roads.add(roads[index]);
    }
  }

  public void add(City... cities) {
    for (int index = 0; index < cities.length; index++) {
      this.cities.add(cities[index]);
    }
  }
}
