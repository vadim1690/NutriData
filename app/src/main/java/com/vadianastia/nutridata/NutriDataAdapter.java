package com.vadianastia.nutridata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

public class NutriDataAdapter extends RecyclerView.Adapter<NutriDataAdapter.ViewHolder> {

    private final List<ProductData> mDataSet;
    private final OnProductClickedCallback callback;

    public interface OnProductClickedCallback {
        void onProductClicked(ProductData productData);
    }

    public NutriDataAdapter(List<ProductData> mDataSet, OnProductClickedCallback callback) {
        this.mDataSet = mDataSet;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductData productData = mDataSet.get(position);
        holder.itemView.setOnClickListener(view -> {
            if (callback != null)
                callback.onProductClicked(productData);
        });

        holder.carbohydratesTextView.setText(String.valueOf(productData.getCarbohydrates()));
        holder.sodiumTextView.setText(String.valueOf(productData.getSodium()));
        holder.fatTextView.setText(String.valueOf(productData.getFat()));
        holder.caloriesTextView.setText(String.valueOf(productData.getCalories()));
        holder.nameTextView.setText(productData.getName());
        Glide.with(holder.itemView.getContext()).load(productData.getImageUrl()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView carbohydratesTextView;
        TextView sodiumTextView;
        TextView fatTextView;
        TextView caloriesTextView;
        TextView nameTextView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carbohydratesTextView = itemView.findViewById(R.id.carbohydratesTextView);
            sodiumTextView = itemView.findViewById(R.id.sodiumTextView);
            fatTextView = itemView.findViewById(R.id.fatTextView);
            caloriesTextView = itemView.findViewById(R.id.caloriesTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
