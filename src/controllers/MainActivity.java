package controllers;

import com.softudy.there.R;
import com.softudy.there.R.layout;
import com.softudy.there.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.view.View;

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
    
    public void addListenerOnButton() {
    	 
		final Context context = this;
 
		button = (Button) findViewById(R.id.buttonPrincRegistrarse);
 
		button.setOnClickListener(new OnClickListener() {
			
			
			
			public void onClick(View arg0) {
				System.out.println("aca");
			    Intent intent = new Intent(context, RegistroMain.class);
                            startActivity(intent);   
                System.out.println("llego");
			}
 
		});
    
   
}
    }
