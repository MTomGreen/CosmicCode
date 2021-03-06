package green.util;

import green.math.EventTime;

public class TimeUtils {
	
	public void getCelestialTime(){
		
	}
	
	public static EventTime getTimeBetween(EventTime a, EventTime b){
		EventTime returns = new EventTime();
		returns.setNanosAfter(b.getNanosAfter()-a.getNanosAfter());
		returns.setUnixTime(b.getUnixTime()-a.getUnixTime());
		String[] partsA = a.getDate().split("-");
		String[] partsB = b.getDate().split("-");
		String year  = ""+(Integer.parseInt(partsB[0])-Integer.parseInt(partsA[0]));
		String month = ""+(Integer.parseInt(partsB[1])-Integer.parseInt(partsA[1])); 
		String day   = ""+(Integer.parseInt(partsB[2])-Integer.parseInt(partsA[2]));
		returns.setDate(year+"-"+month+"-"+day);
		return returns;
	}

}
