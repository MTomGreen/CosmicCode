package green.math;

import green.detector.Detector;
import green.util.DetectorUtils;
import net.danceswithcode.Coord;

public class ConstantsGenerator {
	
	public static void getConstantsFor(int a, int b, int  c){
		Detector detectorA = DetectorUtils.getDetectorFromID(a);
		Detector detectorB = DetectorUtils.getDetectorFromID(b);
		Detector detectorC = DetectorUtils.getDetectorFromID(c);
		
		Vector3Double ACoords = new Vector3Double(detectorA.getLatitude(), detectorA.getLongitude(), detectorA.getAltitude());
		Vector3Double BCoords = new Vector3Double(detectorB.getLatitude(), detectorB.getLongitude(), detectorB.getAltitude());
		Vector3Double CCoords = new Vector3Double(detectorC.getLatitude(), detectorC.getLongitude(), detectorC.getAltitude());
		

		Vector3Double A = new Vector3Double(Coord.geo_to_ecef(ACoords.getX(), ACoords.getY(), ACoords.getZ()));
		Vector3Double B = new Vector3Double(Coord.geo_to_ecef(BCoords.getX(), BCoords.getY(), BCoords.getZ()));
		Vector3Double C = new Vector3Double(Coord.geo_to_ecef(CCoords.getX(), CCoords.getY(), CCoords.getZ()));
		
		Vector3Double A2 = new Vector3Double(A.getX()-A.getX(), A.getY()-A.getY(), A.getZ()-A.getZ());
		Vector3Double B2 = new Vector3Double(B.getX()-A.getX(), B.getY()-A.getY(), B.getZ()-A.getZ());
		Vector3Double C2 = new Vector3Double(C.getX()-A.getX(), C.getY()-A.getY(), C.getZ()-A.getZ());
		
		System.out.println(A2);
		System.out.println(B2);
		System.out.println(C2);
		
		
	}

}
