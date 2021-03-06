package green.math;

public class EventTime {
	
	private String date;
	private String timeC;
	private double unixTime;
	private double nanosAfter;
	
	/** The format for downloading events
	 * 2016-07-20+00:00:00
	 * Year-Month-Day+Hour:Minute:Second 
	 */
	public static final int DOWNLOAD_FORMAT = 1;
	
	/**
	 * see {@link EventTime.EVENT_FORMAT}
	 */
	public static final int FULL_FORMAT = 2;
	
	/** The format that event files come with
	 * 2016-07-20 12:00:00 0000 0000
	 * Year-Month-Day#Hour-Minute-Second#Unix#Nanoseconds 
	 */
	public static final int EVENT_FORMAT = 2;
	
	public void parse(String time, int format){
		switch(format){
		case EVENT_FORMAT:
			//2016-07-20 12:00:00 0000 0000 
			String[] parts = time.split("\t");
			date = parts[0];
			timeC = parts[1];
			unixTime = Double.parseDouble(parts[2]);
			nanosAfter = Double.parseDouble(parts[2]);
			break;
		case DOWNLOAD_FORMAT:
			//2016-07-20+00:00:00
			String[] parts2 = time.split("\\+");
			date = parts2[0];
			timeC = parts2[1];
		}
	}
	
	public String getFor(int format){
		switch(format){
		case EVENT_FORMAT: //2016-07-20+00:00:00
			return date+"+"+timeC;
		
		case DOWNLOAD_FORMAT:  //2016-07-20+00:00:00
			return date+"+"+timeC;
		}
		
		return null;
	}
	
	//Format:
	//2016-07-20 12:00:00 0000000000 0000000000
	
	//Formats:
	
	//DownloadFormat
	//YYYY-MM-DD+HH:MM:SS
	//2016-07-25+00:00:00
	
	//FullFormat
	//YYYY-MM-DD+HH:MM:SS+000000000+0000000000
	

	public String getDate() {
		return date;
	}
	
	/** Format: YYYY-MM-DD */
	public void setDate(String date) {
		this.date = date;
	}

	public double getUnixTime() {
		return unixTime;
	}

	public void setUnixTime(double unixTime) {
		this.unixTime = unixTime;
	}

	public double getNanosAfter() {
		return nanosAfter;
	}
	
	public void setNanosAfter(double nanosAfter) {
		this.nanosAfter = nanosAfter;
	}
	
	public String getTime(){
		return timeC;
	}
	
	/** Format: HH:MM:SS */
	public void setTime(String time){
		timeC = time;
	}
	
	
}
