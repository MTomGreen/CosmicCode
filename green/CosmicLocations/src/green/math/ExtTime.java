package green.math;

public class ExtTime {
	
	//2016-07-25+00:00:00
	
	public int year;
	public int month;
	public int day;
	
	public int hours;
	public int minutes;
	public int seconds;
	public double nanos;
	
	public static int WEB_FORMAT = 1;
	
	public String format(int format){
		switch(format){
		case 1:
			// Example: 2016-07-35+03:23:43
			return year+"-"+noFormat(month)+"-"+noFormat(day)+"+"+noFormat(hours)+":"+noFormat(minutes)+":"+noFormat(seconds);
		}
		return null;
	}
	
	public ExtTime(){
		
	}
	
	public ExtTime(int year, int month, int day, int hours, int minutes, int seconds){
		this.year = year;
		this.month = month;
		this.day = day;
		
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	/** 
	 * 
	 * @param time In format YYYY:MM:DD+HH-MM-SS
	 */
	public ExtTime(String time){
		String date = time.split("\\+")[0];
		String ttime = time.split("\\+")[1];
		String[] dateBits = date.split("-");
		year = Integer.parseInt(dateBits[0]);
		month = Integer.parseInt(dateBits[1]);
		day = Integer.parseInt(dateBits[2]);
		String[] timeBits = ttime.split("-");
		hours = Integer.parseInt(timeBits[0]);
		minutes = Integer.parseInt(timeBits[1]);
		seconds = Integer.parseInt(timeBits[2]);
	}
	
	public static ExtTime parse(String time){
		return new ExtTime(time);
	}
	

	
	
	String noFormat(int number){
		if(number < 10)
			return "0"+number;
		else
			return ""+number;
	}
	


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public void setHours(int hours) {
		this.hours = hours;
	}


	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}


	public int getMonth() {
		return month;
	}


	public int getDay() {
		return day;
	}


	public int getHours() {
		return hours;
	}


	public int getMinutes() {
		return minutes;
	}


	public int getSeconds() {
		return seconds;
	}

	public double getNanos() {
		return nanos;
	}

	public void setNanos(double nanos) {
		this.nanos = nanos;
	}
	
	
	
	
}
