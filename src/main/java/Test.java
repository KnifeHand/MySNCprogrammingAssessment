import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        FileWriter file = new FileWriter("waypoints.txt");
        PrintWriter out = new PrintWriter(file);

        Vehicle boat = new Boat("BOAT","Oceanis 60",48600,
                16.75f,120.5f,59.83f,"SAIL",8.2f,"Beneteau");

        Vehicle car = new Car("CAR","Leaf",3243f,5.81f,5.08f,
                14.58f,"Nissan",2014,"COMPACT","ELECTRIC");
        
        TripData car_trip = new TripData();

        car_trip.addCarTrip(15.6, -49.8, 60.0, 5280.0, "Car");








    }
    
}
