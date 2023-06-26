package com.example.benglelonline;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsGantiBan extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_maps_ganti_ban);
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

        LatLng gantiban1 = new LatLng(-7.818125416583455, 110.37944166638135);
        mMap.addMarker(new MarkerOptions().position(gantiban1).title("Planet Ban Jalan Tegalgendu Prenggan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gantiban1, 15));

        LatLng gantiban2 = new LatLng(-7.815585148995763, 110.35915731937789);
        mMap.addMarker(new MarkerOptions().position(gantiban2).title("Planet Ban Parangtritis Mantrijeron Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gantiban2, 15));

        LatLng gantiban3 = new LatLng(-7.800661752336767, 110.37803466478276);
        mMap.addMarker(new MarkerOptions().position(gantiban3).title("Planet Ban Kolonel Sugiono Brontokusuman"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gantiban3, 15));
    }
}