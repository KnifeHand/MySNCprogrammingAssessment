import java.util.LinkedList;
import java.util.List;

public class TripData {
    private List carTrip;
    private List boatTrip;

    // Trip constructor
    public TripData() {
        // Attributes
        carTrip = new LinkedList();
        boatTrip = new LinkedList();
    }

    public void addCarTrip(double startLat, double startLong,
                           double bearing, double distFeet, String vic) throws Exception {
        Zone zone1 = new Zone();

        GeoCalc.EndingCoordinateData calc = GeoCalc.getEndingCoordinates(
                startLat, startLong, bearing, distFeet);

//        GeoCalc.GreatCircleData calcCircle = GeoCalc.getGreatCircleDistance(15.6,
//                -49.8, 17.0, -20.0);

        System.out.println("End Lat: " + calc.endLatitude);
        System.out.println("End Long: " + calc.endLongitude);
        System.out.println("End bearing: " + calc.endBearing);
        zone1.checkZone(startLat, startLong, vic);
//
//        System.out.println("Reverse bearing: " + calcCircle.reverseBearing);
    }
}
