package com.ismailhakkiaydin.doctorsapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;
import com.ismailhakkiaydin.doctorsapi.model.Image;


public class UserStateActivity extends AppCompatActivity {


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_state);

        intent = getIntent();

        Doctors doctors = intent.getParcelableExtra("name");

        String s = doctors.getUserStatus();
        TextView tv = findViewById(R.id.tv_state_name);
      //  TextView iv = findViewById(R.id.tv_premium);
        ImageView i = findViewById(R.id.img_user_state);

        tv.setText(doctors.getFullName());
      //  iv.setText(doctors.getUserStatus());
        Glide.with(this).load(doctors.getImage().getUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(i);

     /*   if(doctors.getUserStatus().equals("premium")){
            iv.setText("Premium");
        }else {
            iv.setVisibility(View.GONE);
        }*/

    }


}
