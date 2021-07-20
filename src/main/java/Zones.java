class Zone {
    private final double zone3StartLat = -43.4f;
    private final double zone4StartLat = -41.1f;
    private final double zone3EndLat = 8.1f;
    private final double zone4EndLat = -1.4f;
    private final double zone3StartLong = -161.4f;
    private final double zone4StartLong = 62.2f;
    private final double zone2EndLong = 8.2f;
    private final double zone3EndLong = -98.4f;
    private final double zone4EndLong = 94.5f;


    public void checkZone(double startLat, double startLong, String vicType) throws Exception {
        // Class attributes
        double zone1StartLat = 15.6;
        double zone1EndLat = 56.2;
        double zone1StartLong = -49.8;
        double zone1EndLong = -23.1;
        double zone2StartLat = -48.8;
        double zone2EndLat = -6.9;
        double zone2StartLong = -28.6;

        if (!vicType.equals("Car")) {
            if (startLat < zone1StartLat) {
                throw new Exception("Latitude must be > " + zone1StartLat);
            }
            if (startLat >= zone1EndLat) {
                throw new Exception("Latitude must be < " + zone1EndLat);
            }
            if(startLat < zone2StartLat){
                throw new Exception("Latitude must be > " + zone2StartLat);
            }
            if(startLat < zone2EndLat){
                throw new Exception("Latitude must be > " + zone2EndLat);
            }
            if (startLong >= zone1StartLong) {
                throw new Exception("Longitude must be < " + zone1StartLong);
            }
            if (startLong >= zone1EndLong) {
                throw new Exception("Longitude must be < " + zone1EndLong);
            }
            if(startLong > zone2StartLong){
                throw new Exception("Longitude must be < " + zone2StartLong);
            }
        }
        System.out.println("Good to travel here!");
    }
}
