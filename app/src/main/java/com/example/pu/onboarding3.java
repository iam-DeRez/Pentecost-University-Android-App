package com.example.pu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class onboarding3 extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding3);

        button = findViewById(R.id.button2);
    }
    public void loginS(View view) {
        Intent loginS = new Intent(this,login.class);
        startActivity (loginS);
        finish();
    }

    public void signupS(View view) {
        Intent signupS = new Intent(this,signup.class);
        startActivity (signupS);
        finish();
    }


}