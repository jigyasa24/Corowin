package com.example.helpus;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SelfDiagnosis extends AppCompatActivity {
    private AppCompatEditText oxygen, pulse;
    private RadioGroup  fever, breathe, cough, pain, motion;
    private AppCompatRadioButton feveryes, feverno, breathingyes, breathingno, soreyes, soreno, painyes, painno, fouryes, fourno;
    private AppCompatButton SubmitSelfDiagnosis;

    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_diagnosis);
        init();
        myDialog = new Dialog(this);
        Button SubmitSelfDiagnosis = findViewById(R.id.SubmitSelfDiagnosis);
        SubmitSelfDiagnosis.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                System.out.println("Button Clicked");
                userDetails();
            }
        });
    }

    public void ShowPopupcongrats(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popuplowrisk);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopupcaution(View v) {
        TextView txtclose;
        myDialog.setContentView(R.layout.popuphighrisk);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void userDetails()
    {
        int oxy = Integer.parseInt(oxygen.getText().toString().trim());
        int pul = Integer.parseInt(pulse.getText().toString().trim());
        int f = fever.getCheckedRadioButtonId();
        int b = breathe.getCheckedRadioButtonId();
        int c = cough.getCheckedRadioButtonId();
        int p = pain.getCheckedRadioButtonId();
        int m = motion.getCheckedRadioButtonId();

        if (pul > 95 || oxy < 90) {
            ShowPopupcaution(pulse);
        }
        else if(pul<95 || oxy>90){
            int x=0;

            switch (f)
            {
                case R.id.feveryes: x=1;
            }
            switch (b)
            {
                case R.id.breathingyes: x=1;
            }
            switch (c)
            {
                case R.id.soreyes: x=1;
            }
            switch (p)
            {
                case R.id.painyes: x=1;
            }
            switch (m)
            {
                case R.id.fouryes: x=1;
            }

            if(x==0)
            {
                ShowPopupcongrats(motion);
            }
            else
            {
                ShowPopupcaution(motion);
            }
        }
        else {
            ShowPopupcongrats(SubmitSelfDiagnosis);
        }

    }

    private void init()
    {
        oxygen = findViewById(R.id.oxygen);
        pulse = findViewById(R.id.pulse);
        fever = findViewById(R.id.fever);
        breathe = findViewById(R.id.breathe);
        cough = findViewById(R.id.cough);
        pain = findViewById(R.id.pain);
        motion = findViewById(R.id.motion);
        feveryes = findViewById(R.id.feveryes);
        feverno = findViewById(R.id.feverno);
        breathingyes = findViewById(R.id.breathingyes);
        breathingno = findViewById(R.id.breathingno);
        soreyes = findViewById(R.id.soreyes);
        soreno = findViewById(R.id.soreno);
        painyes = findViewById(R.id.painyes);
        painno = findViewById(R.id.painno);
        fouryes = findViewById(R.id.fouryes);
        fourno = findViewById(R.id.fourno);
    }
}