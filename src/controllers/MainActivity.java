package controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.softudy.there.R;

public class MainActivity extends Activity {
	
	Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    /** Llama cuando se selecciona registrar */
    public void btn_register_action(View view) {
    	Intent intent = new Intent(this, RegistrarActivity.class);
    	startActivity(intent);
    	
    }
    
    
    
    
    /*
     * Acción a ejecutar al presionar el botón de logueo
     */
    
    public void btn_login_action(View view) {
    	
    	Intent intent = new Intent(this,Container.class);
    	startActivity(intent);
    }
   
}
    
