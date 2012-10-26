package controllers;



import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Container extends TabActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       //creamos el contenedor de Tabs
       TabHost host = getTabHost();
       //Añadimos cada tab, que al ser pulsadas abren sus respectivas Activities
       host.addTab(host.newTabSpec("tab_inicio").setIndicator("Inicio").setContent(new Intent(this, UserActivity.class)));
       host.addTab(host.newTabSpec("tab_tags").setIndicator("Tags").setContent(new Intent(this, TagsActivity.class)));
       host.addTab(host.newTabSpec("tab_opciones").setIndicator("Opciones").setContent(new Intent(this, OpcionesActivity.class)));
       
   }
}