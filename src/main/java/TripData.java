import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TripData {
    private List carTrip;
    private List boatTrip;

    // Trip constructor
    public TripData() {
        // Attributes
        carTrip = new LinkedList();
        boatTrip = new LinkedList();
    }

    public static void addCarTrip(double startLat, double startLong,
                                  double bearing, double distFeet, Vehicle vic) {
        System.out.println(vic + "\n");

        System.out.println(startLat + ", " + startLong + ", " + startTime);
        distFeet = randomDistGenCar(0);
//            System.out.println(startLat + ", " + startLong);
        getNewCoordinatesData(startLat, startLong, bearing, distFeet, vic);

        for (int i = 0; i < 15; i++) {
            randomCarBearingGen(bearing);
            getNewCoordinatesData(startLat2, startLong2, newBearing, distFeet, vic);
            timeSinceLastPoint(distFeet, carSpeed, startTime);
            startTime = newTime;
            System.out.println(startLat2 + ", " + startLong2 + ", " + newTime);

        }
    }

    //
//    public static void addBoatTrip(double startLat, double startLong,
//                            double bearing, double distFeet, String vicType) throws Exception {
//
//        System.out.println("Start lat: " + startLat + "\nStart long: " + startLong
//                + "\nBearing: " + bearing + "\nDistance to travel: "
//                + distFeet + "\nVehicle: " + "\n");
//
//        for(int i = 0; i < 3; i++) {
//            System.out.println("Trip: " + i);
//            endingCoordinates(startLat,startLong,bearing,distFeet, vicType);
//        }
//    }
//

    public static EndingCoordinatesData getNewCoordinatesData(double Lat, double Long, double bearing, double dist, Vehicle vicType) {
        double endlat, endlong, newBearing;

        GeoCalc.EndingCoordinateData calc = GeoCalc.getEndingCoordinates(
                Lat, Long, bearing, dist);

        EndingCoordinatesData newCoordinates = new EndingCoordinatesData();

        newCoordinates.endLatitude = calc.endLatitude;
        newCoordinates.endLongitude = calc.endLongitude;

        startLat2 = newCoordinates.endLatitude;
        startLong2 = newCoordinates.endLongitude;


//        System.out.print(startLat2 = calc.endLatitude);
//        System.out.println(", ");
//        System.out.println(startLong2 = calc.endLongitude);

        return newCoordinates;

    }

    public static double randomCarBearingGen(double oldBearing) {
        double min = -90.0;
        double max = 90.0;
        Random rand = new Random();
        double newBearingValue = min + (max - min) * rand.nextDouble();
        newBearing = oldBearing + newBearingValue;

        if (newBearing > 360.0) {
            newBearing = newBearing - 360;
        }
        if (newBearing < 0.0) {
            newBearing = newBearing + 360;
        }

        return newBearing;
    }

//    public static double randomBoatBearingGen(double oldBearing){
//        double min = -30.0;
//        double max = 30;
//        Random rand = new Random();
//        return 0;//FIXME
//    }

    public static double randomDistGenCar(double dist) {
        double min = dist;
        double max = 2000000.0;
        Random random = new Random();
        double distanceTraveled = min + (max - min) * random.nextDouble();
        return distanceTraveled;
    }

    public static float timeSinceLastPoint(double distanceTraveled, double carSpeed, float startTime) {
        float timeElapsed = startTime + ((float) (distanceTraveled / carSpeed));
        newTime = timeElapsed;

        return timeElapsed;
    }
}
