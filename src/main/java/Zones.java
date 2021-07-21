/**
 * This class facilitates a way of checking which zone the vehicle is in.
 *
 * @author - Matt Hurt
 */

class Zone {
    private final double zone1StartLat = 15.6;
    private final double zone1EndLat = 56.2;
    private final double zone1StartLong = -49.8;
    private final double zone1EndLong = -23.1;

    private final double zone2StartLat = -48.8;
    private final double zone2EndLat = -6.9;
    private final double zone2StartLong = -28.6;
    private final double zone2EndLong = 8.2;

    private final double zone3StartLat = -43.4;
    private final double zone3EndLat = 8.1;
    private final double zone3StartLong = -161.4;
    private final double zone3EndLong = -98.4;

    private final double zone4StartLat = -41.1;
    private final double zone4EndLat = -1.4;
    private final double zone4StartLong = 62.2;
    private final double zone4EndLong = 94.5;

    /**
     * Checks conditions of the current position of the vehicle are within the
     * range boundary of the zone. A useful print statement is sent to the console
     * along with the current position coordinates of the vehicle to observe if
     * the vehicle is traveling in the zone or not.
     *
     * @param startLat - Recieves current Latitude from add method in TripData class and checks to see if in bounds.
     * @param startLong - Recieves current Longitude from add method in TripData class and checks to see if in bounds.
     */
    public void checkZone(double startLat, double startLong, Vehicle vic) {
        System.out.println(vic);
        if (startLat > zone1StartLat && startLat < zone1EndLat && startLong > zone1StartLong && startLong < zone1EndLong) {
            System.out.println("In bounds of Zone1 " + startLat + ", " + startLong);
        } else if (startLat > zone2StartLat && startLat < zone2EndLat && startLong > zone2StartLong && startLong < zone2EndLong) {
            System.out.println("In bounds of Zone2 "+ startLat + ", " + startLong);
        } else if (startLat > zone3StartLat && startLat < zone3EndLat && startLong > zone3StartLong && startLong < zone3EndLong) {
            System.out.println("In bounds of Zone3 "+ startLat + ", " + startLong);
        } else if (startLat > zone4StartLat && startLat < zone4EndLat && startLong > zone4StartLong && startLong < zone4EndLong) {
            System.out.println("In bounds of Zone4 "+ startLat + ", " + startLong);
        } else {
            System.out.println("Out of bounds "+ startLat + ", " + startLong);
        }
    }
}
