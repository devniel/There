package controllers;


import com.softudy.there.R;

import models.User;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarActivity extends Activity{
	
	/*
	 * ON CREATE
	 */


	@Override
	public void onCreate(Bundle savedInstanceState){

		Users.ctx = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro_main);

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

		//Users.findById(1L);
		
		Button btn_register = (Button) findViewById(R.id.btn_registro_post);

		 btn_register.setOnClickListener( new Button.OnClickListener(){
			public void onClick(View v){
				EditText tb_email = (EditText)findViewById(R.id.editTextEmailRegistro);
				EditText tb_username = (EditText)findViewById(R.id.editTextUsernameRegistro);
				EditText tb_name = (EditText)findViewById(R.id.editTextNombreRegistro);
				EditText tb_password = (EditText)findViewById(R.id.editTextPasswordRegistro);

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
}
