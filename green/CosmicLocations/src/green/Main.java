package green;

import green.thread.MainThread;

public class Main {
	
	public static MainThread main;

	public static void main(String[] args) {
		main = new MainThread();
		main.start();  //Start up an actual main thread. This thread will terminate.
		
		
//		Detector a = new Detector(505);
//		Detector b = new Detector(511);
//		
//		a.setLatitude(52.3572524);
//		a.setLongitude(4.948385);
//		
//		b.setLatitude(52.3564362);
//		b.setLongitude(4.9485824);
//		

		
		
		//System.out.println(DetectorUtils.distanceTo(a, b));
		//System.out.println(MathUtils.getEarthRotation(23.5));
		//System.out.println(MathUtils.getSiderealTime(15));
//		WebUtil.getStationName(14001);
		
//		StationInfo f = new StationInfo(2005);
//		f.updateStationInfo();
//		
//		System.out.println(WebUtil.getStationName(2005));
//		System.out.println(f.getCountry());
//		System.out.println(f.getSubCluster());
	}

}