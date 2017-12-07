package com.example.shane.campuscompass;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MapFragment extends Fragment implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    GoogleMap map;


    LatLng behrend = new LatLng(42.117509, -79.9808142);
    LatLng dobbins = new LatLng(42.118145, -79.982581);
    LatLng lawrence = new LatLng(42.118554, -79.981666);
    LatLng porcupine = new LatLng(42.117798, -79.983391);
    LatLng tigress = new LatLng(42.117489, -79.983692);
    LatLng tiffany = new LatLng(42.117176, -79.983461);
    LatLng almy = new LatLng(42.116354, -79.983783);
    LatLng ohio = new LatLng(42.116527, -79.984620);
    LatLng apartments = new LatLng(42.117046, -79.982073);
    LatLng burke = new LatLng(42.118774, -79.980085);
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

        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map1);
        //mapFragment.getMapAsync(this);

        Spinner spinner = v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.locations, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return v;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);


        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setBuildingsEnabled(true);
        googleMap.setMinZoomPreference(15.5f);
        googleMap.setMaxZoomPreference(18.0f);

        map.addMarker(new MarkerOptions().position(behrend).title("Marker at Behrend"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(behrend, 15.5f));
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String sSelected = parent.getItemAtPosition(pos).toString();
        Toast.makeText(getContext(), sSelected, Toast.LENGTH_SHORT).show();
        System.out.println(sSelected);

        if (sSelected.equals("Burke")) {
            dropPin(burke,sSelected);
        }
       else if (sSelected.equals("Library")) {
            dropPin(library,sSelected);
        }
          else  if (sSelected.equals("OBS")) {
                dropPin(obs, sSelected);
            }
               else if (sSelected.equals("Almy")) {
                    dropPin(almy,sSelected);
                }
              else  if (sSelected.equals("Junker Center")) {
                    dropPin(junker,sSelected);
                }
               else if (sSelected.equals("Reed Building")) {
                    dropPin(reed,sSelected);
                }
             else   if (sSelected.equals("Kochel")) {
                    dropPin(kochel,sSelected);
                }
             else   if (sSelected.equals("Admissions Building")) {
                    dropPin(admissions,sSelected);
                }
              else  if (sSelected.equals("Nick Building")) {
                    dropPin(nick,sSelected);
                }
              else  if (sSelected.equals("Wit Building")) {
                    dropPin(wit,sSelected);
                }
              else  if (sSelected.equals("Hammermill")) {
                    dropPin(hammermill,sSelected);
                }
              else  if (sSelected.equals("Perry Hall")) {
                    dropPin(perry,sSelected);
                }
              else  if (sSelected.equals("Senat Hall")) {
                    dropPin(senat,sSelected);
                }
              else  if (sSelected.equals("Niagara Hall")) {
                    dropPin(niagara,sSelected);
                }
              else  if (sSelected.equals("Tennis Courts")) {
                    dropPin(tennis,sSelected);
                }
              else  if (sSelected.equals("Wellness Center")) {
                    dropPin(wellness,sSelected);
                }
       else if (sSelected.equals("tiffany")) {
            dropPin(tiffany,sSelected);
        }
      else  if (sSelected.equals("ohio")) {
            dropPin(ohio,sSelected);
        }
       else if (sSelected.equals("apartments")) {
            dropPin(apartments,sSelected);
        }
      else  if (sSelected.equals("smithChapel")) {
            dropPin(smithChapel,sSelected);
        }
      else  if (sSelected.equals("erie")) {
            dropPin(erie,sSelected);
        }
      else  if (sSelected.equals("tigress")) {
            dropPin(tigress,sSelected);
        }
      else  if (sSelected.equals("porcupine")) {
            dropPin(porcupine,sSelected);
        }
      else  if (sSelected.equals("lawrence")) {
            dropPin(lawrence,sSelected);
        }
      else if  (sSelected.equals("dobbins")){
            dropPin(dobbins,sSelected);
        }

    }

    public void dropPin(LatLng x, String name){
        map.clear();
        map.addMarker(new MarkerOptions().position(x).title("Marker at " + name));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(x, 16.5f));
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // lol
    }
/*
    private String getUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;


        return url;
    }
 */
    // Fetches data from url passed
    /*
    private class FetchUrl extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }
*/
    /*
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }
*/
    /*
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                Log.d("ParserTask",jsonData[0].toString());
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());

                // Starts parsing data
                routes = parser.parse(jObject);
                Log.d("ParserTask","Executing routes");
                Log.d("ParserTask",routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask",e.toString());
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);

                Log.d("onPostExecute","onPostExecute lineoptions decoded");

            }

            // Drawing polyline in the Google Map for the i-th route
            if(lineOptions != null) {
                map.addPolyline(lineOptions);
            }
            else {
                Log.d("onPostExecute","without Polylines drawn");
            }
        }
    }
*/

    public class DataParser {

        /** Receives a JSONObject and returns a list of lists containing latitude and longitude */

        public List<List<HashMap<String,String>>> parse(JSONObject jObject){

            List<List<HashMap<String, String>>> routes = new ArrayList<>() ;
            JSONArray jRoutes;
            JSONArray jLegs;
            JSONArray jSteps;

            try {

                jRoutes = jObject.getJSONArray("routes");

                /** Traversing all routes */
                for(int i=0;i<jRoutes.length();i++){
                    jLegs = ( (JSONObject)jRoutes.get(i)).getJSONArray("legs");
                    List path = new ArrayList<>();

                    /** Traversing all legs */
                    for(int j=0;j<jLegs.length();j++){
                        jSteps = ( (JSONObject)jLegs.get(j)).getJSONArray("steps");

                        /** Traversing all steps */
                        for(int k=0;k<jSteps.length();k++){
                            String polyline = "";
                            polyline = (String)((JSONObject)((JSONObject)jSteps.get(k)).get("polyline")).get("points");
                            List<LatLng> list = decodePoly(polyline);

                            /** Traversing all points */
                            for(int l=0;l<list.size();l++){
                                HashMap<String, String> hm = new HashMap<>();
                                hm.put("lat", Double.toString((list.get(l)).latitude) );
                                hm.put("lng", Double.toString((list.get(l)).longitude) );
                                path.add(hm);
                            }
                        }
                        routes.add(path);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }catch (Exception e){
            }


            return routes;
        }


        /**
         * Method to decode polyline points
         * Courtesy : https://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction-api-with-java
         * */
        private List<LatLng> decodePoly(String encoded) {

            List<LatLng> poly = new ArrayList<>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)),
                        (((double) lng / 1E5)));
                poly.add(p);
            }

            return poly;
        }
    }


}



