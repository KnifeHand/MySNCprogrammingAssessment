import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileWriter file = new FileWriter("waypoints.txt");
        PrintWriter out = new PrintWriter(file);

//        Vehicle boat = new Boat(
//                "BOAT",
//                "Oceanis 60",
//                48600,
//                16.75f,
//                120.5f,
//                59.83f,
//                "SAIL",
//                8.2f,
//                "Beneteau"
//        );
//
//        Vehicle car = new Car(
//                "CAR",
//                "Leaf",
//                3243f,
//                5.81f,
//                5.08f,
//                14.58f,
//                "Nissan",
//                2014,
//                "COMPACT",
//                "ELECTRIC"
//        );

        GeoCalc.getEndingCoordinates(
                15.6,
                -49.8,
                10.0,
                200.0
        );



    }
}
