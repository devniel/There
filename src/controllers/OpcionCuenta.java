package controllers;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

import com.softudy.there.R;

public class OpcionCuenta extends Activity {
	
	//http://www.mkyong.com/android/android-spinner-drop-down-list-example/
	//para que hacer listener a las opciones de idioma falta terminarlo
	private Spinner idiomaSpinner;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_opcion_cuenta);

	}

}
