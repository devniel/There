package controllers;

import models.User;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.softudy.there.R;

public class MainActivity extends Activity {
	
	/*
	 * ON CREATE
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;


		/**
		 * CONECTIVIDAD
		 */

		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		
		if (networkInfo != null && networkInfo.isConnected()) {
			// fetch data
			Toast toast = Toast.makeText(context, "CONECTADO", duration);
			toast.show();
			    
		} else {
			// display error
			Toast toast = Toast.makeText(context, "NO CONECTADO", duration);
			toast.show();
		}
		
		Button btn_register = (Button) findViewById(R.id.btn_register);
		
		 btn_register.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v){
				EditText tb_email = (EditText)findViewById(R.id.tb_register_email);
				EditText tb_username = (EditText)findViewById(R.id.tb_register_username);
				EditText tb_name = (EditText)findViewById(R.id.tb_register_name);
				EditText tb_password = (EditText)findViewById(R.id.tb_register_password);
				
				User user = new User();
				user.email = tb_email.getText().toString();
				user.username = tb_username.getText().toString();
				user.firstname = tb_name.getText().toString();
				user.password = tb_password.getText().toString();
				
				Users.create(user);
				
				Toast toast = Toast.makeText(getApplicationContext(),tb_email.getText(), 5000);
				toast.show();
				
				toast = Toast.makeText(getApplicationContext(),tb_username.getText(), 5000);
				toast.show();
				
				toast = Toast.makeText(getApplicationContext(),tb_name.getText(), 5000);
				toast.show();
				
				toast = Toast.makeText(getApplicationContext(), tb_password.getText(), 5000);
				toast.show();
				
			}
		});
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
