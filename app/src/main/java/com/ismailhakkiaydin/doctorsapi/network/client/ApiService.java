package com.ismailhakkiaydin.doctorsapi.network.client;

import com.ismailhakkiaydin.doctorsapi.network.dto.DoctorsResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("doctors.json")
    Call<DoctorsResult> getDoctors();

}
