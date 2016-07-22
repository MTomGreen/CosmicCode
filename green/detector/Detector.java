package green.detector;

import green.util.ClusterUtils;

public class Detector {

	private int stationID;
	private String name;
	private EnumCluster Cluster;
	private double latitude;
	private double longitude;
	private StationInfo info;

	public Detector(int ID) {
		this.stationID = ID;
	}
	
	public void populateData(){
		if(stationID == 0) System.err.println("The station ID is 0! No data can be collected. Did you forget to specify an ID?");
		info = new StationInfo(stationID);
		name = info.getName();
		Cluster = ClusterUtils.parseCluster(info.getCluster());
		latitude = info.getLatitude();
		longitude = info.getLongitude();
	}

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int ID) {
		this.stationID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumCluster getCluster() {
		return Cluster;
	}

	public void setCluster(EnumCluster cluster) {
		Cluster = cluster;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitudeInRadians() {
		return Math.toRadians(latitude);
	}

	public double getLongitudeInRadians() {
		return Math.toRadians(longitude);
	}
	

	

}
