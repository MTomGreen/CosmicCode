package green.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtils {
	
	public static String getDateInfo(){
		String returns = null;
		Calendar c = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("EEEEE");
		returns = dateFormat.format(c.getTime());
		int day = Calendar.DAY_OF_MONTH;
		dateFormat = new SimpleDateFormat("MMMMMMM");
		String month = dateFormat.format(c.getTime());
		String suffix = day == 1 ? "st" : (day == 3 || day == 2) ? "nd" : "th";
		dateFormat = new SimpleDateFormat("YYYY");
		String year = dateFormat.format(c.getTime());
		returns = returns + ", " + day + suffix + " of " + month + " " + year;
		
		return returns;
	}
	
	public static String getTimeInfo(){
		Calendar c = Calendar.getInstance();
		DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		return timeFormat.format(c.getTime());
	}

}
