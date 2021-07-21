/**
 * This class creates the car and boat objects and passes in the specification
 * attributes to the constructors. The waypoints are created by invoking the add
 * method using the vehicle object type.
 *
 * @author - Matt Hurt
 */

public class WaypointGenerator {

    public static void main(String[] args) throws Exception {
        // Create vehicle trip object
        TripData carTrip = new TripData();
        TripData boatTrip = new TripData();

        // Create car and boat object and pass in constructor attributes.
        Vehicle boat = new Boat("BOAT","Oceanis 60",48600,
                16.75f,120.5f,59.83f,"SAIL",8.2f,"Beneteau");

        Vehicle car = new Car("CAR","Leaf",3243f,5.81f,5.08f,
                14.58f,"Nissan",2014,"COMPACT","ELECTRIC");

        // Start trip by passing in beginning position, intended direction of travel starting speed and vehicle
        // object attributes.
        carTrip.addCarTrip(-20.4, -8.2, 60.0, 0.0, car);
        boatTrip.addBoatTrip(-20.0, -10.4, 0.0, 0, boat);










    }
    
}
