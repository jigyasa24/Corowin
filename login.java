package com.example.helpus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button log_in = findViewById(R.id.loginButton);
        log_in.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), Home_page.class);
                startActivity(activity2Intent);
            }
        });
        TextView Link = findViewById(R.id.link);
        Link.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");

                Intent activity2Intent = new Intent(getApplicationContext(), RegisterAct.class);
                startActivity(activity2Intent);
            }
        });
    }
}
