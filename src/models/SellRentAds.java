package models;

import java.util.ArrayList;

public class SellRentAds extends Advertise {

	private String advetiseType;
	private String carModel;
	private String transmissionType;
	private int carYear;
	private String kilometers;
	private int maxDaysRent;

	public SellRentAds(int advertiseId, int pageId, double price, int adTitle,
			String adDescription, String adDate, String phone,
			ArrayList<String> imageLink, String advetiseType, String carModel,
			String transmissionType, int carYear, String kilometers,
			int maxDaysRent) {
		super(advertiseId, pageId, price, adTitle, adDescription, adDate,
				phone, imageLink);
		this.advetiseType = advetiseType;
		this.carModel = carModel;
		this.transmissionType = transmissionType;
		this.carYear = carYear;
		this.kilometers = kilometers;
		this.maxDaysRent = maxDaysRent;
	}

	public SellRentAds() {

	}

	public String getAdvetiseType() {
		return advetiseType;
	}

	public void setAdvetiseType(String advetiseType) {
		this.advetiseType = advetiseType;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getKilometers() {
		return kilometers;
	}

	public void setKilometers(String kilometers) {
		this.kilometers = kilometers;
	}

	public int getMaxDaysRent() {
		return maxDaysRent;
	}

	public void setMaxDaysRent(int maxDaysRent) {
		this.maxDaysRent = maxDaysRent;
	}

}