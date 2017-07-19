package com.acadgild.googlemaps;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMap();
    }

    private void setupMap(){
        MapFragment mapFragment=(MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions().position(
                new LatLng(28.5654237,77.3825164)).title("My Title"));

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate centre= CameraUpdateFactory.newLatLng(new LatLng(28.5654237,77.3825164));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        googleMap.moveCamera(centre);
        googleMap.animateCamera(zoom);
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                // Geocoder :::
                double latitude=latLng.latitude;
                double longitude=latLng.longitude;

                Geocoder geocoder;
                List<Address> addresses;
                geocoder=new Geocoder(MainActivity.this, Locale.getDefault());

                try{
                    addresses=geocoder.getFromLocation(latitude,longitude,1);
                    String address=addresses.get(0).getAddressLine(0);
                    String city=addresses.get(0).getLocality();
                    String state=addresses.get(0).getAdminArea();
                    String country=addresses.get(0).getCountryName();
                    String postalCode=addresses.get(0).getPostalCode();

                    String message="Address Is:"+address+" "+city+" "+
                                    state+" "+country+" "+postalCode;
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }

        });
    }
}
