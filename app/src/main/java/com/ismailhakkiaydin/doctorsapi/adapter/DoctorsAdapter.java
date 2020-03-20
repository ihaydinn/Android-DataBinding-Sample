package com.ismailhakkiaydin.doctorsapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.doctorsapi.R;
import com.ismailhakkiaydin.doctorsapi.activity.MainActivity;
import com.ismailhakkiaydin.doctorsapi.activity.UserStateActivity;
import com.ismailhakkiaydin.doctorsapi.databinding.ListItemBinding;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;

import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorsViewHolder>{

    private Context mContext;
    private List<Doctors> doctorsList;
    private ItemClickListener mItemClickListener;

    public DoctorsAdapter(Context mContext, ItemClickListener mItemClickListener) {
        this.mContext = mContext;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding mListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        final DoctorsViewHolder doctorsViewHolder = new DoctorsViewHolder(mListItemBinding);

        mListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mItemClickListener.onItemClick(doctorsList.get(doctorsViewHolder.getAdapterPosition()), doctorsViewHolder.getAdapterPosition());
            }
        });

        return doctorsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsViewHolder holder, int position) {
        Doctors doctors = doctorsList.get(position);
        holder.mListItemBinding.setDoctors(doctors);

    }

    @Override
    public int getItemCount() {
        if (doctorsList != null) {
            return doctorsList.size();
        } else {
            return 0;
        }
    }

    public void setDoctorsList(List<Doctors> doctors) {
        this.doctorsList = doctors;
        notifyDataSetChanged();
    }


    class DoctorsViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding mListItemBinding;

        public DoctorsViewHolder(@NonNull ListItemBinding mListItemBinding) {
            super(mListItemBinding.getRoot());
            this.mListItemBinding = mListItemBinding;
        }
    }

}
