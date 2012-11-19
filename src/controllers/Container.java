package controllers;



import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.softudy.there.R;

public class Container extends TabActivity {
  
   @Override
   public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
       //creamos el contenedor de Tabs
       TabHost host = getTabHost();
	   Resources res= getResources();

	   
       //Añadimos cada tab, que al ser pulsadas abren sus respectivas Activities
       host.addTab(host.newTabSpec("tab_inicio").setIndicator("Inicio").setContent(new Intent(this, UserActivity.class)));
       host.addTab(host.newTabSpec("tab_tags").setIndicator("Tags").setContent(new Intent(this, TagsActivity.class)));
       host.addTab(host.newTabSpec("tab_opciones").setIndicator("Opciones").setContent(new Intent(this, OpcionesActivity.class)));
       host.addTab(host.newTabSpec("tab_contactos").setIndicator("Contactos").setContent(new Intent(this, ContactosActivity.class)));
       
       
   }
}