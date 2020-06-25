package com.itridtechnologies.codenamefive.javaClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itridtechnologies.codenamefive.R;

import java.util.ArrayList;

public class RiderTripHistoryAdapter extends RecyclerView.Adapter<RiderTripHistoryAdapter.TripsViewHolder> {

    private ArrayList<RiderTripDetailRV> mTripList;
    private OnItemClickListener mListener;

    public RiderTripHistoryAdapter(ArrayList<RiderTripDetailRV> mTripList) {
        this.mTripList = mTripList;
    }// super constructor

    //set listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public TripsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rider_trip_detail, parent, false);
        TripsViewHolder tvh = new TripsViewHolder(v, mListener);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TripsViewHolder holder, int position) {
        RiderTripDetailRV currentItem = mTripList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mFromDate.setText(currentItem.getEarningsFromDate());
        holder.mToDate.setText(currentItem.getEarningsToDate());
        holder.mEarnedRupees.setText(String.valueOf(currentItem.getEarnedRupees()));
    }

    @Override
    public int getItemCount() {
        return mTripList.size();
    }

    //onLick interface
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class TripsViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mFromDate;
        public TextView mToDate;
        public TextView mEarnedRupees;

        public TripsViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.nav_next);
            mFromDate = itemView.findViewById(R.id.tv_fromDate);
            mToDate = itemView.findViewById(R.id.tv_toDate);
            mEarnedRupees = itemView.findViewById(R.id.tv_earned_rupees);
            //listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }//end if
                }//onClick
            });
        }// end constructor
    }//inner class VH
}//end class
