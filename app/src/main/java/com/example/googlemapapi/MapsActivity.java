package com.example.googlemapapi;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapapi.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        mMap = googleMap;

//        // Add a marker in Sydney and move the camera
//        // vĩ độ và kinh độ
//        LatLng sydney = new LatLng(-34, 151);
//        // thêm vị trí đánh dấu mới trên bản đồ (thêm điểm đánh dấu vào tọa độ này)
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        // di chuyển camera về điểm được đánh dấu
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


//        LatLng hanoiLatLng = new LatLng(21.0285, 105.8542);
//        mMap.addMarker(new MarkerOptions()
//                .position(hanoiLatLng)
//                .draggable(true)
//                .snippet("hello")
//                .title("Hà Nội"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(hanoiLatLng));

        LatLng m1 = new LatLng(-20, -20);
        LatLng m2 = new LatLng(20, -20);
        LatLng m3 = new LatLng(20, 20);
        LatLng m4 = new LatLng(-20, 20);
//
//
//        LatLng m6 = new LatLng(0, 0);
//        LatLng m7 = new LatLng(5, 0);
//        LatLng m8 = new LatLng(5, 5);
//        LatLng m9 = new LatLng(0, 5);
//        marker = mMap.addMarker(new MarkerOptions()
//                .position(m1)
//                .title("marker 1")
//        );


//        ArrayList<LatLng> latLngs = new ArrayList<>();
//        latLngs.add(m6);
//        latLngs.add(m7);
//        latLngs.add(m8);
//        latLngs.add(m9);
////        mMap.setOnMarkerClickListener(this);
//
//        PolygonOptions rectOption = new PolygonOptions()
//                .add(m1,m2,m3,m4)
//                .addHole(latLngs)
//                .fillColor(Color.BLUE)
//                .strokeColor(Color.RED);
//
//        Polygon polygon = mMap.addPolygon(rectOption);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));

        // Thiết lập chế độ hiển thị bản đồ
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); // Hoặc MAP_TYPE_SATELLITE, MAP_TYPE_HYBRID, ...

// Di chuyển camera đến Hà Nội
        LatLng hanoiLatLng = new LatLng(21.0285, 105.8542);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoiLatLng, 15)); // Zoom level từ 1-20

// Đánh dấu một vị trí
        MarkerOptions markerOptions = new MarkerOptions()
                .position(hanoiLatLng)
                .title("Hà Nội")
                .snippet("Thủ đô của Việt Nam");
        mMap.addMarker(markerOptions);

// Vẽ đường line
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(21.0285, 105.8542))
                .add(new LatLng(21.0285, -105.8542))
                .color(Color.RED)
                .width(5); // Độ rộng của đường line
        mMap.addPolyline(polylineOptions);

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
//        Toast.makeText(this, "My Position" + marker.getPosition(),
//                Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "My Position" + marker.getPosition().latitude,
                Toast.LENGTH_SHORT).show();
        return false;
    }
}