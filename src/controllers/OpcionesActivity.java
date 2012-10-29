package controllers;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.softudy.there.R;

public class OpcionesActivity extends ListActivity{
	  //Lista de array strings que servira como list Items
    ArrayList<String> listItems= new ArrayList<String>();
  //se define el string adapter el cual manejara la data del listview
    ArrayAdapter<String> adapter;
  //grabar el numero de veces que el boton es seleccionado
    int clickCounter = 0;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	   
	      String[] opciones = new String[] {"Cuenta","Contraseña","Notificaciones","Diseño","Opciones de Busqueda"};
	      
	      //usando un layout
	      ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.user_opciones,R.id.opciones, opciones);
	      setListAdapter(adapter);
	       
	        
	 }
	 
	 @Override
	 protected void onListItemClick(ListView l, View v, int position, long id){
		 String item = (String) getListAdapter().getItem(position);
		 Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
		 
		 
		 if(item == "Cuenta"){
			 Intent intent= new Intent(this,OpcionCuenta.class);
			 startActivity(intent);
		 }
		 else if(item=="Contraseña"){
			 
		 }
		 else if(item=="Notificaciones"){
			 Intent intent= new Intent(this,OpcionNotificaciones.class);
			 startActivity(intent);
		 }
		 else if(item=="Diseño"){
			 Intent intent = new Intent(this,OpcionDiseno.class);
			 startActivity(intent);
			 
		 }
		 else if(item=="Opciones de Busqueda"){
			 
			 
		 }
		 
	 }
}