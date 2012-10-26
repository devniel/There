package controllers;

import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.softudy.there.R;


public class UserActivity extends MapActivity {
	private MapController mControl;
	//private GeoPoint geoP;
	private MapView mv_mapa;
	private MyLocationOverlay myLocation; 
	
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	
		Log.d("CARGANDO ", "CARGANDO ...:");

		super.setContentView(R.layout.user_home);

		Log.d("CARGANDO ", "EXITO !!!!!!");

		// Get Mapping Controllers etc
		this.mv_mapa = (MapView) super.findViewById(R.id.mv_mapa);
		this.mControl = this.mv_mapa.getController();	
	
		
		//this.mControl.animateTo(this.geoP);
		this.mControl.setZoom(15);
	

		// Add the MyLocationOverlay
		myLocation = new MyLocationOverlay(this, mv_mapa);
		mv_mapa.getOverlays().add(myLocation);
		myLocation.enableMyLocation();
		
	
		

		 myLocation.runOnFirstFix(new Runnable() {
		       public void run() {
		           mControl.animateTo(myLocation.getMyLocation());
		       }});
		
	
	
	}

	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.user_menu, menu);
	    return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_user_home:
	            // app icon in action bar clicked; go home
	            Intent intent = new Intent(this, UserActivity.class);
	            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent);
	            return true;
	        case R.id.menu_user_tags:
	        	// app icon in action bar clicked; go home
	            Intent intent_user_tags = new Intent(this, TagsActivity.class);
	            intent_user_tags.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	            startActivity(intent_user_tags);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	*/
	
	
	
}
