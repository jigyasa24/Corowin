package com.example.helpus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.helpus.VolleySingleton;
import com.example.helpus.model.User;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class RegisterAct extends AppCompatActivity  implements View.OnClickListener {
    @SuppressLint("StaticFieldLeak")
    private static EditText nameEdit, Contact, Age, Bg, Address, passwordEdit;
    @SuppressLint("StaticFieldLeak")
    private static Button submit;
    private static TextView linklogin;
    private StringRequest stringRequest;
    private VolleySingleton singleton;
    private static final String KEY_NAME = "name";
    private static final String KEY_CONTACT = "contact";
    private static final String KEY_AGE = "age";
    private static final String KEY_BG = "bg";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PASSWORD = "password";

    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_patient);
        linklogin = findViewById(R.id.linklogin);
        linklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterAct.this, LoginAct.class);
                startActivity(intent);
                finish();
            }
        });
        preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        submit.setOnClickListener(this);
    }

    private void init() {
        nameEdit = findViewById(R.id.userName);
        Contact = findViewById(R.id.phone);
        Age = findViewById(R.id.age);
        Bg = findViewById(R.id.Bg);
        Address = findViewById(R.id.Address);
        passwordEdit = findViewById(R.id.pass);
        submit = findViewById(R.id.signUpButton);
    }

    @Override
    public void onClick(View v) {
        if(v==submit)
            registerUser();
    }

    private void registerUser()
    {


        User user = new DAOClass().setData();
        stringRequest = new StringRequest(Request.Method.POST, Constants.REG_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("INFO",response);
                        if(user!=null)
                        {
                            if(response.equals("success")){
                                Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("username",user.getName());
                                editor.apply();
                                Intent intent = new Intent(getApplicationContext(), LoginAct.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginAct.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", error.getMessage());
                //Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @NotNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(KEY_NAME, user.getName());
                hashMap.put(KEY_CONTACT, user.getContact());
                hashMap.put(KEY_AGE, user.getAge());
                hashMap.put(KEY_BG, user.getBg());
                hashMap.put(KEY_ADDRESS, user.getAddress());
                hashMap.put(KEY_PASSWORD, user.getPassword());
                return hashMap;
            }
        };
        singleton = VolleySingleton.getInstance(this);
        singleton.addToRequestQueue(stringRequest);
    }
    private static class DAOClass {
        public User setData()
        {
            String name = nameEdit.getText().toString().trim();
            String contact = Contact.getText().toString().trim();
            String age = Age.getText().toString().trim();
            String bg = Bg.getText().toString().trim();
            String address = Address.getText().toString().trim();
            String password = passwordEdit.getText().toString().trim();
            if(TextUtils.isEmpty(name))
                nameEdit.setError("Please Fill the Field");
            else if(TextUtils.isEmpty(contact))
                Contact.setError("Please Fill the Field");
            else if(TextUtils.isEmpty(age))
                Age.setError("Please Fill the Field");
            else if(TextUtils.isEmpty(bg))
                Bg.setError("Please Fill the Field");
            else if(TextUtils.isEmpty(address))
                Address.setError("Please Fill the Field");
            else if (TextUtils.isEmpty(password))
                passwordEdit.setError("Please Fill the Field");
            else if (password.length()<8)
                passwordEdit.setError("Password is too Short");
            else if (contact.length()!=10)
                Contact.setError("Contact Number is Incorrect");
            else{
                return new User(name, contact, age, bg, address, password);
            }
            return null;
        }
    }
}