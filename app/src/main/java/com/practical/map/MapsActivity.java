package com.practical.map;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mMarker;

    private LatLng nMarkerLatLng = new LatLng(18.51,73.83);
    private LatLng mMarkerLatLng = new LatLng(18.51168087993004, 73.83912943290271);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Enable zoom controls
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Set terrain map type
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


        // Set initial camera position and zoom level
        LatLng initialLatLng = new LatLng(18.51168087993004, 73.83912943290271);
        float initialZoom = 12;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, initialZoom));

        // Add marker
        mMarker = mMap.addMarker(new MarkerOptions().position(mMarkerLatLng));
    }
}
