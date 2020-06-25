package com.itridtechnologies.networkpackages.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itridtechnologies.networkpackages.Models.MasterModel;
extends RecyclerView.Adapter<telenor_call_adapter.callItemViewHolder>

import java.util.ArrayList;

//inner class
public static class callItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private TextView title;
    private TextView price;
    private TextView description;

    public callItemViewHolder(@NonNull View itemView) {

import com.itridtechnologies.networkpackages.R;
        {
            @NonNull
            @Override
            public callItemViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.telenor_call_items, parent, false);
            callItemViewHolder calItemViewHolder = new callItemViewHolder(v);
            return calItemViewHolder;
        }


            @Override
            @Override
            public int getItemCount () {
            return mMasterModelCalls.size();
        }
            public void onBindViewHolder (@NonNull callItemViewHolder holder,int position){

            MasterModel mList = mMasterModelCalls.get(position);

            holder.mImageView.setImageResource(mList.getmImageResource());
            holder.title.setText(mList.getTitle());
            holder.price.setText("Rs. " + String.valueOf(mList.getPrice()));
            holder.description.setText(mList.getDescription());
        }

            public class telenor_call_adapter
            private ArrayList<MasterModel> mMasterModelCalls;