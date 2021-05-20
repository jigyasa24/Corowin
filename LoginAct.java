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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.helpus.model.User;

import java.util.HashMap;
import java.util.Map;

public class LoginAct extends AppCompatActivity {
    private static EditText nameEdit, Contact, Age, Bg, Address, passwordEdit;
    private static TextView textCreateAccount;
    private static Button loginBtn;
    private Button registerText;
    private SharedPreferences preferences;
    private StringRequest stringRequest;
    private VolleySingleton singleton;
    private static final String KEY_CONTACT = "contact";
    private static final String KEY_PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        textCreateAccount = findViewById(R.id.link);
        textCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(getApplicationContext(), RegisterAct.class);
                startActivity(activity2Intent);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(getApplicationContext(), Home_page.class);
                startActivity(activity2Intent);
            }
        });
        preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        init();
    }

    private void init() {
        nameEdit = findViewById(R.id.userName);
        Contact = findViewById(R.id.phone);
        Age = findViewById(R.id.age);
        Bg = findViewById(R.id.Bg);
        Address = findViewById(R.id.Address);
        passwordEdit = findViewById(R.id.pass);
        loginBtn = findViewById(R.id.loginButton);
    }

  /*  @Override
    public void onClick(View v) {
        if(v == loginBtn)
            loginUser();
    }
    @SuppressLint("CommitPrefEdits")
    private void loginUser() {
        User user = new DAOClass().setData();
        stringRequest = new StringRequest(Request.Method.POST, Constants.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("INFO",response);
                        if(user!=null)
                        {
                            if(response.equals("success")){
                                Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("contact", user.getContact());
                                editor.putString("password", user.getPassword());
                                editor.apply();
                                editor.commit();
                                startActivity(new Intent(getApplicationContext(), Home_page.class));
                                finish();
                            }else {
                                Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), Home_page.class));
                                finish();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR",error.toString());
                startActivity(new Intent(getApplicationContext(), Home_page.class));
                finish();
                //Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(KEY_CONTACT, user.getContact());
                hashMap.put(KEY_PASSWORD, user.getPassword());
                return hashMap;
            }
        };
        singleton = VolleySingleton.getInstance(this);
        singleton.addToRequestQueue(stringRequest);
    }

    public static class DAOClass
    {
        public User setData()
        {
            String contact = Contact.getText ().toString().trim();
            String password = passwordEdit.getText ().toString().trim();
            if(TextUtils.isEmpty(contact))
                Contact.setError("Please Fill the Field");
            else if(TextUtils.isEmpty(password))
                passwordEdit.setError("Please Fill the Field");
            else{
                return new User(contact, password);
            }
            return null;
        }
    }*/
}