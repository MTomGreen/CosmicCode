package green.math;

import java.util.ArrayList;
import java.util.List;

import green.detector.Detector;
import green.objects.Coincidence;

public class LocationMath {
	
	public static ArrayList<VectorDouble> positions;
	public static Coincidence coincidence;
	
	public static final double SPEED_OF_LIGHT = 299792458; //Meters per Second
	public static final double SPEED_OF_MUON = SPEED_OF_LIGHT*0.98; //Meters per Second
	
	public static void setPositions(Coincidence c){
		coincidence = c;
		for(Detector d : c.detectors)
			positions.add(new VectorDouble(d.getLatitude(), d.getLongitude()));
	}
	
	public static void reconstructAngles(Coincidence c){
		
	}
	
	public static void reconstructAllAngles(Coincidence c){
		List<Double> angles = new ArrayList<Double>();
		
		
		
	}
	
	
	
	

}