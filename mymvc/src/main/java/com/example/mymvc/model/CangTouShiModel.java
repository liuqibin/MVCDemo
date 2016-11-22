package com.example.mymvc.model;

import android.util.Log;

import com.example.mymvc.bean.CangTouShiBean;
import com.example.mymvc.callback.BeanCallback;
import com.example.mymvc.interfaces.ICangTouShi;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class CangTouShiModel implements ICangTouShi {
    @Override
    public void doRequest(String num, String type, String yayuntype, String key, final BeanCallback<CangTouShiBean> callback) {
        //请求数据
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("showapi_appid", "27165")
                .add("showapi_sign", "5ff3d2adc82d4173a5b71f5098e43151")
                .add("num", num)
                .add("type", type)
                .add("yayuntype", yayuntype)
                .add("key", key)
                .build();
        Request request = new Request.Builder().url("http://route.showapi.com/950-1")
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "--------------" + e.getMessage());
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Gson gson = new Gson();
                CangTouShiBean bean = gson.fromJson(json, CangTouShiBean.class);
                callback.onSuccess(bean);
            }
        });
    }
}
