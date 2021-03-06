package green.util;

import green.detector.Detector;

public class MathUtils {

	// Calculate angle of primary particle
	public static double getBearingFrom(Detector a, Detector b) {
		double bearing = Math.atan2(
				cos(a.getLatitude() * sin(b.getLatitude())
						- sin(a.getLatitude()) * cos(b.getLatitude()) * cos(a.getLongitude() - b.getLongitude())),
				sin(b.getLongitude() - a.getLongitude()) * cos(b.getLatitude()));
		return bearing;
	}
	
	
	

	static double cos(double angle) {
		return Math.cos(angle);
	}

	static double sin(double angle) {
		return Math.sin(angle);
	}
	
	

	public static double getEarthRotation(double bin){
		bin += 0.5;
		return Math.toDegrees( (2*(Math.PI)) * (bin/23.93446959));
	}
	
	public static double getEarthRotationInRadians(double bin){
		return ((2*Math.PI)*(bin/23.93446959));
	}
	
	
	public static double getSiderealTime(double bin){
		bin += 0.5;
		return (bin/24)*23.93446959;
	}
	

}
