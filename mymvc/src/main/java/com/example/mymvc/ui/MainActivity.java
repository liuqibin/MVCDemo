package com.example.mymvc.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymvc.R;
import com.example.mymvc.bean.CangTouShiBean;
import com.example.mymvc.callback.BeanCallback;
import com.example.mymvc.model.CangTouShiModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //逻辑判断 UI操作
    RadioGroup rg_num, rg_type, rg_yayuntype;
    EditText ed_content;
    TextView tv_show;
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        register();
    }

    private void initView() {
        rg_num = (RadioGroup) findViewById(R.id.rg_num);
        rg_type = (RadioGroup) findViewById(R.id.rg_type);
        rg_yayuntype = (RadioGroup) findViewById(R.id.rg_yayuntype);
        ed_content = (EditText) findViewById(R.id.ed_content);
        tv_show = (TextView) findViewById(R.id.tv_show);
        bt_submit = (Button) findViewById(R.id.bt_sumbit);
        rg_num.check(R.id.rb_5);
        rg_type.check(R.id.rb_tou);
        rg_yayuntype.check(R.id.rb_1ya);
    }

    private void register() {
        //逻辑控制
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = ed_content.getText().toString();
                if (TextUtils.isEmpty(key)) {
                    Toast.makeText(MainActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String num = rg_num.getCheckedRadioButtonId() == R.id.rb_5 ? "5" : "7";
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

                final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
                dialog.setTitle("提示");
                dialog.setMessage("正在加载");
                dialog.show();

                CangTouShiModel cangTouShiModel = new CangTouShiModel();
                cangTouShiModel.doRequest(num, type, yayuntype, key, new BeanCallback<CangTouShiBean>() {
                    @Override
                    public void onSuccess(final CangTouShiBean cangTouShiBean) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                List<String> list = cangTouShiBean.getShowapi_res_body().getList();
                                tv_show.setText("");
                                for (String s : list) {
                                    tv_show.append(s + "\n");
                                }
                            }
                        });
                    }

                    @Override
                    public void onError(final String msg) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }

        });
    }
}
