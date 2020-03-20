package com.ismailhakkiaydin.doctorsapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorsResult {

    @SerializedName("doctors")
    private List<Doctors> doctors = null;

    public List<Doctors> getDoctors() {
        return doctors;
    }

}