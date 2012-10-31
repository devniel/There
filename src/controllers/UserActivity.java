package controllers;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.softudy.there.R;
// el link de abajo como poner markers en el mapa
//http://ofps.oreilly.com/titles/9781118177679/google_maps.html
// http://stackoverflow.com/questions/7113980/add-multiple-geopoints-and-markers-automatically-in-google-maps
public class UserActivity extends MapActivity {
	private MapController mControl;
	
	
	private MapView mv_mapa;
	private MyLocationOverlay myLocation; 
	
	
	
	
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	  
		Log.d("CARGANDO ", "CARGANDO ...:");

		super.setContentView(R.layout.user_home);

		Log.d("CARGANDO ", "EXITO !!!!!!");

		// Get Mapping Controllers etc
		this.mv_mapa = (MapView) super.findViewById(R.id.mv_mapa);
		mv_mapa.setSatellite(true);
		this.mControl = this.mv_mapa.getController();	
	
	
		//otras geolocalizaciones aparte de la tuya
		GeoPoint geoP = new GeoPoint(-19084742, -76971374);
		GeoPoint p1 = new GeoPoint(37423021,-122083739);
		
		
		// creo un arreglo de geoPints 
		GeoPoint [] puntos = new GeoPoint[]{geoP,p1};
		// !! obtener los geopoints de la BD para poder asignarlos al arreglo 
		
		
		//se crea una lista de Overlays 
		List<Overlay> listOfOverlays = mv_mapa.getOverlays();
       //se crea una variable drawable para poner los markers en la posiciones
		Drawable drawable =
            this.getResources().getDrawable(R.drawable.ic_marker2);
        MyItemizedOverlay itemizedoverlay =
                new MyItemizedOverlay(drawable, this);
        
       //se crean los overlayitems con cada geopoint en el arreglo
        for(int i =0; i<puntos.length ; i++){
        	 OverlayItem overlayitem = new OverlayItem(
                     puntos[i], "Hello Google!", "I'm an Android! " + i+1);
        	 itemizedoverlay.addOverlay(overlayitem);
        	 //---add the overlay---
             listOfOverlays.add(itemizedoverlay);
        }
        
		
	
		
		//Muestra tu localizacion
		
		// Add the MyLocationOverlay
		myLocation = new MyLocationOverlay(this, mv_mapa);
		mv_mapa.getOverlays().add(myLocation);
		myLocation.enableMyLocation();
		//muestra la localizacion con un marker
		 myLocation.runOnFirstFix(new Runnable() {
		       public void run() {
		    	   //mueve la pantalla al marker que se desee ver
		           mControl.animateTo(myLocation.getMyLocation());
		       }});
		 
		 this.mControl.setZoom(6);


	
	}

	
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
	
}
