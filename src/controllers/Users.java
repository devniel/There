package controllers;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import models.User;
import utils.GetJSONListener;
import utils.HttpPost;

public class Users {
	
	public static Context ctx;

	public static void create(User user) {

		StringBuilder parameters = new StringBuilder();
		parameters.append("username=" + user.username);
		parameters.append("&password=" + user.password);
		parameters.append("&email=" + user.email);
		parameters.append("&firstname=" + user.email);
		
		HttpPost hp = new HttpPost(null, new GetJSONListener() {
			
			public void onRemoteCallComplete(JSONObject jsonFromNet) {
				Log.d("JSON : " , jsonFromNet.toString());
				Toast.makeText(ctx, jsonFromNet.toString(), 2000).show();
			}
		});
		
		hp.execute("http://192.168.1.38:3000/users/create",parameters.toString());
		
		//Log.d("RESPONSE", response);

	}
	
	public static void findById(Long id) {

		StringBuilder parameters = new StringBuilder();
		parameters.append("id=" + id);
		
		HttpPost hp = new HttpPost(null, new GetJSONListener() {
			public void onRemoteCallComplete(JSONObject jsonFromNet) {
				Log.d("JSON : " , jsonFromNet.toString());
				Toast.makeText(ctx, jsonFromNet.toString(), 2000).show();
			}
		});
		
		hp.execute("http://192.168.1.38:3000/users/" + id,parameters.toString());
		//Log.d("RESPONSE", response);
	}

}
