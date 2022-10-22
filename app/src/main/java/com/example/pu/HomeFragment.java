package com.example.pu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class HomeFragment extends Fragment {

    Button register;
    ImageView website;
    ImageView history;
    ImageView e_library;
    RelativeLayout news1;
    RelativeLayout news2;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_home, container,false);

        //Finding IDs for each widget
        register=v.findViewById(R.id.button4);
        website =v.findViewById(R.id.imageView12);
        history =v.findViewById(R.id.imageView16);
        e_library =v.findViewById(R.id.imageView17);
        news1 = v.findViewById(R.id.relativeLayout);
        news2 = v.findViewById(R.id.relative);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               gotoUrl("http://intranet.pentvars.edu.gh/eportal/users.php?userright5=5");
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/");
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.4icu.org/reviews/13091.htm");
            }
        });


        e_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://pentvarslibrary.dotcodeghana.com/");
            }
        });

        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/ministry-of-education-commends-pentecost-university/");
            }
        });

        //news2
        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://pentvars.edu.gh/possess-your-homes-vc-prof-agyapong-kodua-to-parents/");
            }
        });



        return v;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}
