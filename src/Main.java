public class Main {

  public static void main(String[] args) {
    GPS gps = GpsFactory.getInstance();
    gps.getDirection( "G");
  }
}
