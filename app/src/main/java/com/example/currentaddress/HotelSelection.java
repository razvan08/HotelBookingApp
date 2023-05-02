package com.example.currentaddress;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HotelSelection extends AppCompatActivity {

    Button location_goBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_customer_recycler_view);
        LinearLayout vikrant = (LinearLayout) findViewById(R.id.on_click_vikrant);
        LinearLayout pioneer = (LinearLayout) findViewById(R.id.on_click_pioneer);
        LinearLayout oyo = (LinearLayout) findViewById(R.id.on_click_oyo);
        LinearLayout pleasure = (LinearLayout) findViewById(R.id.on_click_pleasureHotel);
        LinearLayout veggie = (LinearLayout) findViewById(R.id.on_click_VeggieIndia);
        LinearLayout daspalla = (LinearLayout) findViewById(R.id.on_click_Daspalla);
        LinearLayout saiparlor = (LinearLayout) findViewById(R.id.on_click_saiparlor);
        LinearLayout area51 = (LinearLayout) findViewById(R.id.on_click_area51);
        LinearLayout maharaja = (LinearLayout) findViewById(R.id.on_click_maharaja);
        location_goBtn = findViewById(R.id.btn_location);

        location_goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),LocationActivity.class);
                startActivity(intent);
            }
        });

        vikrant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage1.class);
                startActivity(intent);
            }
        });
        oyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage2.class);
                startActivity(intent);
            }
        });
        pioneer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage1.class);
                startActivity(intent);
            }
        });
        daspalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage1.class);
                startActivity(intent);
            }
        });
        veggie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage2.class);
                startActivity(intent);
            }
        });
        pleasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage1.class);
                startActivity(intent);
            }
        });
        saiparlor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage2.class);
                startActivity(intent);
            }
        });

        area51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage1.class);
                startActivity(intent);
            }
        });

        maharaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), RegistrationPage2.class);
                startActivity(intent);
            }
        });

    }
}
