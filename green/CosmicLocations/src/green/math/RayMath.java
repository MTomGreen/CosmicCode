package green.math;

import green.detector.Detector;
import green.objects.Coincidence;
import green.objects.HitEvent;
import green.util.DetectorUtils;
import net.danceswithcode.Coord;

public class RayMath {
	
	
	/**
	 * Calculates the Azimuth and Zenith angles from a given coincidence.
	 * @param c The coincidence from which to calculate the angles.
	 */
	public static void getAngleFromCoincidence(Coincidence c){
		HitEvent EventA = c.events.get(0);
		HitEvent EventB = c.events.get(1);
		HitEvent EventC = c.events.get(2);
		
		double timeA = EventA.nanosAfter; //absolute
		double timeB = EventB.nanosAfter - timeA; //relative
		double timeC = EventC.nanosAfter - timeA; //relative
		
		//Convert from nanoseconds to seconds.
		timeB = timeB * 10e-9;
		timeC = timeC * 10e-9;
		
		Detector stationA = DetectorUtils.getDetectorFromID(EventA.detectorID);
		Detector stationB = DetectorUtils.getDetectorFromID(EventB.detectorID); //Station is just easier to type than detector.
		Detector stationC = DetectorUtils.getDetectorFromID(EventC.detectorID);
		
//		System.out.println("Station A: " + stationA.getStationID() + "  Latitude: " + stationA.getLatitudeInRadians() + " Longitude: " + stationA.getLongitudeInRadians() + " Altitude: " + stationA.getAltitude());
//		System.out.println("Station B: " + stationB.getStationID() + "  Latitude: " + stationB.getLatitudeInRadians() + " Longitude: " + stationB.getLongitudeInRadians() + " Altitude: " + stationB.getAltitude());
//		System.out.println("Station C: " + stationC.getStationID() + "  Latitude: " + stationC.getLatitudeInRadians() + " Longitude: " + stationC.getLongitudeInRadians() + " Altitude: " + stationC.getAltitude());
		
		
		double[] posA = Coord.geo_to_ecef(stationA.getLatitudeInRadians(), stationA.getLongitudeInRadians(), stationA.getAltitude());
		double[] posB = Coord.geo_to_ecef(stationB.getLatitudeInRadians(), stationB.getLongitudeInRadians(), stationB.getAltitude());
		double[] posC = Coord.geo_to_ecef(stationC.getLatitudeInRadians(), stationC.getLongitudeInRadians(), stationC.getAltitude());
		
		
		
		VectorDouble PosB = new VectorDouble(Math.abs(posB[0] - posA[0]), Math.abs(posB[2]-posA[2]));
		VectorDouble PosC = new VectorDouble(posC[0] - posA[0], posC[1] - posA[1]);
		
		//VectorDouble PosB2 = 
		
		double m = (PosC.getY()*timeB-PosB.getY()*timeC) / (PosC.getX() * timeB - PosB.getX() * timeC); //This will be in radians
		//System.out.println("Angle: " + m + " radians, " + Math.toDegrees(m)+" degrees.");
		
		
		//Do the equations take degrees or radians? Degrees give more believable yet still incorrect results.
		double m2 = Math.toDegrees(m);
		
		double cc = LocationMath.SPEED_OF_LIGHT;
		
		double v = PosC.getY() - m * PosC.getX() / timeC * Math.sqrt((m2*m2)+1);
		v = Math.sqrt(v*v); //Make the velocity be always positive.
		
		System.out.println("Velocity: " + v + "m/s, which is " + (v > cc ? "faster" : "slower") + " than the speed of light");
		
		double azimuth = Math.toDegrees(Math.atan(m2 - 90));
		double zenith = Math.toDegrees(Math.asin(LocationMath.SPEED_OF_LIGHT / v));
		
		System.out.println("Azimuth: " + azimuth + "\r\nZenith: " + zenith);
	}

}
