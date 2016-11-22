package com.example.mymvc.callback;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public interface BeanCallback<T> {

    public void onSuccess(T t);

    public void onError(String msg);
}
