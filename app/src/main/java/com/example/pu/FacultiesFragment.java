package com.example.pu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FacultiesFragment extends Fragment {

    RelativeLayout fhas;
    RelativeLayout fesac;
    RelativeLayout fba;
    RelativeLayout stml;
    ImageView fl;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


       View v =  inflater.inflate(R.layout.fragment_faculties, container,false);

        fhas = v.findViewById(R.id.relativeLayout);
        fesac = v.findViewById(R.id.relativeLayout6);
        fba = v.findViewById(R.id.relativeLayout4);
        stml  = v.findViewById(R.id.relativeLayout5);
        fl = v.findViewById(R.id.imageView13);



        fhas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/faculty/faculty-of-health-and-allied-sciences/");
            }
        });


        fesac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/faculty/faculty-of-engineering-science-and-computing/");
            }
        });


        fba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/faculty/faculty-of-business-administration/");
            }
        });


        stml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/faculty/faculty-of-theology-and-missions/");
            }
        });

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/faculty/faculty-of-engineering-science-and-computing/");
            }
        });






        return v;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
