package com.example.mymvc.view;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public interface IMvpView {
    String getNum();

    String getType();

    String getyayuntype();

    String getKey();

    void showDialog();

    void dismissDialog();

    void setText(String text);

    void showToast(String msg);
}
