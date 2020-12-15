package com.example.speedcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder>{

    private ArrayList<Car> carsList;
    private OnCarListener mOnCarListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exmeple_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnCarListener);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car currentCar = carsList.get(position);

        holder.imageViewCar.setImageResource(currentCar.getImage_url());
        holder.textViewCarType.setText(currentCar.getType());
        holder.textViewCarTopSpeed.setText(currentCar.getTop_speed());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageViewCar;
        public TextView textViewCarType;
        public TextView textViewCarTopSpeed;

        OnCarListener onCarListener;

        public ViewHolder(@NonNull View itemView, OnCarListener onCarListener) {
            super(itemView);
            imageViewCar = itemView.findViewById(R.id.imageCar);
            textViewCarType = itemView.findViewById(R.id.txtViewType);
            textViewCarTopSpeed = itemView.findViewById(R.id.txtViewMaxSpeed);
            this.onCarListener = onCarListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onCarListener.onCarClick(getAdapterPosition());
        }
    }
    public Adapter(ArrayList<Car> cars, OnCarListener onCarListener)
    {
        carsList = cars;
        mOnCarListener = onCarListener;
    }

    public interface OnCarListener{
        void onCarClick(int position);
    }

}
