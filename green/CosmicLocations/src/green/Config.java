package green;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import green.util.FileUtils;

public class Config {

	public static JsonObject properties = new JsonObject();
	public static File configDir = new File(FileUtils.base_dir + "/config/");
	public static File configFile = new File(FileUtils.base_dir+"/config/config.cfg");

	public static void save() {
		if(!configDir.exists()) configDir.mkdirs();
		try {
			FileWriter writer = new FileWriter(configFile);
			writer.write(properties.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void load() {
		if(!configDir.exists()) configDir.mkdirs();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(configFile));
			JsonParser parser = new JsonParser();
			String json = reader.readLine();
			properties.add("all", parser.parse(json));
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void put(String key, String value){
		properties.addProperty(key, value);
	}
	
	public static String get(String key){
		return properties.get(key).getAsString();
	}
	
	

}
