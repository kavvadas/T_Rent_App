package gr.aueb.sweng22.team11.view.Renter.RenterMaps;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.databinding.ActivityRenterMapsBinding;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestActivity;


public class RenterMapsActivity extends FragmentActivity implements OnMapReadyCallback, RenterMapsView{

    private RenterMapsViewModel viewModel;
    private GoogleMap mMap;
    private ActivityRenterMapsBinding binding;

    public static final String AD_TITLE = "ad_title_extra";
    public static final String RENTER_NICKNAME_EXTRA = "renter_nickname_extra";

    private String renterN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RenterMapsViewModel.class);
        viewModel.getPresenter().setView(this);

        renterN = getIntent().getStringExtra(RENTER_NICKNAME_EXTRA);

        binding = ActivityRenterMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void AddressMarker(String comment,String Region, String postal, String street) {

        Geocoder geocoder = new Geocoder(this);
        List<Address> addressList;

        double lat = 0;
        double lon = 0;

        try {
            addressList = geocoder.getFromLocationName(comment+" "+postal +" " + street+" "+Region,1);



            if (addressList != null) {
                double convertedLat = addressList.get(0).getLatitude();
                double convertedLon = addressList.get(0).getLongitude();
                lat = convertedLat;
                lon = convertedLon;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        setMarker((comment+" "+Region + " " + postal + " " + street),lat,lon);
    }







    public void setMarker(String name,Double latitude, Double longtitude){
        LatLng generic_name  = new LatLng(latitude,longtitude);
        mMap.addMarker(new MarkerOptions().position(generic_name).title(name));}
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        googleMap.setIndoorEnabled(false);

        LatLng athens = new LatLng(37.983810, 23.727539);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(athens));

        viewModel.getPresenter().onAddressMarker();

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                Intent intent = new Intent(RenterMapsActivity.this, RenterCreateRequestActivity.class);
                String title = marker.getTitle();
                String[] res = title.split(" ",2);
                String comment = res[0];
                System.out.println(comment);

                intent.putExtra(RENTER_NICKNAME_EXTRA,renterN);
                intent.putExtra(AD_TITLE,comment);
                startActivity(intent);
                return false;
            }
        });


    }
    public void onZoom(View view) {
        if (view.getId() == R.id.zoom_in) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if (view.getId() == R.id.zoom_out) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }




    //TODO add InfoView[DONE] + add the setMarker method via buttons[PENDING]
}
