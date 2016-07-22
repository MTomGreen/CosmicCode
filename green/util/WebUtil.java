package green.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WebUtil {
	
	public static URL url;
	public static URLConnection con;
	public static InputStream is;
	public static BufferedReader br;
	
	public static String getStationInfo(int stationID){
		String out = null;
		try{
			url = new URL (API.BASE_URL + "station/"+stationID);
			con = url.openConnection();
			is = con.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			out = br.readLine(); //There is only one line here because it is formatted as JSON.
		}
		
		catch(FileNotFoundException e){
			System.err.println("The station " + stationID + " is not valid!");
			System.out.println("Stacktrace:");
			e.printStackTrace();
		}
		
		catch(UnknownHostException e){
			System.err.println("That host could not be found");
			System.out.println("Please check your internet connection");
			System.out.println("If you are connected to the internet, the HiSPARC website may be down");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return out;
	}
	
	public static String getStationName(int stationID){
		JsonObject json = new JsonParser().parse(getStationInfo(stationID)).getAsJsonObject();
		return json.get("name").getAsString();
	}

}
