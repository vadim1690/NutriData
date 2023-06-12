package com.vadianastia.nutridata;

import android.util.Log;

import androidx.annotation.NonNull;

import com.vadianastia.nutridata.callbacks.Callback_resultState;
import com.vadianastia.nutridata.common.Constants;
import com.vadianastia.nutridata.entities.FoodGroup;
import com.vadianastia.nutridata.entities.ProductData;
import com.vadianastia.nutridata.entities.Vitamin;
import com.vadianastia.nutridata.remote.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NutriData {
    private static NutriData instance;
    private final Repository repository;

    public static NutriData getInstance() {
        return instance;
    }

    private NutriData() {
        repository = Repository.getInstance();
    }


    public static void initHelper() {
        if (instance == null)
            instance = new NutriData();
    }


    /**
     * The method gets all available NutriData on the API.
     *
     * @param callback_resultState - The callback holds the result of the list of productData.
     */
    public void getAllNutriData(Callback_resultState<List<ProductData>> callback_resultState) {

        Call<List<ProductData>> getAllNutriDataCall = repository.getAllNutriData();
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductData>> call, @NonNull Response<List<ProductData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductData>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method takes a productName and returns a list of productData objects that matches the productName.
     * that contain the productName.
     *
     * @param productName          - The filter parameter we want to filter the list with.
     * @param callback_resultState - The callback holds the result of the list of productData
     *                             that contains the productName, If there is not match at all
     *                             it will hold an empty list.
     */
    public void getNutriDataByProductName(String productName, Callback_resultState<List<ProductData>> callback_resultState) {

        Call<List<ProductData>> getAllNutriDataCall = repository.getAllNutriDataByName(productName);
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductData>> call, @NonNull Response<List<ProductData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductData>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method returns the list of productData that matches the FoodGroup List sent to it as an input.
     *
     * @param foodGroup            - The food group to filter the productData list with.
     * @param callback_resultState - The callback holds the result of the list of productData
     *                             that matches the foodGroup String value.
     */
    public void getNutriDataByFoodGroup(String foodGroup, Callback_resultState<List<ProductData>> callback_resultState) {

        Call<List<ProductData>> getAllNutriDataCall = repository.getAllNutriDataByFoodGroup(foodGroup);
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductData>> call, @NonNull Response<List<ProductData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductData>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });

    }

    /**
     * The method returns the list of productData that matches the vitamins List sent to it as an input.
     *
     * @param vitaminName          - The list of vitamins to filter the list of all productData with.
     * @param callback_resultState - The callback holds the result of the list of productData
     *                             that has the same List of vitamins.
     */
    public void getNutriDataByVitamin(String vitaminName, Callback_resultState<List<ProductData>> callback_resultState) {
        Call<List<ProductData>> getAllNutriDataCall = repository.getAllNutriDataByVitamin(vitaminName);
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductData>> call, @NonNull Response<List<ProductData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductData>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method returns the list of productData that matches isNatural parameter value sent to it as an input.
     *
     * @param isNatural            - The parameter isNatural with the value to filter the productData list with.
     * @param callback_resultState - The callback holds the result of the list of productData that matches the isNatural
     *                             parameter value.
     */
    public void getByIsNatural(boolean isNatural, Callback_resultState<List<ProductData>> callback_resultState) {
        Call<List<ProductData>> getAllNutriDataCall = isNatural ? repository.getAllNaturalNutriData() : repository.getAllNotNaturalNutriData();
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<ProductData>> call, @NonNull Response<List<ProductData>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProductData>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method returns the list of ALL vitamins exist on the API.
     *
     * @param callback_resultState - The callback holds the result of the list of all vitamins.
     */
    public void getAllVitamins(Callback_resultState<List<Vitamin>> callback_resultState) {
        Call<List<Vitamin>> getAllNutriDataCall = repository.getAllVitamins();
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<Vitamin>> call, @NonNull Response<List<Vitamin>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Vitamin>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method returns the list of ALL food group exist on the API.
     *
     * @param callback_resultState - The callback holds the result of the list of all food groups.
     */
    public void getAllFoodGroups(Callback_resultState<List<FoodGroup>> callback_resultState) {
        Call<List<FoodGroup>> getAllNutriDataCall = repository.getAllFoodGroups();
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<List<FoodGroup>> call, @NonNull Response<List<FoodGroup>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<FoodGroup>> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method returns the calories Double that matches the productName sent to it as an input.
     *
     * @param productName          - The parameter productName with the value to filter the productData with.
     * @param callback_resultState - The callback holds the result of calories Double value that matches the productName
     *                             parameter value.
     */
    public void getCalories(String productName, Callback_resultState<Double> callback_resultState) {
        Call<Double> getAllNutriDataCall = repository.getCaloriesForProduct(productName);
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Double> call, @NonNull Response<Double> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Double> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

    /**
     * The method takes a productName and returns a Double value of Sugars that contains the productName.
     *
     * @param productName          -The filter parameter we want to filter the ProductData with.
     * @param callback_resultState - The callback holds the result sugars Double value that
     *                             contains the productName, If there is not match at all
     *                             it will hold a null value.
     */
    public void getSugar(String productName, Callback_resultState<Double> callback_resultState) {
        Call<Double> getAllNutriDataCall = repository.getSugarForProduct(productName);
        getAllNutriDataCall.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NonNull Call<Double> call, @NonNull Response<Double> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(Constants.LOG, "Response was successful : " + response.body());
                    callback_resultState.onDataLoaded(response.body());
                } else {
                    // Failed to fetch data from API...
                    Log.e(Constants.LOG, "Response error  body : " + response.errorBody() + ", Response code: " + response.code());
                    callback_resultState.onError(String.valueOf(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Double> call, @NonNull Throwable t) {
                // Failed to fetch data from API...
                Log.e(Constants.LOG, "Failure!!!, Message: " + t.getMessage() + t.getLocalizedMessage());
                callback_resultState.onError(t.getMessage());
            }

        });
    }

}
