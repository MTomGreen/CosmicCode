package green.util;

import java.util.ArrayList;
import java.util.Iterator;

import green.detector.Detector;
import green.math.EventTime;

public class CoincidenceUtils {
	
	/** <b> This method is for demonstration purposes. </b> 
	 * For gathering information you should use the method provided in {@link WebUtils}
	 * @param detectors
	 * @param leastHit
	 * @param from The time to start looking for coincidences
	 * @param to The time to finish looking for detectors
	 * @deprecated - The work involved is much more than I anticipated when I started out, although I have planned out how to do it, 8 detectors over one hour would loop through 51 <i>million</i> strings - which is a lot
	 */
	@Deprecated
	public static void generateCoincidences(ArrayList<Detector> detectors, int leastHit, EventTime from, EventTime to){
		//Generate coincidences. Unnecessary but good code practice.
		
		//Load event data for the detectors
		ArrayList<ArrayList<String>> listList = new ArrayList<ArrayList<String>>();
		
		for(Detector detector : detectors){ 
			listList.add(WebUtils.downloadEventHistory(detector, from, to));
		}
		
		//Remove all the comments. We don't need them.
		for(ArrayList<String> k : listList){
			Iterator<String> it = k.iterator();
			while(it.hasNext()){
				String l = it.next();
				if(l.contains("#"))
					it.remove();
			}
		}
		
		//ArrayList<EventTime> times = new ArrayList<EventTime>();
		
		for(ArrayList<String> k1 : listList)
			System.out.println(k1.size());
		
		//List of String lists (containing events) 
		//for list... get info... get time
		//get time between each
		//if time < 2ms.... off we go
		
		
		
	}
	
	public static EventTime getTimeFromEvent(String event){
		String[] parts = event.split("\t");
		EventTime t = new EventTime();
		t.parse(parts[0]+"\t"+parts[1]+"\t"+parts[2]+"\t"+parts[3], EventTime.EVENT_FORMAT);
		return t;
	}
	/**
	 * Extension of {@link WebUtils} getCoincidences.
	 * @param detectors The detectors in the shower
	 * @param leastHit The minimum number of detectors to be hit to record the event
	 */
	public static void getCoincidences(ArrayList<Detector> detectors, int leastHit){
		//Download from HiSPARC
	}
	
	/** 
	 * Extension of {@link WebUtils} getCoincidence.
	 * @param cluster The cluster of detectors to look for coincidences in.
	 * @param leastHit The minimum number of hits to count as a shower.
	 * @return Nothing, as of yet
	 */
	public static void getCoincidences(String cluster, int leastHit){
		//Download from HiSPARC
	}
	
	/**
	 * http://data.hisparc.nl/data/network/coincidences/?end=2016-07-20+13%3A00%3A00&start=2016-07-20+12%3A00%3A00&stations=None&n=5&cluster=None&download=True
	 */
}
