package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class AccessoryPage extends Page {

	private String title;
	private ArrayList<AccessoryAds> advertisements;

	public AccessoryPage(int pageId, String userMail, int regionId,
			double latitude, double longitude, String address, String title,
			ArrayList<AccessoryAds> advertisements) {
		super(pageId, userMail, regionId, latitude, longitude, address);

		this.title = title;
		this.advertisements = advertisements;
	}

	public AccessoryPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<AccessoryAds> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(ArrayList<AccessoryAds> advertisements) {
		this.advertisements = advertisements;
	}

	public static AccessoryPage addNewAccessoryPage(String userMail,
			int regionId, String title, double lat, double lon, String address)
			throws SQLException {

		if (!User.checkUserAvailability(userMail)) {

			System.out.println("user not found");

			return null;
		}

		Connection conn = com.services.DBConnection.getActiveConnection();
		// insert into kaputo.AccessoryPage (`UserMail` , `RegionRegionID` ,
		// `Address` , `Latitude` ,`Longitude` , `Title` ) values ("has" , 1
		// ,"adasdadsa" ,1.222 , 1.3132 ,"asdsa" );

		String sql = "insert into kaputo.AccessoryPage (`UserMail` , `RegionRegionID` , `Address` , `Latitude` ,`Longitude` , `Title`  ) values (?  ,? ,? , ? ,? , ? );";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, userMail);
		stmt.setInt(2, regionId);
		stmt.setString(3, address);
		stmt.setDouble(4, lat);
		stmt.setDouble(5, lon);
		stmt.setString(6, title);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			int pageId = rs.getInt(1);
			AccessoryPage accessoryPage = new AccessoryPage(pageId, userMail,
					regionId, lat, lon, address, title, null);

			return accessoryPage;

		}
		return null;

	}

}