package com.example.helpus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button Self = findViewById(R.id.Self);
        Button Search = findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(activity2Intent);
            }
        });
        Self.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), SelfDiagnosis.class);
                startActivity(activity2Intent);
            }
        });
    }
}
