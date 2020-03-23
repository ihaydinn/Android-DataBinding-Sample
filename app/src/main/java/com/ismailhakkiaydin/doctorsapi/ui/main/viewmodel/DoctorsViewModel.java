package com.ismailhakkiaydin.doctorsapi.ui.main.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ismailhakkiaydin.doctorsapi.network.dto.Doctors;
import com.ismailhakkiaydin.doctorsapi.repository.DoctorsRepository;

import java.util.List;

public class DoctorsViewModel extends AndroidViewModel{

    private DoctorsRepository mDoctorsRepository;

    public DoctorsViewModel(@NonNull Application application) {
        super(application);
        mDoctorsRepository = new DoctorsRepository();
    }

    public LiveData<List<Doctors>> getAllDoctors(){
        return mDoctorsRepository.getMutableLiveData();
    }



}
