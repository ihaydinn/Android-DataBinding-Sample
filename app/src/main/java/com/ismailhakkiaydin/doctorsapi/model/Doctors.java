package com.ismailhakkiaydin.doctorsapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;


public class Doctors implements Parcelable {

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("user_status")
    private String userStatus;

    @SerializedName("gender")
    private String gender;

    @SerializedName("image")
    private Image image;

    public Doctors(){}

    public String getFullName() {
        return fullName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public Image getImage() {
        return image;
    }

    public String getGender() {
        return gender;
    }

    protected Doctors(Parcel in){
        fullName = in.readString();
        userStatus = in.readString();
    }

    public static final Creator<Doctors> CREATOR = new Creator<Doctors>() {
        @Override
        public Doctors createFromParcel(Parcel source) {
            return new Doctors(source);
        }

        @Override
        public Doctors[] newArray(int size) {
            return new Doctors[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullName);
        dest.writeString(userStatus);

    }
}