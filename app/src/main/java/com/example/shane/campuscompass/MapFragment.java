package com.example.shane.campuscompass;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    LatLngBounds bounds;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v = inflater.inflate(R.layout.fragment_map, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng behrend = new LatLng(42.117509,-79.9808142);
        LatLng dobbins = new LatLng(42.118145,-79.982581);
        LatLng lawrence = new LatLng(42.118554,-79.981666);
        LatLng porcupine = new LatLng(42.117798,-79.983391);
        LatLng tigress = new LatLng(42.117489,-79.983692);
        LatLng tiffany = new LatLng(42.117176,-79.983461);
        LatLng almy = new LatLng(42.116354,-79.983783);
        LatLng ohio = new LatLng(42.116527,-79.984620);
        LatLng apartments = new LatLng(42.117046,-79.982073);
        LatLng burke = new LatLng(42.118774,-79.980085);

        bounds = new LatLngBounds(new LatLng(42.114480, -79.9888863), new LatLng(42.123015, -79.977174));
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 0));

        MarkerOptions option = new MarkerOptions();
        option.position(behrend).title("Behrend");
        map.addMarker(option);
        map.moveCamera(CameraUpdateFactory.newLatLng(behrend));

    }
}
