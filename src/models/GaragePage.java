package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class GaragePage extends Page {

	private String phone;

	public GaragePage(int pageId, String userMail, int regionId,
			double latitude, double longitude, String address, String phone) {
		super(pageId, userMail, regionId, latitude, longitude, address);
		this.phone = phone;
	}

	public GaragePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static GaragePage addNewGaragePage(String userMail, int regionId,
			double lat, double lon, String address, String phone)
			throws SQLException {

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();

		String sql = "insert into kaputo.GasStationPage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude`  , `PlacePhone`) values (? ,? , ? ,? , ? ,?);";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, phone);

		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			GaragePage garagePage = new GaragePage(pageId, userMail, regionId,
					lat, lon, address, phone);

			return garagePage;

		}
		return null;

	}

}