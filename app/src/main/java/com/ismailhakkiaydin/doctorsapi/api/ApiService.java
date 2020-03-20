package com.ismailhakkiaydin.doctorsapi.api;

import com.ismailhakkiaydin.doctorsapi.model.DoctorsResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("doctors.json")
    Call<DoctorsResult> getDoctors();

}
