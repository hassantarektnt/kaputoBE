package com.services;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import models.User;

import org.json.simple.JSONObject;

@Path("/")
public class Services {

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

	@GET
	@Path("/ila")
	@Produces(MediaType.TEXT_PLAIN)
	public String ila() {
		return "Hello  World";
	}

}
