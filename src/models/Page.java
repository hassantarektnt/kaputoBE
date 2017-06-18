package models;

public class Page {
	private int pageId;
	private String userMail;
	private int regionId;
	private double latitude;
	private double longitude;
	private String address;

	public Page() {
	}

	public Page(int pageId, String userMail, int regionId, double latitude,
			double longitude, String address) {
		super();
		this.pageId = pageId;
		this.userMail = userMail;
		this.regionId = regionId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
