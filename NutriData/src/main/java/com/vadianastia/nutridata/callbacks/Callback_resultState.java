package com.vadianastia.nutridata.callbacks;

public interface Callback_resultState<T> {
    void onDataLoaded(T data);
    void onError(String errorMessage);
}
