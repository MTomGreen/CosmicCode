package green.util;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import green.detector.Detector;

public class WebUtils {

	public static URL url;
	public static URLConnection con;
	public static InputStream is;
	public static BufferedReader br;
	
	public static boolean downloaded = false;
	public static String newFileName = "-";

	public static String getStationInfo(int stationID) {
		String out = null;
		try {
			out = getReaderForURL(API.BASE_URL + "station/" + stationID).readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return out;
	}

	public static String getStationName(int stationID) {
		JsonObject json = new JsonParser().parse(getStationInfo(stationID)).getAsJsonObject();
		return json.get("name").getAsString();
	}

	public static String getStations() {
		return null;
	}

	public static BufferedReader getReaderForURL(String urlText) {
		URL url;
		try {
			url = new URL(urlText);
			con = url.openConnection();
			is = con.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
		} catch (FileNotFoundException e) {
			System.err.println("The URL specifed is invlaid!");
			System.out.println("Stacktrace:");
			e.printStackTrace();
		}

		catch (UnknownHostException e) {
			System.err.println("That host could not be found");
			System.out.println("Please check your internet connection");
			System.out.println("If you are connected to the internet, the HiSPARC website may be down");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br;
	}

	public static void getLocation() {
		Point p = new Point().getLocation();
		System.out.println(p.getLocation());
	}
	
	@Deprecated
	public static void downloadEventLogLegacy(Detector d, String from, String to) {
		from = "2016-07-12 12:00";
		to = "2016-07-12 13:00";
		File saveTo = new File(FileUtils.base_dir + "/data/temp");
		if (!saveTo.exists())
			saveTo.mkdirs();

		String downloadFilepath = saveTo.getAbsolutePath();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.file_name", "test.txt");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty("webdriver.ie.driver", FileUtils.base_dir + "/lib/IEDriverServer.exe");
		System.setProperty("webdriver.chrome.driver", FileUtils.base_dir + "/lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver(cap);
		driver.get("http://data.hisparc.nl/data/download/");

		WebElement stationList = driver.findElement(By.id("id_station_events"));
		WebElement startField = driver.findElement(By.id("id_start"));
		WebElement endField = driver.findElement(By.id("id_end"));
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		WebElement submitButton = inputs.get(inputs.size() - 1);

		startField.click();
		startField.sendKeys(from);

		endField.click();
		endField.sendKeys(to);

		String all_values = stationList.getText();
		ArrayList<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList(all_values.split("\n")));
		values.remove(0);

		int numberOfLinesUp = 0;
		int id = d.getStationID();

		for (String s : values) {
			String b = s.split(": ")[0].replaceAll(" ", "");
			if (Integer.parseInt(b) == id)
				numberOfLinesUp = values.indexOf(s);
		}

		stationList.click();
		for (int i = 0; i < numberOfLinesUp + 1; i++) {
			stationList.sendKeys(Keys.ARROW_DOWN);
		}
		stationList.sendKeys(Keys.ENTER);

		submitButton.click();


		while(!downloaded){
			File[] filesInDir = saveTo.listFiles();
			for(File f : filesInDir){
				if(f.getName().contains(".tsv") && !f.getName().contains("crdownload")){
					downloaded = true;
				}
			}
		}
		driver.close();
		driver.quit();
		
		newFileName = "station-"+id;
		FileUtils.moveFilesFromDownloads();
	}
	
	public static void downloadEventHistory(Detector d, String startTime, String endTime){
		BufferedReader br = WebUtils.getReaderForURL("http://data.hisparc.nl/data/14004/events/?Download=False&start=2016-07-25+00:00:00&end=2016-07-26+00:00:00");
	}

}