import sun.security.x509.AVA;

public class GpsFactory {

  private static GPS gps;

  static {
    GeoLocationPoint A = new GeoLocationPoint(0, 0);
    GeoLocationPoint B = new GeoLocationPoint(18, 0);
    GeoLocationPoint C = new GeoLocationPoint(4, 4);
    GeoLocationPoint D = new GeoLocationPoint(12, 10);
    GeoLocationPoint E = new GeoLocationPoint(0, 12);
    GeoLocationPoint F = new GeoLocationPoint(11, 14);
    GeoLocationPoint G = new GeoLocationPoint(17, 18);

    Road road1 = new Road("AC",A, C);
    Road road2 = new Road("AE",A, E);
    Road road3 = new Road("BE",B, E);
    Road road4 = new Road("BF",B, F);
    Road road5 = new Road("BG",B, G);
    Road road6 = new Road("CD",C, D);
    Road road7 = new Road("DF",D, F);
    Road road8 = new Road("EG",E, G);
    Road road9 = new Road("FG",F, G);

    City city1 = new City("A", A);
    City city2 = new City("B", B);
    City city3 = new City("C", C);
    City city4 = new City("D", D);
    City city5 = new City("E", E);
    City city6 = new City("F", F);
    City city7 = new City("G", G);


    GeoMap map = new GeoMap();
    map.add(road1, road2, road3, road4, road5, road6, road7, road8, road9);
    map.add(city1, city2, city3, city4, city5, city6, city7);

    gps = new GPS(map);
  }

  public static GPS getInstance() {
    return gps;
  }

}
