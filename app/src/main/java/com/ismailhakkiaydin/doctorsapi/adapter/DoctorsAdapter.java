package com.ismailhakkiaydin.doctorsapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ismailhakkiaydin.doctorsapi.R;

import com.ismailhakkiaydin.doctorsapi.databinding.ListItemBinding;
import com.ismailhakkiaydin.doctorsapi.model.Doctors;

import java.util.ArrayList;
import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorsViewHolder> implements Filterable {

    private Context mContext;
    private List<Doctors> doctorsList;
    private List<Doctors> tempDoctorsList;
    private ItemClickListener mItemClickListener;


    public DoctorsAdapter(Context mContext, List<Doctors> doctorsList, ItemClickListener mItemClickListener) {
        this.mContext = mContext;
        this.doctorsList = doctorsList;
        this.tempDoctorsList = doctorsList;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public DoctorsViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
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

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {

            FilterResults filterResults;

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {


                String searchString = charSequence.toString();
                if (searchString.isEmpty() || searchString.length() == 0) {
                  //  IS_USER_NOT_FOUND_VISIBLE = false;
                    tempDoctorsList = doctorsList;
                } else {
                    List<Doctors> filteredList = new ArrayList<>();
                    for (Doctors doctor : doctorsList) {
                        if (doctor.getFullName().toLowerCase().contains(searchString)) {
                            filteredList.add(doctor);
                        }
                    }
                    tempDoctorsList = filteredList;
                    if (tempDoctorsList.size() == 0) {
                      //  IS_USER_NOT_FOUND_VISIBLE = true;
                    } else {
                      // IS_USER_NOT_FOUND_VISIBLE = false;
                    }
                }
                filterResults = new FilterResults();
                filterResults.values = tempDoctorsList;
                return null;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                tempDoctorsList = (List<Doctors>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


    class DoctorsViewHolder extends RecyclerView.ViewHolder {

        private ListItemBinding mListItemBinding;

        public DoctorsViewHolder(@NonNull ListItemBinding mListItemBinding) {
            super(mListItemBinding.getRoot());
            this.mListItemBinding = mListItemBinding;
        }
    }

}
