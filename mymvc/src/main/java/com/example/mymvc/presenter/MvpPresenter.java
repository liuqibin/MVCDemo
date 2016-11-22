package com.example.mymvc.presenter;

import com.example.mymvc.bean.CangTouShiBean;
import com.example.mymvc.callback.BeanCallback;
import com.example.mymvc.model.CangTouShiModel;
import com.example.mymvc.view.IMvpView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class MvpPresenter {
    IMvpView iMvpView;
    CangTouShiModel cangTouShiModel;

    public MvpPresenter(IMvpView iMvpView) {
        this.iMvpView = iMvpView;
        this.cangTouShiModel = new CangTouShiModel();
    }

    public void setData() {
        if (iMvpView.getKey().equals("")) {
            iMvpView.showToast("key不能为空");
            return;
        }
        iMvpView.showDialog();
        cangTouShiModel.doRequest(iMvpView.getNum(), iMvpView.getType(), iMvpView.getyayuntype(), iMvpView.getKey(), new BeanCallback<CangTouShiBean>() {
            @Override
            public void onSuccess(CangTouShiBean cangTouShiBean) {
                String msg = "";
                List<String> list = cangTouShiBean.getShowapi_res_body().getList();
                for (String s : list) {
                    msg += s + "\n";
                }
                iMvpView.setText(msg);
                iMvpView.dismissDialog();
            }

            @Override
            public void onError(String msg) {
                iMvpView.showToast(msg);
                iMvpView.dismissDialog();
            }
        });
    }
}
