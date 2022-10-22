package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class onboarding2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);
    }
    public void nextOn3(View view) {
        Intent nextOn3 = new Intent(this,onboarding3.class);
        startActivity (nextOn3);
        finish();
    }
}