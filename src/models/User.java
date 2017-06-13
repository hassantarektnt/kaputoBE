package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class User {
	private String email;
	private String name;
	private String password;
	private String phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User(String email, String name, String password, String phone) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public User() {

	}

	public static boolean checkUserAvailability(String email)
			throws SQLException {
		Connection conn = com.services.DBConnection.getActiveConnection();
		String sql = "Select * from user where `Mail` = ? ";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return true;
		}

		return false;
	}

	public static User addNewUser(String name, String email, String password,
			String phone) throws SQLException {

		if (checkUserAvailability(email)) {
			return null;
		}
		Connection conn = com.services.DBConnection.getActiveConnection();
		String sql = "insert into Kaputo.user (`Mail` , `Name`, `Password`,`Phone` ) VALUES( ? , ? , ? , ?) ;";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, email);
		stmt.setString(2, name);
		stmt.setString(3, password);
		stmt.setString(4, phone);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			System.out.println("TNT");
		}
		User user = new User(email, name, password, phone);

		return user;

	}

	public static User login(String email, String password) throws SQLException {

		Connection conn = com.services.DBConnection.getActiveConnection();
		String sql = "Select * from user where `Mail` = ? and `Password` = ?";
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			User user = new User();
			user.email = rs.getString("Mail");
			user.name = rs.getString("Name");
			user.password = rs.getString("Password");
			user.phone = rs.getString("Phone");
			
			return user;
		}
		return null;
	}

}
