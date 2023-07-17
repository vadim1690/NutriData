# NutriData

## Nutrition data library for fast and easy use. 
_based on api we built._
_Retrofit implementation._ 
_database that sended by sqlite._

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
      dependencyResolutionManagement {

        repositories {

        maven { url 'https://jitpack.io' }
        }
      }
  2. In app build.gradle,
    dependencies {
    // ...
	        implementation 'com.github.vadim1690:NutriData:1.0.0.1'
    }

