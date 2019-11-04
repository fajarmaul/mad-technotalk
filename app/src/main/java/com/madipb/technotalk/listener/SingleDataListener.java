package com.madipb.technotalk.listener;

public interface SingleDataListener<T> {
    void onSuccess(T data, String successMessage);

    void onFailed(String failedMessage);
}
