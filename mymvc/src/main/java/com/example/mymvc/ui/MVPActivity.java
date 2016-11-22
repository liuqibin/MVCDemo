package com.example.mymvc.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mymvc.R;
import com.example.mymvc.presenter.MvpPresenter;
import com.example.mymvc.view.IMvpView;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class MVPActivity extends AppCompatActivity implements IMvpView, View.OnClickListener {
    //逻辑判断 UI操作
    RadioGroup rg_num, rg_type, rg_yayuntype;
    EditText ed_content;
    TextView tv_show;
    Button bt_submit;
    MvpPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
        presenter = new MvpPresenter(this);
    }

    private void iniView() {
        rg_num = (RadioGroup) findViewById(R.id.rg_num);
        rg_type = (RadioGroup) findViewById(R.id.rg_type);
        rg_yayuntype = (RadioGroup) findViewById(R.id.rg_yayuntype);
        ed_content = (EditText) findViewById(R.id.ed_content);
        tv_show = (TextView) findViewById(R.id.tv_show);
        bt_submit = (Button) findViewById(R.id.bt_sumbit);
        rg_num.check(R.id.rb_5);
        rg_type.check(R.id.rb_tou);
        rg_yayuntype.check(R.id.rb_1ya);
        bt_submit.setOnClickListener(this);
    }

    @Override
    public String getNum() {
        String num = rg_num.getCheckedRadioButtonId() == R.id.rb_5 ? "5" : "7";
        return num;
    }

    @Override
    public String getType() {
        String type = null;
        switch (rg_type.getCheckedRadioButtonId()) {
            case R.id.rb_tou:
                type = "1";
                break;
            case R.id.rb_wei:
                type = "2";
                break;
            case R.id.rb_zhong:
                type = "3";
                break;
            case R.id.rb_add:
                type = "4";
                break;
            case R.id.rb_reduce:
                type = "5";
                break;
        }
        return type;
    }

    @Override
    public String getyayuntype() {
        String yayuntype = null;
        switch (rg_yayuntype.getCheckedRadioButtonId()) {
            case R.id.rb_1ya:
                yayuntype = "1";
                break;
            case R.id.rb_yayun:
                yayuntype = "2";
                break;
            case R.id.rb_4ya:
                yayuntype = "3";
                break;
        }
        return yayuntype;
    }

    @Override
    public String getKey() {
        return ed_content.getText().toString();
    }

    ProgressDialog dialog;

    @Override
    public void showDialog() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在加载");
        dialog.show();
    }


    @Override
    public void dismissDialog() {
        dialog.dismiss();
    }

    @Override
    public void setText(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_show.setText(text);
            }
        });

    }

    @Override
    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToast(msg);
            }
        });
    }

    @Override
    public void onClick(View v) {
        presenter.setData();
    }
}
