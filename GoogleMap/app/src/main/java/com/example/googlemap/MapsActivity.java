package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemap.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    // below are the latitude and longitude
    // of 4 different locations.
    LatLng Turf106 = new LatLng(22.304372951667684, 73.12184456065236);
    LatLng TheEclipse = new LatLng(22.336407956224857, 73.12292836984534);
    LatLng Hattrick = new LatLng(22.353572283307333, 73.17656057778694);
    LatLng Delta9 = new LatLng(22.329110908449245, 73.162939139155);
    LatLng HuddleArena = new LatLng(22.29761671470262, 73.13304456983265);

    // creating array list for adding all our locations.
    private ArrayList<LatLng> locationArrayList;
    private ArrayList<String> markerInPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // in below line we are initializing our array list.
        locationArrayList = new ArrayList<>();

        // on below line we are adding our
        // locations in our array list.
        locationArrayList.add(Turf106);
        locationArrayList.add(TheEclipse);
        locationArrayList.add(Hattrick);
        locationArrayList.add(Delta9);
        locationArrayList.add(HuddleArena);

        markerInPosition = new ArrayList<>();

        markerInPosition.add("Turf 106");
        markerInPosition.add("The Eclipse Sports");
        markerInPosition.add("Hattrick");
        markerInPosition.add("Delta9");
        markerInPosition.add("Huddle Arena");
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

        // Add a marker in Sydney and move the camera
        // LatLng sydney = new LatLng(22.304423629273824, 73.12180761080027);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Turf 106"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // we will be displaying all our markers.
        // for adding markers we are running for loop and
        // inside that we are drawing marker on our map.
        for (int i = 0; i < locationArrayList.size(); i++) {

            // below line is use to add marker to each location of our array list.
            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title(markerInPosition.get(i)));

            // below lin is use to zoom our camera on map.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));

            // below line is use to move our camera to the specific location.
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
        }
    }
}