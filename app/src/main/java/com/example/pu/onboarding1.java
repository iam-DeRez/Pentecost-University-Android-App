package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class onboarding1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);
    }
        public void nextOn2(View view) {
            Intent nextOn2 = new Intent(this,onboarding2.class);
            startActivity (nextOn2);
            finish();
    }

}