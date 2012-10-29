package controllers;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.softudy.there.R;

public class OpcionDiseno extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_opcion_diseno);
		
		//se obtiene el linear Layout 
		//final LinearLayout ll =(LinearLayout) findViewById(R.id.LinearLayoutDisenoFondo);
		final RelativeLayout rl = (RelativeLayout)findViewById(R.id.RelativeLayoutDisenoFondo);
		//se crean los botnes y se le asigna el view
		final RadioButton radio_amarillo =(RadioButton) findViewById(R.id.radioColorAmarillo);
		final RadioButton radio_azul= (RadioButton) findViewById(R.id.radioColorAzul);
		final RadioButton radio_rojo=(RadioButton) findViewById(R.id.radioColorRojo);
		final RadioButton radio_verde=(RadioButton) findViewById(R.id.radioColorVerde);
		
		//se crean los listeners para poder cambiar de fondo
		radio_amarillo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rl.setBackgroundColor(Color.YELLOW);
			}
		});
		radio_azul.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rl.setBackgroundColor(Color.BLUE);
			}
		});
		radio_rojo.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rl.setBackgroundColor(Color.RED);
			}
		});
		radio_verde.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rl.setBackgroundColor(Color.GREEN);
			}
		});
	}

}
