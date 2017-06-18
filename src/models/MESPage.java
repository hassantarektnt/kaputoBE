package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class MESPage extends Page {

	private String pageType;
	private String title;
	private String description;
	private String startTime;
	private String endTime;
	private String phone;

	public MESPage() {
	}

	public MESPage(int pageId, String userMail, int regionId, double latitude,
			double longitude, String address, String pageType, String title,
			String description, String startTime, String endTime, String phone) {
		super(pageId, userMail, regionId, latitude, longitude, address);
		this.pageType = pageType;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.phone = phone;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static MESPage addNewMechanicPage(String userMail, int regionId,
			String title, double lat, double lon, String address,
			String description, String startTime, String endTime, String phone)
			throws SQLException {

		String pageType = "Mechanic";

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();

		String sql = "insert into kaputo.MESpage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title`,`PageType` , `Description` ,`StartTime`,`EndTime`,`Phone`  ) values (?  ,? ,? , ? ,? , ? ,?  ,? ,? , ? ,? );";

		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, pageType);
		stmt.setString(8, description);
		stmt.setString(9, startTime);
		stmt.setString(10, endTime);
		stmt.setString(11, phone);

		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			MESPage mesPage = new MESPage(pageId, userMail, regionId, lat, lon,
					address, pageType, title, description, startTime, endTime,
					phone);

			return mesPage;

		}
		return null;

	}

	public static MESPage addNewElectricianPage(String userMail, int regionId,
			String title, double lat, double lon, String address,
			String description, String startTime, String endTime, String phone)
			throws SQLException {

		String pageType = "Electrician";

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();

		String sql = "insert into kaputo.MESpage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title`,`PageType` , `Description` ,`StartTime`,`EndTime`,`Phone`  ) values (?  ,? ,? , ? ,? , ? ,?  ,? ,? , ? ,? );";

		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, pageType);
		stmt.setString(8, description);
		stmt.setString(9, startTime);
		stmt.setString(10, endTime);
		stmt.setString(11, phone);

		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			MESPage mesPage = new MESPage(pageId, userMail, regionId, lat, lon,
					address, pageType, title, description, startTime, endTime,
					phone);

			return mesPage;

		}
		return null;

	}

	public static MESPage addNewSparePartsPage(String userMail, int regionId,
			String title, double lat, double lon, String address,
			String description, String startTime, String endTime, String phone)
			throws SQLException {

		String pageType = "SpareParts";

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();

		String sql = "insert into kaputo.MESpage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title`,`PageType` , `Description` ,`StartTime`,`EndTime`,`Phone`  ) values (?  ,? ,? , ? ,? , ? ,?  ,? ,? , ? ,? );";

		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, pageType);
		stmt.setString(8, description);
		stmt.setString(9, startTime);
		stmt.setString(10, endTime);
		stmt.setString(11, phone);

		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			MESPage mesPage = new MESPage(pageId, userMail, regionId, lat, lon,
					address, pageType, title, description, startTime, endTime,
					phone);

			return mesPage;

		}
		return null;

	}

}