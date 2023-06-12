package com.vadianastia.nutridata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.vadianastia.nutridata.callbacks.Callback_resultState;
import com.vadianastia.nutridata.common.Constants;
import com.vadianastia.nutridata.entities.ProductData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int BY_NAME = 1;
    public static final int BY_FOOD_GROUP = 2;
    public static final int BY_VITAMIN = 3;

    private RecyclerView recyclerView;
    private ProgressBar progress_circular;
    private LinearLayout list_layout;
    private MaterialButton search_by_name_button;
    private MaterialButton search_by_vitamin_button;
    private MaterialButton search_by_food_group_button;
    private MaterialButton search_by_not_natural_button;
    private MaterialButton search_by_natural_button;
    private MaterialButton back_button;
    private MaterialButton full_list_button;
    private SearchView search_view;
    private LinearLayout search_layout;
    int searchType = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        progress_circular = findViewById(R.id.progress_circular);
        back_button = findViewById(R.id.back_button);
        search_by_name_button = findViewById(R.id.search_by_name_button);
        search_by_vitamin_button = findViewById(R.id.search_by_vitamin_button);
        search_by_food_group_button = findViewById(R.id.search_by_food_group_button);
        list_layout = findViewById(R.id.list_layout);
        full_list_button = findViewById(R.id.full_list_button);
        search_layout = findViewById(R.id.search_layout);
        search_view = findViewById(R.id.search_view);
        search_by_natural_button = findViewById(R.id.search_by_natural_button);
        search_by_not_natural_button = findViewById(R.id.search_by_not_natural_button);

        full_list_button.setOnClickListener(view -> fullList());
        search_by_name_button.setOnClickListener(view -> searchByName());
        search_by_vitamin_button.setOnClickListener(view -> searchByVitamin());
        search_by_food_group_button.setOnClickListener(view -> searchByFoodGroup());
        search_by_not_natural_button.setOnClickListener(view -> searchByNatural(false));
        search_by_natural_button.setOnClickListener(view -> searchByNatural(true));
        back_button.setOnClickListener(view -> setOnlyBackButtonLayout(false));
        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query == null || query.isEmpty())
                    recyclerView.setAdapter(null);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && newText.length() > 1)
                    doSearch(newText);
                else {
                    recyclerView.setAdapter(null);
                }
                return false;
            }
        });

    }

    private void searchByNatural(boolean isNatural) {
        setOnlyBackButtonLayout(true);
        recyclerView.setAdapter(null);
        progress_circular.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        NutriData.getInstance().getByIsNatural(isNatural, new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                if (data != null && !data.isEmpty())
                    setRecyclerView(data);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG, "Error message: " + errorMessage);
            }
        });
    }

    private void searchByFoodGroup() {
        search_layout.setVisibility(View.VISIBLE);
        setOnlyBackButtonLayout(true);
        searchType = BY_FOOD_GROUP;
    }

    private void searchByVitamin() {
        search_layout.setVisibility(View.VISIBLE);
        setOnlyBackButtonLayout(true);
        searchType = BY_VITAMIN;
    }

    private void doSearch(String query) {
        progress_circular.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        switch (searchType) {
            case BY_NAME:
                searchByNameInRemote(query);
                break;
            case BY_FOOD_GROUP:
                searchByFoodGroupInRemote(query);
                break;
            case BY_VITAMIN:
                searchByVitaminInRemote(query);
                break;
        }

    }

    private void searchByVitaminInRemote(String query) {
        NutriData.getInstance().getNutriDataByVitamin(query, new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                setRecyclerView(data);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG, "Error message: " + errorMessage);
            }
        });
    }

    private void searchByFoodGroupInRemote(String query) {
        NutriData.getInstance().getNutriDataByFoodGroup(query, new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                setRecyclerView(data);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG, "Error message: " + errorMessage);
            }
        });
    }

    private void searchByNameInRemote(String query) {
        NutriData.getInstance().getNutriDataByProductName(query, new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                setRecyclerView(data);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG, "Error message: " + errorMessage);
            }
        });
    }

    private void setOnlyBackButtonLayout(boolean isOnlyBack) {
        if (isOnlyBack) {
            search_view.setQuery("", false);
            recyclerView.setAdapter(null);
            list_layout.setVisibility(View.VISIBLE);
            full_list_button.setVisibility(View.GONE);
            search_by_name_button.setVisibility(View.GONE);
            search_by_food_group_button.setVisibility(View.GONE);
            search_by_vitamin_button.setVisibility(View.GONE);
            search_by_not_natural_button.setVisibility(View.GONE);
            search_by_natural_button.setVisibility(View.GONE);

            back_button.setVisibility(View.VISIBLE);
        } else {
            search_layout.setVisibility(View.GONE);
            list_layout.setVisibility(View.GONE);
            full_list_button.setVisibility(View.VISIBLE);
            search_by_name_button.setVisibility(View.VISIBLE);
            search_by_food_group_button.setVisibility(View.VISIBLE);
            search_by_vitamin_button.setVisibility(View.VISIBLE);
            search_by_not_natural_button.setVisibility(View.VISIBLE);
            search_by_natural_button.setVisibility(View.VISIBLE);
            back_button.setVisibility(View.GONE);
        }
    }

    private void searchByName() {
        search_layout.setVisibility(View.VISIBLE);
        setOnlyBackButtonLayout(true);
        searchType = BY_NAME;
    }

    private void fullList() {
        setOnlyBackButtonLayout(true);
        progress_circular.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        NutriData.getInstance().getAllNutriData(new Callback_resultState<List<ProductData>>() {
            @Override
            public void onDataLoaded(List<ProductData> data) {
                if (data != null && !data.isEmpty())
                    setRecyclerView(data);
            }

            @Override
            public void onError(String errorMessage) {
                Log.d(Constants.LOG, "Error message: " + errorMessage);
            }
        });
    }

    private void setRecyclerView(List<ProductData> data) {
        progress_circular.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        if (data == null || data.isEmpty()) {
            recyclerView.setAdapter(null);
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NutriDataAdapter(data, this::productClicked));
    }

    private void productClicked(ProductData productData) {
        ProductDetailsDialog dialog = new ProductDetailsDialog();
        dialog.setProductData(productData);
        dialog.show(getSupportFragmentManager(), ProductDetailsDialog.class.getSimpleName());
    }

}