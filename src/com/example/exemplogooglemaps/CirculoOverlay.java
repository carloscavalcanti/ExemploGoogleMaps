package com.example.exemplogooglemaps;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class CirculoOverlay extends Overlay {
	
	private GeoPoint geoPoint;
	
	public CirculoOverlay(GeoPoint geoPoint) {
		this.geoPoint = geoPoint;
	}
	
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);
		if (geoPoint != null) {

	        
			Point point = mapView.getProjection().toPixels(geoPoint, null);
			
			Paint paint = new Paint();
			paint.setColor(Color.RED);
			canvas.drawCircle(point.x, point.y, 10, paint);
		}
	}

}
