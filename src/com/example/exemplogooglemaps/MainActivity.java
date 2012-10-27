package com.example.exemplogooglemaps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {
	
	private MapView mapView;
	private EditText edtLongitude, edtLatitude;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MapView mapView = new MapView(this, "key");
        setContentView(R.layout.activity_main);
        
        edtLongitude = (EditText) findViewById(R.id.edtLongitude);
        edtLatitude = (EditText) findViewById(R.id.edtLatitude);
        
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.setStreetView(true);
        mapView.setClickable(true);
        
        //Graus
        double latitude = -25.442580;
        double longitude = -49.279840;
        //Converte para microdegress (graus * 1E6)
        int latitudeE6 = (int) (latitude * 1E6);
        int longitudeE6 = (int) (longitude * 1E6);
        
        GeoPoint geoPoint = new GeoPoint(latitudeE6, longitudeE6);
        
        mapView.getController().setCenter(geoPoint);
        mapView.getController().setZoom(18);

        mapView.setBuiltInZoomControls(true);
        mapView.getOverlays().add(new CirculoOverlay(geoPoint));
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	private int calcular1E6(double valor) {
		return (int) (valor * 1E6);
	}
	
	public void onAtualizar(View v) {
		
		//Pega os graus informados nos edits
        double latitude = Double.valueOf(edtLatitude.getText().toString());
        double longitude = Double.valueOf(edtLongitude.getText().toString());

        //Converte para microdegress (graus * 1E6)
        int latitudeE6 = calcular1E6(latitude);
        int longitudeE6 = calcular1E6(longitude);
        
        GeoPoint geoPoint = new GeoPoint(latitudeE6, longitudeE6);
        
        mapView.getController().setCenter(geoPoint);
        mapView.getOverlays().clear();
        mapView.getOverlays().add(new CirculoOverlay(geoPoint));
	}

}
