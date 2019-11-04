package com.madipb.technotalk.listener;

import java.util.List;

public interface MultipleDataListener<T> {
    void onSuccess(List<T> datas, String successMessage);

    void onFailed(String failedMessage);
}
