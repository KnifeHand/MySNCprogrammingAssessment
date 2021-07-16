public class GeoCalc
{
    private static final double ToFeet = 3.28084;
    private static final double ToMeters = 1 / ToFeet;
    private static final double ToRadians = Math.PI / 180;
    private static final double ToDegrees = 1 / ToRadians;
    private static final double TwoPi = 2.0 * Math.PI;
    private static final double a = 6378137;
    private static final double b = 6356752.314245;
    private static final double f = (a - b) / a;
    private static final double aSquared = a * a;
    private static final double bSquared = b * b;

    public static class EndingCoordinateData {
        public double endLatitude;
        public double endLongitude;
        public double endBearing;
    }

    public static class GreatCircleData {
        public double distanceFeet;
        public double startBearing;
        public double reverseBearing;
    }

    public static EndingCoordinateData getEndingCoordinates(
            double startLatitude, double startLongitude, double startBearing, double distanceFeet)
    {
        double phi1 = startLatitude * ToRadians;
        double alpha1 = startBearing * ToRadians;
        double cosAlpha1 = Math.cos(alpha1);
        double sinAlpha1 = Math.sin(alpha1);
        double s = distanceFeet * ToMeters;
        double tanU1 = (1.0 - f) * Math.tan(phi1);
        double cosU1 = 1.0 / Math.sqrt(1.0 + tanU1 * tanU1);
        double sinU1 = tanU1 * cosU1;
        double sigma1 = Math.atan2(tanU1, cosAlpha1);
        double sinAlpha = cosU1 * sinAlpha1;
        double sin2Alpha = sinAlpha * sinAlpha;
        double cos2Alpha = 1 - sin2Alpha;
        double uSquared = cos2Alpha * (aSquared - bSquared) / bSquared;
        double A = 1 + (uSquared / 16384) * (4096 + uSquared * (-768 + uSquared * (320 - 175 * uSquared)));
        double B = (uSquared / 1024) * (256 + uSquared * (-128 + uSquared * (74 - 47 * uSquared)));
        double deltaSigma;
        double sOverbA = s / (b * A);
        double sigma = sOverbA;
        double sinSigma;
        double prevSigma = sOverbA;
        double sigmaM2;
        double cosSigmaM2;
        double cos2SigmaM2;

        for (; ; )
        {
            sigmaM2 = 2.0 * sigma1 + sigma;
            cosSigmaM2 = Math.cos(sigmaM2);
            cos2SigmaM2 = cosSigmaM2 * cosSigmaM2;
            sinSigma = Math.sin(sigma);
            double cosSignma = Math.cos(sigma);

            deltaSigma = B * sinSigma * (cosSigmaM2 + (B / 4.0) * (cosSignma * (-1 + 2 * cos2SigmaM2)
                    - (B / 6.0) * cosSigmaM2 * (-3 + 4 * sinSigma * sinSigma) * (-3 + 4 * cos2SigmaM2)));

            sigma = sOverbA + deltaSigma;

            if (Math.abs(sigma - prevSigma) < 0.0000000000001) break;

            prevSigma = sigma;
        }

        sigmaM2 = 2.0 * sigma1 + sigma;
        cosSigmaM2 = Math.cos(sigmaM2);
        cos2SigmaM2 = cosSigmaM2 * cosSigmaM2;

        double cosSigma = Math.cos(sigma);
        sinSigma = Math.sin(sigma);

        double phi2 = Math.atan2(sinU1 * cosSigma + cosU1 * sinSigma * cosAlpha1,
                (1.0 - f) * Math.sqrt(sin2Alpha + Math.pow(sinU1 * sinSigma - cosU1 * cosSigma * cosAlpha1, 2.0)));
        double lambda = Math.atan2(sinSigma * sinAlpha1, cosU1 * cosSigma - sinU1 * sinSigma * cosAlpha1);
        double C = (f / 16) * cos2Alpha * (4 + f * (4 - 3 * cos2Alpha));
        double L = lambda - (1 - C) * f * sinAlpha * (sigma + C * sinSigma * (cosSigmaM2 + C * cosSigma * (-1 + 2 * cos2SigmaM2)));
        double alpha2 = Math.atan2(sinAlpha, -sinU1 * sinSigma + cosU1 * cosSigma * cosAlpha1);

        EndingCoordinateData calculatedData = new EndingCoordinateData();

        calculatedData.endLatitude = phi2 * ToDegrees;
        calculatedData.endLongitude = startLongitude + (L * ToDegrees);
        calculatedData.endBearing = alpha2 * ToDegrees;

        return calculatedData;
    }

    public static GreatCircleData getGreatCircleDistance(
            double startLatitude, double startLongitude, double endLatitude, double endLongitude)
    {
        double phi1 = startLatitude * ToRadians;
        double lambda1 = startLongitude * ToRadians;
        double phi2 = endLatitude * ToRadians;
        double lambda2 = endLongitude * ToRadians;
        double a2b2b2 = (aSquared - bSquared) / bSquared;
        double omega = lambda2 - lambda1;
        double tanphi1 = Math.tan(phi1);
        double tanU1 = (1.0 - f) * tanphi1;
        double U1 = Math.atan(tanU1);
        double sinU1 = Math.sin(U1);
        double cosU1 = Math.cos(U1);
        double tanphi2 = Math.tan(phi2);
        double tanU2 = (1.0 - f) * tanphi2;
        double U2 = Math.atan(tanU2);
        double sinU2 = Math.sin(U2);
        double cosU2 = Math.cos(U2);
        double sinU1sinU2 = sinU1 * sinU2;
        double cosU1sinU2 = cosU1 * sinU2;
        double sinU1cosU2 = sinU1 * cosU2;
        double cosU1cosU2 = cosU1 * cosU2;
        double lambda = omega;
        double A = 0.0;
        double B = 0.0;
        double sigma = 0.0;
        double deltasigma = 0.0;
        double lambda0;
        boolean converged = false;

        for (int i = 0; i < 20; i++)
        {
            lambda0 = lambda;
            double sinlambda = Math.sin(lambda);
            double coslambda = Math.cos(lambda);
            double sin2sigma = (cosU2 * sinlambda * cosU2 * sinlambda) + Math.pow(cosU1sinU2 - sinU1cosU2 * coslambda, 2.0);
            double sinsigma = Math.sqrt(sin2sigma);
            double cossigma = sinU1sinU2 + (cosU1cosU2 * coslambda);
            sigma = Math.atan2(sinsigma, cossigma);
            double sinalpha = (sin2sigma == 0) ? 0.0 : cosU1cosU2 * sinlambda / sinsigma;
            double alpha = Math.asin(sinalpha);
            double cosalpha = Math.cos(alpha);
            double cos2alpha = cosalpha * cosalpha;
            double cos2sigmam = cos2alpha == 0.0 ? 0.0 : cossigma - 2 * sinU1sinU2 / cos2alpha;
            double u2 = cos2alpha * a2b2b2;
            double cos2sigmam2 = cos2sigmam * cos2sigmam;
            A = 1.0 + u2 / 16384 * (4096 + u2 * (-768 + u2 * (320 - 175 * u2)));
            B = u2 / 1024 * (256 + u2 * (-128 + u2 * (74 - 47 * u2)));
            deltasigma = B * sinsigma * (cos2sigmam + B / 4 * (cossigma * (-1 + 2 * cos2sigmam2) - B / 6 * cos2sigmam * (-3 + 4 * sin2sigma) * (-3 + 4 * cos2sigmam2)));
            double C = f / 16 * cos2alpha * (4 + f * (4 - 3 * cos2alpha));
            lambda = omega + (1 - C) * f * sinalpha * (sigma + C * sinsigma * (cos2sigmam + C * cossigma * (-1 + 2 * cos2sigmam2)));
            double change = Math.abs((lambda - lambda0) / lambda);

            if ((i > 1) && (change < 0.0000000000001))
            {
                converged = true;
                break;
            }
        }

        GreatCircleData calculatedData = new GreatCircleData();

        calculatedData.distanceFeet = b * A * (sigma - deltasigma) * ToFeet;

        if (!converged)
        {
            if (phi1 > phi2)
            {
                calculatedData.startBearing = 180;
                calculatedData.reverseBearing = 0;
            }
            else if (phi1 < phi2)
            {
                calculatedData.startBearing = 0;
                calculatedData.reverseBearing = 180;
            }
            else
            {
                calculatedData.startBearing = Double.NaN;
                calculatedData.reverseBearing = Double.NaN;
            }
        }
        else
        {
            calculatedData.startBearing = Math.atan2(cosU2 * Math.sin(lambda), (cosU1sinU2 - sinU1cosU2 * Math.cos(lambda)));
            calculatedData.reverseBearing = Math.atan2(cosU1 * Math.sin(lambda), (-sinU1cosU2 + cosU1sinU2 * Math.cos(lambda))) + Math.PI;

            calculatedData.startBearing = (((calculatedData.startBearing * ToDegrees) % 360) + 360) % 360;
            calculatedData.reverseBearing = (((calculatedData.reverseBearing * ToDegrees) % 360) + 360) % 360;
        }
        return calculatedData;
    }
}
