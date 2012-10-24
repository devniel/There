package controllers;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.softudy.there.R;


public class UserActivity extends MapActivity {
	private MapController mControl;
	private GeoPoint geoP;
	private MapView mv_mapa;

	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		Log.d("CARGANDO ", "CARGANDO ...:");

		super.setContentView(R.layout.user_home);

		Log.d("CARGANDO ", "EXITO !!!!!!");

		this.mv_mapa = (MapView) super.findViewById(R.id.mv_mapa);
		this.mControl = this.mv_mapa.getController();

		double latitud = -12.084742;
		double longitud = -76.971374;
		this.geoP = new GeoPoint((int) (latitud * 1E6), (int) (longitud * 1E6));

		this.mControl = this.mv_mapa.getController();
		this.mControl.animateTo(this.geoP);
		this.mControl.setZoom(15);
	}

	protected boolean isRouteDisplayed() {
		return false;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.user_menu, menu);
	    return true;
	}
}
