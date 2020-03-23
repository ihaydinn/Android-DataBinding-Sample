package com.ismailhakkiaydin.doctorsapi.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.ui.main.adapter.DoctorsAdapter;
import com.ismailhakkiaydin.doctorsapi.util.ItemClickListener;
import com.ismailhakkiaydin.doctorsapi.databinding.ActivityMainBinding;
import com.ismailhakkiaydin.doctorsapi.network.dto.Doctors;
import com.ismailhakkiaydin.doctorsapi.ui.user_state.UserStateActivity;
import com.ismailhakkiaydin.doctorsapi.ui.main.viewmodel.DoctorsViewModel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SearchView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DoctorsViewModel mDoctorsViewModel;
    private DoctorsAdapter mDoctorsAdapter;
    private List<Doctors> mDoctorsList;
    private ActivityMainBinding activityMainBinding;

    public static boolean CB_GENDER = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView mRecyclerView = activityMainBinding.recyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
        mDoctorsViewModel = ViewModelProviders.of(this).get(DoctorsViewModel.class);
        mDoctorsAdapter = new DoctorsAdapter(this, mDoctorsList, new ItemClickListener() {
            @Override
            public void onItemClick(Doctors doctors, int position) {

                Intent intent = new Intent(getApplicationContext(), UserStateActivity.class);
                intent.putExtra("doctors_info", doctors);
                startActivity(intent);

            }
        });
        mRecyclerView.setAdapter(mDoctorsAdapter);


        mDoctorsViewModel.getAllDoctors().observe(this, new Observer<List<Doctors>>() {
            @Override
            public void onChanged(List<Doctors> doctors) {
                mDoctorsAdapter.setDoctorsList(doctors);
            }
        });


        activityMainBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mDoctorsAdapter.getFilter().filter(query);
                showFoundLayout();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    mDoctorsAdapter.getFilter().filter("");
                }
                return false;
            }
        });

        activityMainBinding.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                showFoundLayout();
                return false;
            }
        });
    }


    public void cbOnClick(View view) {
        switch (view.getId()) {

            case R.id.cbKadin:
                if (((CheckBox) view).isChecked()) {
                    activityMainBinding.cbErkek.setChecked(false);
                    CB_GENDER = true;
                    mDoctorsAdapter.getFilter().filter("female");
                    showFoundLayout();
                } else {
                    CB_GENDER = false;
                    mDoctorsAdapter.getFilter().filter("");
                    showFoundLayout();
                }
                break;
            case R.id.cbErkek:
                if (((CheckBox) view).isChecked()) {
                    activityMainBinding.cbKadin.setChecked(false);
                    CB_GENDER = true;
                    mDoctorsAdapter.getFilter().filter("male");
                    showFoundLayout();
                } else {
                    CB_GENDER = false;
                    mDoctorsAdapter.getFilter().filter("");
                    showFoundLayout();
                }
                break;
        }
    }

    private void showFoundLayout() {
        boolean userNotFoundIsVisible = DoctorsAdapter.IS_USER_NOT_FOUND_VISIBLE;
        if (userNotFoundIsVisible) {
            activityMainBinding.notFound.setVisibility(View.VISIBLE);
            activityMainBinding.recyclerView.setVisibility(View.INVISIBLE);
        } else {
            activityMainBinding.recyclerView.setVisibility(View.VISIBLE);
            activityMainBinding.notFound.setVisibility(View.INVISIBLE);
        }
    }

}