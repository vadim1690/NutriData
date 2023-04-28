package com.vadianastia.nutridata;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.vadianastia.nutridata.callbacks.Callback_resultState;
import com.vadianastia.nutridata.common.Constants;
import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NutriData.getInstance().getNutriDataFromProductName("Apple", new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                for (ProductData productData : data) {
                    Log.d(Constants.LOG,"Product name: "+productData.getName()+",Calories: "+productData.getCalories());
                }
            }
            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG,"Error message: "+errorMessage);
            }
        });

    }
}