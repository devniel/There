package controllers;

import models.User;
import utils.HttpPost;

public class Users {
	
	public static void create(User user) {

		StringBuilder parameters = new StringBuilder();
		parameters.append("username=" + user.username);
		parameters.append("&password=" + user.password);
		parameters.append("&email=" + user.email);
		parameters.append("&firstname=" + user.email);
		
		(new HttpPost()).execute("http://192.168.1.38:3000/users/create",parameters.toString());

	}

}
