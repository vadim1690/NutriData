
# NutriData [![](https://jitpack.io/v/vadim1690/NutriData.svg)](https://jitpack.io/#vadim1690/NutriData)

## Nutrition data library for fast and easy use. 
_Based on api we built._

_Retrofit implementation._ 

_Database that sended by sqlite._

with this library, you can easelly check the products that you wish to know their nutrition data.
Also you can chose and Adjust the search according to your need, dependent on your nutrition preferances, like if the product is natural or not, and vitanmins that is important to you, in your nutition.


## Implemented following use-cases:
* Get all nutri data
* Search by name
* Search by food group
* Search by vitamin
* All natural 
* All not natural

# Getting Started
# Installation
  1. Add in settings.gradle file:
```
      dependencyResolutionManagement {

        repositories {

        maven { url 'https://jitpack.io' }
        }
      }
```
  2. In app build.gradle,
```
    dependencies {
    // ...
	        implementation 'com.github.vadim1690:NutriData:1.0.0.1'
    }
```
  3. Initialize in you App class
```
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NutriData.initHelper();
    }
}
```
# Main functions
  1. Get all nutri data:
```
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
```
  2. Search by name
```
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
```

  3. Search by food group
```
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
```
