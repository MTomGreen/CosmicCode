package green.objects;

import java.util.ArrayList;

public class Coincidence {
	
	public int coincidenceID;
	
	public ArrayList<HitEvent> events = new ArrayList<HitEvent>();
	
	public Coincidence(){
		
	}
	
	public Coincidence(int id){
		this.coincidenceID = id;
	}
	
	public ArrayList<Integer> getInvolvedDetectors(){
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for(HitEvent e : events){
			if(!(ints.contains(e.detectorID))){
				ints.add(e.detectorID);
			}
		}
		
		return ints;
	}

}
