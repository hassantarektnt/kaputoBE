package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class SellRentPage extends Page {
	private String pageType;
	private String title;
	private ArrayList<SellRentAds> advertisements;

	public SellRentPage() {
		super();
	}

	public SellRentPage(int pageId, String userMail, int regionId,
			double latitude, double longitude, String address, String pageType,
			String title, ArrayList<SellRentAds> advertisements) {
		super(pageId, userMail, regionId, latitude, longitude, address);
		this.pageType = pageType;
		this.title = title;
		this.advertisements = advertisements;
	}

	public ArrayList<SellRentAds> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(ArrayList<SellRentAds> advertisements) {
		this.advertisements = advertisements;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static SellRentPage addNewSellPage(String userMail, int regionId,
			String title, double lat, double lon, String address)
			throws SQLException {

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		String pageType = "Sell";
		Connection conn = com.services.DBConnection.getActiveConnection();
		String sql = "insert into kaputo.SellRentPage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title` , `PageType` ) values (? , ? ,? ,? , ? ,? , ? );";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, pageType);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			SellRentPage sellRentPage = new SellRentPage(pageId, userMail,
					regionId, lat, lon, address, pageType, title, null);
			return sellRentPage;

		}
		return null;

	}

	public static SellRentPage addNewRentPage(String userMail, int regionId,
			String title, double lat, double lon, String address)
			throws SQLException {

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		String pageType = "Rent";
		Connection conn = com.services.DBConnection.getActiveConnection();
		String sql = "insert into kaputo.SellRentPage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title` , `PageType` ) values (? , ? ,? ,? , ? ,? , ? );";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, pageType);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			SellRentPage sellRentPage = new SellRentPage(pageId, userMail,
					regionId, lat, lon, address, pageType, title, null);
			return sellRentPage;

		}
		return null;

	}

}
