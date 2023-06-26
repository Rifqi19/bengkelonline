package com.example.benglelonline;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps);
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

        LatLng tambalban1 = new LatLng(-7.8434791771923, 110.39104438398498);
        mMap.addMarker(new MarkerOptions().position(tambalban1).title("Tambal Ban pak Adi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban1, 15));

        LatLng tambalban2 = new LatLng(-7.844781563030907, 110.41093007267762);
        mMap.addMarker(new MarkerOptions().position(tambalban2).title("Pak Rohmat Tambal Ban"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban2, 15));

        LatLng tambalban3 = new LatLng(-7.827176133748342, 110.39848675733506);
        mMap.addMarker(new MarkerOptions().position(tambalban3).title("Tambal Ban KotaGede"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban3, 15));

        LatLng tambalban4 = new LatLng(-7.824636147550596, 110.37741382866751);
        mMap.addMarker(new MarkerOptions().position(tambalban4).title("Tambal Ban"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban4, 15));

        LatLng tambalban5 = new LatLng(-7.827178949236324, 110.40836248633885);
        mMap.addMarker(new MarkerOptions().position(tambalban5).title("Tambal Ban Vul Kanisir Prm"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tambalban5, 15));
    }
}