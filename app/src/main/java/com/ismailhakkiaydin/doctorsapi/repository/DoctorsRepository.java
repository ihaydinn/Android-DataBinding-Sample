package com.ismailhakkiaydin.doctorsapi.repository;

import androidx.lifecycle.MutableLiveData;

import com.ismailhakkiaydin.doctorsapi.api.ApiClient;
import com.ismailhakkiaydin.doctorsapi.api.ApiService;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;
import com.ismailhakkiaydin.doctorsapi.model.DoctorsResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsRepository {

    private ApiService mApiService;
    private List<Doctors> mDoctorsList = new ArrayList<>();
    private MutableLiveData<List<Doctors>> mutableLiveData = new MutableLiveData<>();

    public DoctorsRepository() {
    }

    public MutableLiveData<List<Doctors>> getMutableLiveData() {
        mApiService = ApiClient.getClient().create(ApiService.class);
        Call<DoctorsResult> call = mApiService.getDoctors();
        call.enqueue(new Callback<DoctorsResult>() {
            @Override
            public void onResponse(Call<DoctorsResult> call, Response<DoctorsResult> response) {
                DoctorsResult doctorsResult = response.body();
                if (doctorsResult != null && doctorsResult.getDoctors() != null) {
                    mDoctorsList = doctorsResult.getDoctors();
                    mutableLiveData.setValue(mDoctorsList);
                }

            }

            @Override
            public void onFailure(Call<DoctorsResult> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

}
