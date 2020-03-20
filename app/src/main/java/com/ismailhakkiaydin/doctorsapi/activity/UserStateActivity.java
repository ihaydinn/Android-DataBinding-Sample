package com.ismailhakkiaydin.doctorsapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.adapter.DoctorsAdapter;
import com.ismailhakkiaydin.doctorsapi.adapter.ItemClickListener;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;
import com.ismailhakkiaydin.doctorsapi.viewmodel.DoctorsViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserStateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_state);


    }
}
