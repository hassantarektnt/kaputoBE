package com.services;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.AccessoryPage;
import models.BodyTechPage;
import models.GaragePage;
import models.GasStationPage;
import models.MESPage;
import models.SellRentPage;
import models.TiresPage;
import models.User;

import org.json.simple.JSONObject;

@Path("/")
public class Services {
	@GET
	@Path("/ila")
	@Produces(MediaType.TEXT_PLAIN)
	public String ila() {
		return "Hello  World";
	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/signup")
	@Produces(MediaType.TEXT_PLAIN)
	public String SignUp(@FormParam("email") String email,
			@FormParam("name") String name,
			@FormParam("password") String password,
			@FormParam("phone") String phone) throws SQLException {
		User user = User.addNewUser(name, email, password, phone);

		JSONObject json = new JSONObject();

		if (user != null) {

			json.put("name", user.getName());
			json.put("email", user.getEmail());
			json.put("password", user.getPassword());
			json.put("phone", user.getPhone());
			json.put("operation", "success");
		} else {
			json.put("operation", "failed");
		}

		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String login(@FormParam("email") String email,
			@FormParam("password") String pass) throws SQLException {

		User user = User.login(email, pass);

		JSONObject json = new JSONObject();

		if (user != null) {
			json.put("name", user.getName());
			json.put("email", user.getEmail());
			json.put("phoneNumber", user.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/updateuserinformation")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUserInformation(@FormParam("email") String email,
			@FormParam("name") String name,
			@FormParam("password") String password,
			@FormParam("phone") String phone) throws SQLException {
		User user = User.updateUserInfo(email, name, password, phone);
		JSONObject json = new JSONObject();

		if (user != null) {

			json.put("name", user.getName());
			json.put("email", user.getEmail());
			json.put("password", user.getPassword());
			json.put("phone", user.getPhone());
			json.put("operation", "success");
		} else {
			json.put("operation", "failed");
		}

		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addsellpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddSellPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address)
			throws SQLException {
		SellRentPage sellRentPage = SellRentPage.addNewSellPage(email,
				regionId, title, lat, lon, address);

		JSONObject json = new JSONObject();

		if (sellRentPage != null) {
			json.put("pageID", sellRentPage.getPageId());
			json.put("userMail", sellRentPage.getUserMail());
			json.put("regionId", sellRentPage.getRegionId());
			json.put("lat", sellRentPage.getLatitude());
			json.put("lon", sellRentPage.getLongitude());
			json.put("address", sellRentPage.getAddress());
			json.put("pageType", sellRentPage.getPageType());
			json.put("title", sellRentPage.getTitle());
			json.put("operation", "success");
		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addrentpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddRentPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address)
			throws SQLException {
		SellRentPage sellRentPage = SellRentPage.addNewRentPage(email,
				regionId, title, lat, lon, address);

		JSONObject json = new JSONObject();

		if (sellRentPage != null) {
			json.put("pageID", sellRentPage.getPageId());
			json.put("userMail", sellRentPage.getUserMail());
			json.put("regionId", sellRentPage.getRegionId());
			json.put("lat", sellRentPage.getLatitude());
			json.put("lon", sellRentPage.getLongitude());
			json.put("address", sellRentPage.getAddress());
			json.put("pageType", sellRentPage.getPageType());
			json.put("title", sellRentPage.getTitle());
			json.put("operation", "success");
		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addaccessorypage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddAccessoryPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address)
			throws SQLException {

		AccessoryPage accessoryPage = AccessoryPage.addNewAccessoryPage(email,
				regionId, title, lat, lon, address);

		JSONObject json = new JSONObject();

		if (accessoryPage != null) {
			json.put("pageID", accessoryPage.getPageId());
			json.put("userMail", accessoryPage.getUserMail());
			json.put("regionId", accessoryPage.getRegionId());
			json.put("lat", accessoryPage.getLatitude());
			json.put("lon", accessoryPage.getLongitude());
			json.put("address", accessoryPage.getAddress());
			json.put("title", accessoryPage.getTitle());
			json.put("operation", "success");
		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addmechanicpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddMechanicPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("description") String description,
			@FormParam("startTime") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("phone") String phone) throws SQLException {

		MESPage mesPage = MESPage.addNewMechanicPage(email, regionId, title,
				lat, lon, address, description, startTime, endTime, phone);

		JSONObject json = new JSONObject();

		if (mesPage != null) {
			json.put("pageID", mesPage.getPageId());
			json.put("userMail", mesPage.getUserMail());
			json.put("regionId", mesPage.getRegionId());
			json.put("lat", mesPage.getLatitude());
			json.put("lon", mesPage.getLongitude());
			json.put("address", mesPage.getAddress());
			json.put("title", mesPage.getTitle());
			json.put("pageType", mesPage.getPageType());
			json.put("description", mesPage.getDescription());
			json.put("startTime", mesPage.getStartTime());
			json.put("endTime", mesPage.getEndTime());
			json.put("phone", mesPage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addelectricianpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddElectricianPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("description") String description,
			@FormParam("startTime") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("phone") String phone) throws SQLException {

		MESPage mesPage = MESPage.addNewElectricianPage(email, regionId, title,
				lat, lon, address, description, startTime, endTime, phone);

		JSONObject json = new JSONObject();

		if (mesPage != null) {
			json.put("pageID", mesPage.getPageId());
			json.put("userMail", mesPage.getUserMail());
			json.put("regionId", mesPage.getRegionId());
			json.put("lat", mesPage.getLatitude());
			json.put("lon", mesPage.getLongitude());
			json.put("address", mesPage.getAddress());
			json.put("title", mesPage.getTitle());
			json.put("pageType", mesPage.getPageType());
			json.put("description", mesPage.getDescription());
			json.put("startTime", mesPage.getStartTime());
			json.put("endTime", mesPage.getEndTime());
			json.put("phone", mesPage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addsparepartspage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddSparePartsPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("description") String description,
			@FormParam("startTime") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("phone") String phone) throws SQLException {

		MESPage mesPage = MESPage.addNewSparePartsPage(email, regionId, title,
				lat, lon, address, description, startTime, endTime, phone);

		JSONObject json = new JSONObject();

		if (mesPage != null) {
			json.put("pageID", mesPage.getPageId());
			json.put("userMail", mesPage.getUserMail());
			json.put("regionId", mesPage.getRegionId());
			json.put("lat", mesPage.getLatitude());
			json.put("lon", mesPage.getLongitude());
			json.put("address", mesPage.getAddress());
			json.put("title", mesPage.getTitle());
			json.put("pageType", mesPage.getPageType());
			json.put("description", mesPage.getDescription());
			json.put("startTime", mesPage.getStartTime());
			json.put("endTime", mesPage.getEndTime());
			json.put("phone", mesPage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addbodytechpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddBodyTechPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("description") String description,
			@FormParam("startTime") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("phone") String phone) throws SQLException {

		BodyTechPage bodyTechPage = BodyTechPage.addNewBodyTechPage(email,
				regionId, title, lat, lon, address, description, startTime,
				endTime, phone);

		JSONObject json = new JSONObject();

		if (bodyTechPage != null) {
			json.put("pageID", bodyTechPage.getPageId());
			json.put("userMail", bodyTechPage.getUserMail());
			json.put("regionId", bodyTechPage.getRegionId());
			json.put("lat", bodyTechPage.getLatitude());
			json.put("lon", bodyTechPage.getLongitude());
			json.put("address", bodyTechPage.getAddress());
			json.put("title", bodyTechPage.getTitle());
			json.put("description", bodyTechPage.getDescription());
			json.put("startTime", bodyTechPage.getStartTime());
			json.put("endTime", bodyTechPage.getEndTime());
			json.put("phone", bodyTechPage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addtirespage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddTiresPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId,
			@FormParam("title") String title, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("description") String description,
			@FormParam("startTime") String startTime,
			@FormParam("endTime") String endTime,
			@FormParam("phone") String phone) throws SQLException {

		TiresPage tiresPage = TiresPage.addNewTiresPage(email, regionId, title,
				lat, lon, address, description, startTime, endTime, phone);

		JSONObject json = new JSONObject();

		if (tiresPage != null) {
			json.put("pageID", tiresPage.getPageId());
			json.put("userMail", tiresPage.getUserMail());
			json.put("regionId", tiresPage.getRegionId());
			json.put("lat", tiresPage.getLatitude());
			json.put("lon", tiresPage.getLongitude());
			json.put("address", tiresPage.getAddress());
			json.put("title", tiresPage.getTitle());
			json.put("description", tiresPage.getDescription());
			json.put("startTime", tiresPage.getStartTime());
			json.put("endTime", tiresPage.getEndTime());
			json.put("phone", tiresPage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addgasstationpage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddGasStationPage(@FormParam("email") String email,
			@FormParam("regionId") int regionId, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("name") String name, @FormParam("phone") String phone)
			throws SQLException {

		GasStationPage gasStationPage = GasStationPage.addNewGasStationPage(
				email, regionId, lat, lon, address, name, phone);

		JSONObject json = new JSONObject();

		if (gasStationPage != null) {
			json.put("pageID", gasStationPage.getPageId());
			json.put("userMail", gasStationPage.getUserMail());
			json.put("regionId", gasStationPage.getRegionId());
			json.put("lat", gasStationPage.getLatitude());
			json.put("lon", gasStationPage.getLongitude());
			json.put("address", gasStationPage.getAddress());
			json.put("phone", gasStationPage.getPhone());
			json.put("name", gasStationPage.getName());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

	@SuppressWarnings("unchecked")
	@POST
	@Path("/addgaragepage")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddGaragePage(@FormParam("email") String email,
			@FormParam("regionId") int regionId, @FormParam("lat") double lat,
			@FormParam("lon") double lon, @FormParam("address") String address,
			@FormParam("phone") String phone) throws SQLException {

		GaragePage garagePage = GaragePage.addNewGaragePage(email, regionId,
				lat, lon, address, phone);

		JSONObject json = new JSONObject();

		if (garagePage != null) {
			json.put("pageID", garagePage.getPageId());
			json.put("userMail", garagePage.getUserMail());
			json.put("regionId", garagePage.getRegionId());
			json.put("lat", garagePage.getLatitude());
			json.put("lon", garagePage.getLongitude());
			json.put("address", garagePage.getAddress());
			json.put("phone", garagePage.getPhone());
			json.put("operation", "success");

		} else {
			json.put("operation", "failed");
		}
		return json.toString();

	}

}
