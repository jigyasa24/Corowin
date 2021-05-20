package com.example.helpus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button distributor = findViewById(R.id.distributor);
        Button patient = findViewById(R.id.patient);
        distributor.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), sign_up_Distributor.class);
                startActivity(activity2Intent);
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), RegisterAct.class);
                startActivity(activity2Intent);
            }
        });


    }
}