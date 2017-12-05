package com.example.shane.campuscompass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    GoogleMap map;
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
    LatLng smithChapel = new LatLng(42.119842, -79.989786);
    LatLng junker = new LatLng(42.120150, -79.978346);
    LatLng reed = new LatLng(42.119371, -79.983807);
    LatLng kochel = new LatLng(42.120066, -79.982069);
    LatLng library = new LatLng(42.120382, -79.981370);
    LatLng admissions = new LatLng(42.120481, -79.982792);
    LatLng erie = new LatLng(42.120537, -79.984298);
    LatLng obs = new LatLng(42.119011, -79.986940);
    LatLng nick = new LatLng(42.119598, -79.987583);
    LatLng wit = new LatLng(42.119516, -79.988344);
    LatLng hammermill = new LatLng(42.118988, -79.987981);
    LatLng perry = new LatLng(42.118564, -79.983369);
    LatLng senat = new LatLng(42.118394, -79.984340);
    LatLng niagara = new LatLng(42.119252, -79.981863);
    LatLng tennis = new LatLng(42.121483, -79.982511);
    LatLng wellness = new LatLng(42.119005, -79.984689);


    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment)getFragmentManager().findFragmentById(R.id.map1);
        //mapFragment.getMapAsync(this);

        Spinner spinner = (Spinner)v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.locations, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return v;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(behrend).title("Marker at Behrend"));
        map.moveCamera(CameraUpdateFactory.newLatLng(behrend));
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String sSelected=parent.getItemAtPosition(pos).toString();
        Toast.makeText(getContext(),sSelected,Toast.LENGTH_SHORT).show();

        if (sSelected == "Burke") {
            map.addMarker(new MarkerOptions().position(burke).title("Marker at Burke"));
            map.moveCamera(CameraUpdateFactory.newLatLng(burke));
        }
        if (sSelected == "Library") {
            map.addMarker(new MarkerOptions().position(library).title("Marker at Lily Library"));
            map.moveCamera(CameraUpdateFactory.newLatLng(library));
        }
        if (sSelected == "OBS") {
            map.addMarker(new MarkerOptions().position(obs).title("Marker at OBS"));
            map.moveCamera(CameraUpdateFactory.newLatLng(obs));
        }
        if (sSelected == "Almy") {
            map.addMarker(new MarkerOptions().position(almy).title("Marker at Almy"));
            map.moveCamera(CameraUpdateFactory.newLatLng(almy));
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // lol
    }
}


