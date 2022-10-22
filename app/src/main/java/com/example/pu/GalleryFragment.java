package com.example.pu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_gallery, container,false);

        ImageSlider imageSlider = (ImageSlider) v.findViewById(R.id.slider);


        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://i2.wp.com/pentvars.edu.gh/wp-content/uploads/2019/12/945A3372.jpg?w=1200&ssl=1","Phase 2"));
        slideModels.add(new SlideModel("https://i0.wp.com/educegh.com/wp-content/uploads/2021/03/FB_IMG_1598026582615.jpg?fit=720%2C480&ssl=1","Main Entrance"));
        slideModels.add(new SlideModel("https://i1.wp.com/pentvars.edu.gh/wp-content/uploads/2018/10/1facebookschoolpic.jpg?resize=768%2C286&ssl=1","Top View"));
        slideModels.add(new SlideModel("https://600429-1942585-raikfcquaxqncofqfm.stackpathdns.com/wp-content/uploads/2021/03/Pentecost-uni-campus.png","Graduate Block"));
        slideModels.add(new SlideModel("https://techafrica.tech/wp-content/uploads/2019/12/Pentecost-University-College.jpg","Campus"));

       imageSlider.setImageList(slideModels,true);




        return v;
    }
}
