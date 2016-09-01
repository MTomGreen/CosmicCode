package green.math;

import green.detector.Detector;
import green.objects.Coincidence;
import green.objects.HitEvent;
import green.util.DetectorUtils;
/** 
 * This code was written using the equations found in the following document:
 * https://s3.amazonaws.com/uploads.hipchat.com/597821/4114348/AmMfknwQuRygIiy/CosmicShowerFront.pdf
 * **/
public class CartesianLocationMath {
	
	public static double earthRadius = 6371000; //In meters
	public static double c = 298893080.626; //This is a speed of a Muon not the speed of light. It is called c for consistancy with the document.
	
	public static VectorDouble getAnglesForCoincidence(Coincidence coincidence){
		
		if(coincidence.events.size() < 3){
			System.err.println("There must be at lestationAt 3 events to calculate the angle!");
			return null;
		}
		
		HitEvent A = coincidence.events.get(0);
		HitEvent B = coincidence.events.get(1); //Only uses the first 3 events, stationA of now
		HitEvent C = coincidence.events.get(2);
		
		Detector stationA = DetectorUtils.getDetectorFromID(A.detectorID);
		Detector stationB = DetectorUtils.getDetectorFromID(B.detectorID);
		Detector stationC = DetectorUtils.getDetectorFromID(C.detectorID);
		
		double Tb = (B.nanosAfter - A.nanosAfter)*10e-9;
		B.relativeTime = Tb;    
		double Tc = (C.nanosAfter - A.nanosAfter)*10e-9;
		C.relativeTime = Tc;
		
		Vector3Double ACoords = new Vector3Double(earthRadius+stationA.getAltitude()*cos(stationA.getLatitude()*stationA.getLongitude()),earthRadius+stationA.getAltitude()*cos(stationA.getLatitude()*sin(stationA.getLongitude())),earthRadius+stationA.getAltitude()*sin(stationA.getLatitude()));
		Vector3Double BCoords = new Vector3Double(earthRadius+stationB.getAltitude()*cos(stationB.getLatitude()*stationB.getLongitude()),earthRadius+stationB.getAltitude()*cos(stationB.getLatitude()*sin(stationB.getLongitude())),earthRadius+stationB.getAltitude()*sin(stationB.getLatitude()));
		Vector3Double CCoords = new Vector3Double(earthRadius+stationC.getAltitude()*cos(stationC.getLatitude()*stationC.getLongitude()),earthRadius+stationC.getAltitude()*cos(stationC.getLatitude()*sin(stationC.getLongitude())),earthRadius+stationC.getAltitude()*sin(stationC.getLatitude()));
		
		
		/**
		 * p - a
		 * q - b
		 * r - c
		 * s - d
		 */
		double p = (BCoords.getY()-ACoords.getY())*(CCoords.getZ()-ACoords.getZ())-(CCoords.getY()-ACoords.getY())*(BCoords.getZ()-ACoords.getZ());
		double q = (BCoords.getZ()-ACoords.getZ())*(CCoords.getX()-ACoords.getX())-(CCoords.getZ()-ACoords.getZ())*(BCoords.getZ()-ACoords.getZ()); 
		double r = (BCoords.getX()-ACoords.getX())*(CCoords.getY()-ACoords.getY())-(CCoords.getX()-ACoords.getX())*(BCoords.getY()-ACoords.getY());
		
		// [5-7]
		double Sa = p*ACoords.getX()+q*ACoords.getY()+r*ACoords.getZ();
		double Sb = p*ACoords.getX()+q*ACoords.getY()+r*ACoords.getZ();
		double Sc = p*ACoords.getX()+q*ACoords.getY()+r*ACoords.getZ();
		
		// [8-10]
		double Xa2 = Sa/p;  double Ya2 = Sa/q;  double Za2 = Sa/r;
		double Xb2 = Sb/p;  double Yb2 = Sb/q;  double Zb2 = Sb/r;
		double Xc2 = Sc/p;  double Yc2 = Sb/q;	double Zc2 = Sc/r;
		
		// [14]
		//double AC2 = (Sc-Sa)/Math.sqrt((p*p)+(q*q)+(r*r));
		
		// [15]
		double AC2 = (p*(CCoords.getX()-ACoords.getX())+q*(CCoords.getY()-ACoords.getY())+r*(CCoords.getZ()-ACoords.getZ()))/(Math.sqrt(p*p + q*q + r*r));
		
		
		
		double azimuth = Math.toDegrees(Math.atan(q/p));
		
		//System.out.println(azimuth);
		
		double qp = -(-Tc/Tb);
		System.out.println(qp);
		
		return null;
	}
	
	private static double cos(double d){
		return Math.cos(d);
	}
	
	private static double sin(double d){
		return Math.sin(d);
	}

}