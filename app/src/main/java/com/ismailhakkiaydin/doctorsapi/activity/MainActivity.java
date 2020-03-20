package com.ismailhakkiaydin.doctorsapi.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.adapter.DoctorsAdapter;
import com.ismailhakkiaydin.doctorsapi.adapter.ItemClickListener;
import com.ismailhakkiaydin.doctorsapi.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;
import com.ismailhakkiaydin.doctorsapi.viewmodel.DoctorsViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DoctorsViewModel mDoctorsViewModel;
    private DoctorsAdapter mDoctorsAdapter;
   // private List<Doctors> mDoctorsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView mRecyclerView = activityMainBinding.recyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mDoctorsViewModel = ViewModelProviders.of(this).get(DoctorsViewModel.class);
        mDoctorsAdapter = new DoctorsAdapter(this, new ItemClickListener() {
            @Override
            public void onItemClick(Doctors doctors, int position) {

                Intent intent = new Intent(getApplicationContext(), UserStateActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "position : " + position, Toast.LENGTH_SHORT).show();

            }
        });
        mRecyclerView.setAdapter(mDoctorsAdapter);


        mDoctorsViewModel.getAllDoctors().observe(this, new Observer<List<Doctors>>() {
            @Override
            public void onChanged(List<Doctors> doctors) {
                mDoctorsAdapter.setDoctorsList(doctors);
            }
        });



    }
}
