public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    GeoLocationPoint A = new GeoLocationPoint(0, 0);
    GeoLocationPoint C = new GeoLocationPoint(1, 4);
    GeoLocationPoint B = new GeoLocationPoint(4, 0);
    GeoLocationPoint E = new GeoLocationPoint(0, 12);
    GeoLocationPoint D = new GeoLocationPoint(3, 12);
    GeoLocationPoint X = new GeoLocationPoint(2, 8);

    Road road1 = new Road(A, C);
    Road road2 = new Road(C, B);
    Road road3 = new Road(B, D);
    Road road4 = new Road(D, E);
    Road road5 = new Road(A, E);
    Road road6 = new Road(C, X);
    Road road7 = new Road(X, D);

    City city1 = new City("A", A);
    City city2 = new City("B", B);
    City city3 = new City("C", C);
    City city4 = new City("D", D);
    City city5 = new City("E", E);
    City city6 = new City("X", X);

    GeoMap map = new GeoMap();
    map.add(road1, road2, road3, road4, road5, road6, road7);
    map.add(city1, city2, city3, city4, city5, city6);

    GPS gps = new GPS(map);
    gps.setCurrentLocation(A);
    gps.getDirection("A", "D");
  }
}
