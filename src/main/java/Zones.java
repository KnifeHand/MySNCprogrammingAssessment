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

    public void checkZone(double startLat, double startLong, String vicType) throws Exception {
        if (!vicType.equals("Car")) {
            ///////// Zone 1 ////////////
            if (startLat < zone1StartLat) {
                throw new Exception("Latitude must be > " + zone1StartLat);
            }
            if (startLat > zone1EndLat) {
                throw new Exception("Latitude must be > " + zone1EndLat);
            }
            if (startLong < zone1StartLong) {
                throw new Exception("Longitude must be > " + zone1StartLong);
            }
            if (startLong > zone1EndLong) {
                throw new Exception("Longitude must be < " + zone1EndLong);
            }
            ///////// Zone 2 ///////////
//            if (startLat < zone2StartLat) {
//                throw new Exception("longitude must be > " + zone2StartLat);
//            }
//            if (startLat > zone2EndLat) {
//                throw new Exception("longitude must be < " + zone2EndLat);
//            }
//            if (startLong < zone2StartLong) {
//                throw new Exception("longitude must be > " + zone2StartLong);
//            }
//            if (startLong > zone2EndLong) {
//                throw new Exception("longitude must be < " + zone2EndLong);
//            }
        }
        System.out.println("Good to travel here!");
    }
}
