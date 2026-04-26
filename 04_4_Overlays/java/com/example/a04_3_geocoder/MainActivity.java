package com.example.a04_3_geocoder;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
    }
    public void geo(View v) {
        try {
            Geocoder gc = new Geocoder(this);
            if(gc.isPresent()) {
                List<Address> l = gc.getFromLocationName(et.getText().toString(), 1);
                Address a = l.get(0);
                double lat = a.getLatitude();
                double lng = a.getLongitude();
                tv.setText("Latitude: " + lat + "\nLongitude: " + lng);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void revgeo(View v) {
        try {
            Geocoder gc = new Geocoder(this);
            List<Address> l = gc.getFromLocation(22.4583, 72.9620, 1);
            Address a = l.get(0);
            String result = "";
            result += ("Locality: " + a.getLocality() + "\n");
            result += ("Sub Admin Area: " + a.getSubAdminArea() + "\n");
            result += ("Admin Area: " + a.getAdminArea() + "\n");
            result += ("Country Name: " + a.getCountryName() + "\n");
            result += ("Country Code: " + a.getCountryCode() + "\n");
            tv.setText(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}