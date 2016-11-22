package com.example.mymvc.interfaces;

import com.example.mymvc.bean.CangTouShiBean;
import com.example.mymvc.callback.BeanCallback;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public interface ICangTouShi {
    //请求数据
    public void doRequest(String num, String type, String yayuntype, String key, BeanCallback<CangTouShiBean> callback);
}
