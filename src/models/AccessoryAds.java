package models;

import java.util.ArrayList;

public class AccessoryAds extends Advertise {

	private ArrayList<Integer> versionId;

	public AccessoryAds(int advertiseId, int pageId, double price, int adTitle,
			String adDescription, String adDate, String phone,
			ArrayList<String> imageLink, ArrayList<Integer> versionId) {
		super(advertiseId, pageId, price, adTitle, adDescription, adDate,
				phone, imageLink);
		this.versionId = versionId;
	}

	public ArrayList<Integer> getVersionId() {
		return versionId;
	}

	public void setVersionId(ArrayList<Integer> versionId) {
		this.versionId = versionId;
	}

}