package com.comp586.group2.mattamaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    /* Google Map Object */
    private GoogleMap mMap;

    /* Default coordinates for CSUN campus */
    private static final double DEFAULT_LAT = 34.240033;
    private static final double DEFAULT_LNG = -118.527569;

    private static final float DEFAULT_ZOOM = (float)14.50;

    /* Zoom bounds for the map view */
    private static final float MIN_ZOOM = 10;
    private static final float MAX_ZOOM = 20;

    /* Longitude and lattitude bounds for map view */
    private static final double MIN_LAT = 0;
    private static final double MIN_LNG = 0;
    private static final double MAX_LAT = 0;
    private static final double MAX_LNG = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;

        // Set the csun Lattitude and longitude object */
        LatLng csun = new LatLng(this.DEFAULT_LAT, this.DEFAULT_LNG);

        LatLng neBounds = new LatLng(this.MIN_LAT, this.MIN_LNG);
        LatLng swBounds = new LatLng(this.MAX_LAT, this.MAX_LNG);

        LatLngBounds csunBounds = new LatLngBounds(neBounds, swBounds);

        this.mMap.addMarker(new MarkerOptions().position(csun).title("Marker at CSUN"));
        this.mMap.moveCamera(CameraUpdateFactory.newLatLng(csun));

        //this.mMap.setLatLngBoundsForCameraTarget(csunBounds);

        this.mMap.moveCamera(CameraUpdateFactory.zoomTo(this.DEFAULT_ZOOM));
       // this.mMap.setPadding(10,0,0,0);
    }
}
