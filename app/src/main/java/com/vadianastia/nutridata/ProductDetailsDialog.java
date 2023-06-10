package com.vadianastia.nutridata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.vadianastia.nutridata.entities.ProductData;
import com.vadianastia.nutridata.entities.Vitamin;

import java.util.stream.Collectors;

public class ProductDetailsDialog extends DialogFragment {


    private TextView vitaminsTextView;
    private TextView potassiumTextView;
    private TextView proteinTextView;
    private TextView sugarTextView;
    private TextView fiberTextView;
    private TextView naturalTextView;
    private TextView carbohydratesTextView;
    private TextView sodiumTextView;
    private TextView fatTextView;
    private TextView foodGroupTextView;
    private TextView caloriesTextView;
    private TextView descriptionTextView;
    private TextView nameTextView;
    private ImageView imageView;

    private ProductData productData;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);

    }


    private void findViews(View view) {
        vitaminsTextView = view.findViewById(R.id.vitaminsTextView);
        potassiumTextView = view.findViewById(R.id.potassiumTextView);
        proteinTextView = view.findViewById(R.id.proteinTextView);
        sugarTextView = view.findViewById(R.id.sugarTextView);
        fiberTextView = view.findViewById(R.id.fiberTextView);
        naturalTextView = view.findViewById(R.id.naturalTextView);
        carbohydratesTextView = view.findViewById(R.id.carbohydratesTextView);
        sodiumTextView = view.findViewById(R.id.sodiumTextView);
        fatTextView = view.findViewById(R.id.fatTextView);
        foodGroupTextView = view.findViewById(R.id.foodGroupTextView);
        caloriesTextView = view.findViewById(R.id.caloriesTextView);
        descriptionTextView = view.findViewById(R.id.descriptionTextView);
        nameTextView = view.findViewById(R.id.nameTextView);
        imageView = view.findViewById(R.id.imageView);


        vitaminsTextView.setText(productData.getVitamins().stream().map(Vitamin::getName).collect(Collectors.toList()).toString());
        potassiumTextView.setText(String.valueOf(productData.getPotassium()));
        proteinTextView.setText(String.valueOf(productData.getProtein()));
        sugarTextView.setText(String.valueOf(productData.getSugar()));
        fiberTextView.setText(String.valueOf(productData.getFiber()));
        naturalTextView.setText(productData.getIsNatural().toString());
        carbohydratesTextView.setText(String.valueOf(productData.getCarbohydrates()));
        sodiumTextView.setText(String.valueOf(productData.getSodium()));
        fatTextView.setText(String.valueOf(productData.getFat()));
        foodGroupTextView.setText(productData.getFoodGroup().getName());
        caloriesTextView.setText(String.valueOf(productData.getCalories()));
        descriptionTextView.setText(productData.getDescription());
        nameTextView.setText(productData.getName());
        Glide.with(requireContext()).load(productData.getImageUrl()).into(imageView);


    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }
}
