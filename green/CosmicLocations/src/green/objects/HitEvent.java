package green.objects;

public class HitEvent {
	
	public String date;
	public int id;
	public int detectorID;
	public String time;
	public double unixTime;
	public double nanosAfter;
	public double[] pulseHeights = new double[4];
	public double[] integrals = new double[4];
	public double[] mips = new double[4];
	public double[] arrivalTimes = new double[4];
	public double triggerTime;
	
	public HitEvent(String rawData){
		String[] parts = rawData.split("\t");
		id = Integer.parseInt(parts[0]);
		detectorID = Integer.parseInt(parts[1]);
		date = parts[2];
		time = parts[3];
		unixTime = Double.parseDouble(parts[4]);
		nanosAfter = Double.parseDouble(parts[5]);
		
		pulseHeights[0] = Double.parseDouble(parts[6]);
		pulseHeights[1] = Double.parseDouble(parts[7]);
		pulseHeights[2] = Double.parseDouble(parts[8]);
		pulseHeights[3] = Double.parseDouble(parts[9]);
		
		integrals[0] = Double.parseDouble(parts[10]);
		integrals[1] = Double.parseDouble(parts[11]);
		integrals[2] = Double.parseDouble(parts[12]);
		integrals[3] = Double.parseDouble(parts[13]);
		
		mips[0] = Double.parseDouble(parts[14]);
		mips[1] = Double.parseDouble(parts[15]);
		mips[2] = Double.parseDouble(parts[16]);
		mips[3] = Double.parseDouble(parts[17]);
		
		arrivalTimes[0] = Double.parseDouble(parts[18]);
		arrivalTimes[1] = Double.parseDouble(parts[19]);
		arrivalTimes[2] = Double.parseDouble(parts[20]);
		arrivalTimes[3] = Double.parseDouble(parts[21]);
		
		triggerTime = Double.parseDouble(parts[22]);
		
	}
}
