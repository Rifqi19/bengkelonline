package com.example.benglelonline;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsTambalBan extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps_tambal_ban);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
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
        mMap = googleMap;
        mMap.isMyLocationEnabled();

        LatLng tambalban1 = new LatLng(-7.835255992427816, 110.39335839932755);
        mMap.addMarker(new MarkerOptions().position(tambalban1).title("Tambal Ban 1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban1, 15));

        LatLng tambalban2 = new LatLng(-7.837105377416933, 110.39917342824852);
        mMap.addMarker(new MarkerOptions().position(tambalban2).title("Tambal Ban 2"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban2, 15));

        LatLng tambalban3 = new LatLng(-7.817520985856217, 110.39039729966375);
        mMap.addMarker(new MarkerOptions().position(tambalban3).title("Tambal Ban 3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban3, 15));
    }
}