package com.ismailhakkiaydin.doctorsapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.adapters.SearchViewBindingAdapter;

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


    @BindingAdapter("loadState")
    public static void loadState(TextView view, CharSequence text) {
        if (text.equals("premium")) {
            view.setText("Premium");

            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }

    }


    public Doctors() {
    }

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fullName);
        dest.writeString(this.userStatus);
        dest.writeString(this.gender);
        dest.writeParcelable((Parcelable) this.image, flags);
    }

    protected Doctors(Parcel in) {
        this.fullName = in.readString();
        this.userStatus = in.readString();
        this.gender = in.readString();
        this.image = in.readParcelable(Image.class.getClassLoader());
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
}