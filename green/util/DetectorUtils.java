package green.util;

import java.util.ArrayList;

import green.detector.Detector;

public class DetectorUtils {
	
	public float distanceTo(Detector d, int detectorID){
		return 0;
	}
	
	public float distanceTo(int detectorID1, int detectorID2){
		return 0;
	}
	
	public static double distanceTo(Detector b, Detector a){
		double radius = 6371;
		
		double d = (radius * 2) * Math.asin(
				Math.sqrt(
						Math.pow(Math.sin((b.getLatitudeInRadians()-a.getLatitudeInRadians())/2),2)+
						Math.cos(a.getLatitudeInRadians()) *
						Math.cos(b.getLatitudeInRadians())*
						Math.pow((b.getLongitudeInRadians()-a.getLongitudeInRadians())/2, 2)
						)
				);
		
		return d*1000;
	}
	
	public ArrayList<Detector> getOnlineDetectors(){
		return null;
		//Grab detectors from the database
	}
	
	public String getDetectorNameFromId(int id){
		return null;
	}

}
