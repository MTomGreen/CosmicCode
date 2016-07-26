package green.util;

import java.io.BufferedReader;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import green.detector.Detector;
import green.thread.DetectorDownloaderThread;

public class DetectorUtils {
	
	public static int loadProgress;

	public static ArrayList<Detector> detectors = new ArrayList<Detector>();

	public float distanceTo(int detectorID1, int detectorID2) {
		return 0;
	}

	public static double distanceTo(Detector b, Detector a) {
		double radius = 6371;

		double d = (radius * 2)
				* Math.asin(Math.sqrt(Math.pow(Math.sin((b.getLatitudeInRadians() - a.getLatitudeInRadians()) / 2), 2)
				+ Math.cos(a.getLatitudeInRadians()) * Math.cos(b.getLatitudeInRadians())
				* Math.pow((b.getLongitudeInRadians() - a.getLongitudeInRadians()) / 2, 2)));

		return d * 1000;
	}

	public static ArrayList<Detector> getOnlineDetectors() {
		ArrayList<Detector> active = new ArrayList<Detector>();
		for (Detector d : detectors)
			if (d.isActive())
				active.add(d);
		return active;

	}

	public ArrayList<Detector> getAllDetectors() {
		return detectors;
	}

	public static void loadAllDetectors() {
		BufferedReader reader = WebUtils.getReaderForURL(API.BASE_URL + API.DETECTOR_LIST);
		String src = null;
		try {
			src = reader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		};

		JsonParser parser = new JsonParser();
		JsonArray array = (JsonArray) parser.parse(src);
		for (int i = 0; i < array.size(); i++) {
			JsonObject object = (JsonObject) array.get(i);
			String name = object.get("name").getAsString();
			int number = object.get("number").getAsInt();
			Detector detector = new Detector(number);
			detector.setName(name);
			detectors.add(detector);
		}

	}

	public String getDetectorNameFromId(int id) {
		return WebUtils.getStationName(id);
	}

	public static void init() {
		loadAllDetectors();
		
		for(Detector d : detectors){
			new DetectorDownloaderThread(d).start();
		}
		
	}
	
	public static void incrementLoadProgress(){
		loadProgress ++;
		//System.out.println(Math.round((double)loadProgress/(double)detectors.size()*100)+"%"); //Print load percentage progress
	}
	
	public static boolean isDataLoaded(){
		return detectors.size() == loadProgress;
	}

}