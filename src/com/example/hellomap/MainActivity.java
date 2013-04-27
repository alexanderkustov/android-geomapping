package com.example.hellomap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity {
	private GoogleMap mMap;
	private static final LatLng LISBON = new LatLng(38.70798, -9.13670);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setUpMapIfNeeded();

	}

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();

		}
		if (mMap == null) {
			return;
		}

		// mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(LISBON) // Sets the center of the map to Mountain View
				.zoom(17) // Sets the zoom
				.build(); // Creates a CameraPosition from the builder

		mMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));

		/*
		 * Instantiates a new Polyline object and adds points to define a
		 * rectangle PolylineOptions rectOptions = new PolylineOptions()
		 * .add(new LatLng(38.70798,-9.13670)) .add(new LatLng(38.70791,
		 * -9.13670)) // North of the previous point, but at the same longitude
		 * .add(new LatLng(38.50, -9.13670)) // Same latitude, and 30km to the
		 * west .add(new LatLng(38.10, -9.13670)) // Same longitude, and 16km to
		 * the south .add(new LatLng(38.35, -9.13670)); // Closes the polyline.
		 * 
		 * // Get back the mutable Polyline Polyline polyline =
		 * mMap.addPolyline(rectOptions); polyline.setColor(Color.RED);
		 */
		mMap.addMarker(new MarkerOptions()
				.position(new LatLng(38.70798, -9.13670))
				.title("Terreiro do Paço")
				.snippet("This is da real place to be"));
	}
}
