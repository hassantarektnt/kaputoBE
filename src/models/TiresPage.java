package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class TiresPage extends Page {

	private String title;
	private String description;
	private String startTime;
	private String endTime;
	private String phone;

	public TiresPage(int pageId, String userMail, int regionId,
			double latitude, double longitude, String address, String title,
			String description, String startTime, String endTime, String phone) {
		super(pageId, userMail, regionId, latitude, longitude, address);
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.phone = phone;
	}

	public TiresPage() {
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

	public static TiresPage addNewTiresPage(String userMail, int regionId,
			String title, double lat, double lon, String address,
			String description, String startTime, String endTime, String phone)
			throws SQLException {

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();

		String sql = "insert into kaputo.TiresPage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title` , `Description` ,`StartTime`,`EndTime`,`Phone`  ) values (?  ,? ,? , ? ,? , ?  ,? ,? , ? ,? );";

		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.setString(7, description);
		stmt.setString(8, startTime);
		stmt.setString(9, endTime);
		stmt.setString(10, phone);

		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			TiresPage tiresPage = new TiresPage(pageId, userMail, regionId,
					lat, lon, address, title, description, startTime, endTime,
					phone);

			return tiresPage;

		}
		return null;

	}

}