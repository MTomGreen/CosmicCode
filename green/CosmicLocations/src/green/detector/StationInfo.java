package green.detector;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import green.util.WebUtils;

public class StationInfo {
	
	private boolean active;
	private double altitude;
	private String cluster;
	private String country;
	private double longitude;
	private double latitude;
	private String name; //Some BS right here
	private int number;
	private String subCluster;
	
	public void updateStationInfo(){
		try{
		JsonObject json = new JsonParser().parse(WebUtils.getStationInfo(this.number)).getAsJsonObject();
		active = json.get("active").getAsBoolean();
		altitude = json.get("altitude").getAsDouble();
		cluster = json.get("cluster").getAsString();
		country = json.get("country").getAsString();
		latitude = json.get("latitude").getAsDouble();
		longitude = json.get("longitude").getAsDouble();
		name = json.get("name").getAsString();
		number = json.get("number").getAsInt();
		subCluster = json.get("subcluster").getAsString();
		}
		catch(Exception e){
			System.err.println("The station " + number + " has invalid data!");
		}
		
		//Correcting for HiSPARCs errors:
		if(number == 14001) name = "Marling";
	}
	
	
	public StationInfo(int id) {
		this.number = id;
		updateStationInfo();
	}
	
	public StationInfo() {
		updateStationInfo();
	}


	/**
	 * @return whether this station is active.
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	/**
	 * @return the altitude
	 */
	public double getAltitude() {
		return altitude;
	}


	/**
	 * @param altitude the altitude to set
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}


	/**
	 * @return the cluster
	 */
	public String getCluster() {
		return cluster;
	}


	/**
	 * @param cluster the cluster to set
	 */
	public void setCluster(String cluster) {
		this.cluster = cluster;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	/**
	 * @return the subCluster
	 */
	public String getSubCluster() {
		return subCluster;
	}


	/**
	 * @param subCluster the subCluster to set
	 */
	public void setSubCluster(String subCluster) {
		this.subCluster = subCluster;
	}

	
	
}
