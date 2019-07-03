import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Road {

  private GeoLocationPoint a;
  private GeoLocationPoint b;

  public Road(GeoLocationPoint a, GeoLocationPoint b) {
    this.a = a;
    this.b = b;
  }

  public double getLength() {
    int latitudeDifference = Math.abs(a.getLatitude() - b.getLatitude());
    int longitudeDifference = Math.abs(a.getLongitude() - b.getLongitude());

    return sqrt(pow(latitudeDifference, 2) + pow(longitudeDifference, 2));
  }

  public boolean connects(City city) {
    return city.getGeoLocationPoint().equals(a)
        || city.getGeoLocationPoint().equals(b);
  }


  public GeoLocationPoint getA() {
    return a;
  }

  public GeoLocationPoint getB() {
    return b;
  }
}
