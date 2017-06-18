package models;

import java.util.ArrayList;

public class Advertise {

	private int advertiseId;
	private int pageId;
	private double price;
	private int adTitle;
	private String adDescription;
	private String adDate;
	private String phone;
	private ArrayList<String> imageLink;

	public Advertise(int advertiseId, int pageId, double price, int adTitle,
			String adDescription, String adDate, String phone,
			ArrayList<String> imageLink) {
		this.advertiseId = advertiseId;
		this.pageId = pageId;
		this.price = price;
		this.adTitle = adTitle;
		this.adDescription = adDescription;
		this.adDate = adDate;
		this.phone = phone;
		this.imageLink = imageLink;
	}

	public Advertise() {
	}

	public int getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(int advertiseId) {
		this.advertiseId = advertiseId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(int adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdDescription() {
		return adDescription;
	}

	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
	}

	public String getAdDate() {
		return adDate;
	}

	public void setAdDate(String adDate) {
		this.adDate = adDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public ArrayList<String> getImageLink() {
		return imageLink;
	}

	public void setImageLink(ArrayList<String> imageLink) {
		this.imageLink = imageLink;
	}

}