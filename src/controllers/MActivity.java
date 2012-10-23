package controllers;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.softudy.there.R;

public class MActivity extends MapActivity{
	private MapController mControl;
	private GeoPoint geoP;
	private MapView mv_mapa;
	@Override
	protected void onCreate(Bundle arg0){
		super.onCreate(arg0);
		super.setContentView(R.layout.geolocalizar_main);
		
		this.mv_mapa=(MapView)super.findViewById(R.id.mv_mapa);
		this.mControl=this.mv_mapa.getController();
		
		double latitud=-12.084742;
		double longitud=-76.971374;
		this.geoP=new GeoPoint((int)(latitud*1E6),(int)(longitud*1E6));
		
		this.mControl = this.mv_mapa.getController();
		this.mControl.animateTo(this.geoP);
		this.mControl.setZoom(15);
	}
	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}

}
