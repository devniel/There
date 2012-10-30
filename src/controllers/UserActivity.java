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
	private GeoPoint geoP;

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
	
		//otra geolocalizacion
		double latitud = -19.084742;
		double longitud = -76.971374;
		
	
		
		this.geoP = new GeoPoint((int)(latitud*1E6), (int)(longitud*1E6));
		GeoPoint p1 = new GeoPoint(37423021,-122083739);
		
		List<Overlay> listOfOverlays = mv_mapa.getOverlays();
        Drawable drawable =
            this.getResources().getDrawable(R.drawable.ic_marker2);


        
        MyItemizedOverlay itemizedoverlay =
                new MyItemizedOverlay(drawable, this);
            OverlayItem overlayitem1 = new OverlayItem(
                p1, "Hello Google!", "I'm an Android!");

            //---add an overlayitem---
            itemizedoverlay.addOverlay(overlayitem1);
            
            //---add the overlay---
            listOfOverlays.add(itemizedoverlay);

        mControl.animateTo(p1);
		this.mControl.setZoom(15);
	
		
		
		// Add the MyLocationOverlay
		myLocation = new MyLocationOverlay(this, mv_mapa);
		mv_mapa.getOverlays().add(myLocation);
		myLocation.enableMyLocation();
		//muestra la localizacion con un marker
		 myLocation.runOnFirstFix(new Runnable() {
		       public void run() {
		           mControl.animateTo(myLocation.getMyLocation());
		       }});
		 
	

	
	}

	
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
	
}
