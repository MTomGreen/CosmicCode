package green.math;

import java.util.ArrayList;

import green.detector.Detector;
import green.objects.Coincidence;
import green.objects.HitEvent;
import green.util.DetectorUtils;

public class Locations3 {
	
	private static final double earth_radius = 6378100;
	private static final double c = 298893080.626;
	
	public static VectorDouble getAnglesFor(Coincidence coincidence){
		
		//We only want the first 3 events in the coincidence, for now.
		ArrayList<HitEvent> events = coincidence.events;
		HitEvent eventA = events.get(0);
		HitEvent eventB = events.get(1);
		HitEvent eventC = events.get(2);
		
		Detector detectorA = DetectorUtils.getDetectorFromID(eventA.detectorID);
		Detector detectorB = DetectorUtils.getDetectorFromID(eventB.detectorID);
		Detector detectorC = DetectorUtils.getDetectorFromID(eventC.detectorID);
		
		//Positions of detectors, in terms of X Y and Z.
		Vector3Double positionA = new Vector3Double(earth_radius+detectorA.getAltitude()*cos(detectorA.getLatitude())*cos(detectorA.getLongitude()),earth_radius+detectorA.getAltitude()*cos(detectorA.getLatitude())*sin(detectorA.getLongitude()),earth_radius+detectorA.getAltitude()*sin(detectorA.getLatitude()));
		Vector3Double positionB = new Vector3Double(earth_radius+detectorB.getAltitude()*cos(detectorB.getLatitude())*cos(detectorB.getLongitude()),earth_radius+detectorB.getAltitude()*cos(detectorB.getLatitude())*sin(detectorB.getLongitude()),earth_radius+detectorB.getAltitude()*sin(detectorB.getLatitude()));
		Vector3Double positionC = new Vector3Double(earth_radius+detectorC.getAltitude()*cos(detectorC.getLatitude())*cos(detectorC.getLongitude()),earth_radius+detectorC.getAltitude()*cos(detectorC.getLatitude())*sin(detectorC.getLongitude()),earth_radius+detectorC.getAltitude()*sin(detectorC.getLatitude()));
		
		double Tb = eventB.nanosAfter - eventA.nanosAfter;
		double Tc = eventC.nanosAfter - eventA.nanosAfter;
		
		//relate to positions in the PDF. eg Bx becomes ΔXb in the document.
		double Bx = positionB.getX()-positionA.getX(); double By = positionB.getY()-positionA.getY(); double Bz = positionB.getZ()-positionA.getZ();
		double Cx = positionC.getX()-positionA.getX(); double Cy = positionC.getY()-positionA.getY(); double Cz = positionC.getZ()-positionA.getZ();
		
		double U = - (((Cz*Tb)-(Bz*Tc))/((Cy*Tb)-(By*Tc)));
		double V = - (((Cx*Tb)-(Bx*Tc))/((Cy*Tb)-(By*Tc)));
		
		
		double A = (1-sqr(Cz/c*Tc)+sqr(U)+(1-sqr(Cy/c*Tc))-2*U*(Cy/c*Tc)*Cz/c*Tc);
		double B = 2*(U*V*(1-sqr(Cy/c*Tc))-V*(Cy/c*Tc)*(Cz/c*Tc)-U*(Cx/c*Tc)*(Cy/c*Tc)-(Cx/c*Tc)*(Cz/c*Tc));
		double C = (1-sqr(Cy/c*Tc))-2*V*(Cx/c*Tc)*(Cy/c*Tc)+(1-sqr(Cx/c*Tc));
		B = -B;
		
		double x1 = (-B + Math.sqrt(sqr(B)-4*A*C))/2*A;
		double x2 = (-B - Math.sqrt(sqr(B)-4*A*C))/2*A; //Either of these may be impossible.
		
		System.out.println(A + ", " + B + ", " + C);
		System.out.println(U +", " + V);
		System.out.println(x1 +", " + x2);
		
		//double Q = R*U + V;
		
		return null;
	}
	
	private static double cos(double i){
		return Math.cos(i);
		}
	
	private static double sin(double i){
		return Math.sin(i);
	}
	
	private static double sqr(double i){
		return i * i;
	}

}
