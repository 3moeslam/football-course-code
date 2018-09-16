package com.sparrow.eslam.football;

public interface NetworkCall<T> {
    void onSuccess(T data);
    void onFail(Throwable throwable);
}
