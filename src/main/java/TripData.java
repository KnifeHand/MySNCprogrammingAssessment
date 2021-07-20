import java.sql.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TripData {
    // Attributes
    private Array carTrip;
    private Array boatTrip;

    // Trip constructor
    public TripData() {
       String[] carTrip = new String[15];
       String[] boatTrip = new String[15];
    }

    public TripData(
            double startLat,
            double startLong,
            double bearing,
            double distFeet) {
    }

    public void addCarTrip(
            double startLat,
            double startLong,
            double bearing,
            double distFeet) {

        Vehicle car = new Car(
                "CAR",
                "Leaf",
                3243f,
                5.81f,
                5.08f,
                14.58f,
                "Nissan",
                2014,
                "COMPACT",
                "ELECTRIC");

        TripData tripData = new TripData(
                startLat,
                startLong,
                bearing,
                distFeet);
    }

//    public static void ran
//    bearing
//    bearing = currBearing + (randBearing)
//
//            randBearingCar = randcarBearing (generator for + or - 90)
//            if new bearing is negative add 360
}
