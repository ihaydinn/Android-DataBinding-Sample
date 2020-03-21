package com.ismailhakkiaydin.doctorsapi.activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.databinding.ActivityUserStateBinding;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;


public class UserStateActivity extends AppCompatActivity {

    ActivityUserStateBinding mActivityUserStateBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityUserStateBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_state);

        Doctors doctors = getIntent().getExtras().getParcelable("doctors_info");

        mActivityUserStateBinding.setDoctor(doctors);


    }


}
